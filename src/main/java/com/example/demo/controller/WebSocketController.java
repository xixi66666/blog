package com.example.demo.controller;

import com.example.demo.bean.Message;
import com.example.demo.bean.SocketMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 经综合考虑，为每一位用户分配与用户ID相同的Session ID以便于管理（用户不可见，通过Request请求进行交互，不能用户自己改变，只能通过请求协议进行交互）
 */

@ServerEndpoint("/websocket/{nickname}")
@Component
public class WebSocketController {

    private static CopyOnWriteArraySet<WebSocketController> webSocketSet = new CopyOnWriteArraySet<WebSocketController>();

    //String:用户名 | String:实际对话域
    private static Map<String, String> mapOfSessionAndUser = new HashMap<>();

    //String:SessionID | Session:实际对话域
    private static Map<String, Session> map = new HashMap<>();

    private Session session;

    private String nickname;

    /*
    * 待解决问题：此对象为空，如何在WebSocket层解决数据库访问问题
    * */


    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) throws IOException {
        this.session = session;
        this.nickname = nickname;
        mapOfSessionAndUser.put(nickname, session.getId());
        map.put(session.getId(), session);
        webSocketSet.add(this);
        System.out.println("有新连接加入，昵称为：" + nickname + "当前在线人数为" + webSocketSet.size());
        this.session.getAsyncRemote().sendText("恭喜" + nickname + "成功连接上WebSocket(其频道号：" + session.getId() + ")-->当前在线人数为：" + webSocketSet.size());
        RestTemplate restTemplate = new RestTemplate();
        List<String> unReceivedRecord = (List<String>) restTemplate.getForObject("http://127.0.0.1:8080/searchUnreceivedRecord/{1}", Object.class, nickname);
        System.out.println(unReceivedRecord);
        this.session.getBasicRemote().sendText("您有一些离线消息需要处理：");
        for (String msg:
             unReceivedRecord) {
            this.session.getBasicRemote().sendText(msg);
        }

    }

    @OnClose
    public void onClose() {
        mapOfSessionAndUser.remove(nickname, session.getId());
        map.remove(session.getId(), session);
        webSocketSet.remove(this);
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
//        System.out.println("来自客户端的消息-->" + nickname + ":" + message);
//        ObjectMapper objectMapper = new ObjectMapper();
//        SocketMessage socketMessage;
//        try {
//            socketMessage = objectMapper.readValue(message, SocketMessage.class);
//            if (socketMessage.getType() == 1) { //进入此分支则说明此条信息为正常的单聊信息
//                socketMessage.setFromUser(session.getId());
//                System.out.println(session.getId());
//                Session fromSession = map.get(socketMessage.getFromUser());
//                Session toSession = map.get(socketMessage.getToUser());
//                if (toSession != null) {
//                    fromSession.getAsyncRemote().sendText(nickname + "：" + socketMessage.getMsg());
//                    toSession.getAsyncRemote().sendText(nickname + "：" + socketMessage.getMsg());
//                } else {
//                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线或者您输入的频道号不对");
//                }
//            } else {
//                broadcast(nickname + ": " + socketMessage.getMsg());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("来自客户端的消息-->" + nickname + ":" + message);
        ObjectMapper objectMapper = new ObjectMapper();
        SocketMessage socketMessage;
        try {
            socketMessage = objectMapper.readValue(message, SocketMessage.class);
            if (socketMessage.getType() == 1) {
                socketMessage.setFromUser(nickname);
                Session fromSession = map.get(mapOfSessionAndUser.get(nickname));
                Session toSession = map.get(mapOfSessionAndUser.get(socketMessage.getToUser()));
                if (toSession != null) {
                    synchronized (session) {
                        fromSession.getAsyncRemote().sendText(nickname + "：" + socketMessage.getMsg());
                        toSession.getAsyncRemote().sendText(nickname + "：" + socketMessage.getMsg());
                    }
                } else {
                    synchronized (session) {
                        fromSession.getAsyncRemote().sendText("对方离线或隐身，请等待对方上线后进行回复\n" + nickname + "：" + socketMessage.getMsg());
                    }
                }
            } else {
                broadcast(nickname + ": " + socketMessage.getMsg());
            }
            RestTemplate restTemplate = new RestTemplate();
            System.out.println(socketMessage);
            restTemplate.getForObject("http://127.0.0.1:8080/storeMessage/{1}/{2}/{3}/{4}/{5}/{6}/{7}", Message.class, 1, socketMessage.getFromUser(), socketMessage.getToUser(), socketMessage.getMsg(), new byte[5], new Timestamp(new Date().getTime()), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public void broadcast(String message) {
        for (WebSocketController item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

}
