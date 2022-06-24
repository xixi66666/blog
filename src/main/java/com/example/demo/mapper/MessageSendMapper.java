package com.example.demo.mapper;

import com.example.demo.bean.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageSendMapper {

    @Select("select count(*) from message")
    public int getMessageRecordNumber();

    @Insert("insert into message (sender, receiver, content, picture, time, isreceived) values(#{msg.sender}, #{msg.receiver}, #{msg.content}, #{msg.image}, #{msg.date}, #{msg.isreceived})")
    public int insertMessageRecord(@Param("msg")Message message);

    @Select("select User_ID from user_info where User_name = #{userName}")
    public int findUserIDByName(String userName);

    @Select("select content from message where receiver = #{receiver} and isreceived = 0")
    public String[] findUnreceivedRecord(long receiver);

    @Select("select * from message where (sender = #{userid1} and receiver = #{userid2}) or (sender = #{userid2} and receiver = #{userid1}) order by time")
    public Message[] findRelatedRecord(@Param("userid1")long userid1, @Param("userid2")long userid2);



}
