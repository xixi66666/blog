package com.example.demo.controller;

import com.example.demo.bean.BlogInfo;
import com.example.demo.service.implement.BlogEditorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class BlogEditorController {

    @Autowired
    private BlogEditorServiceImpl blogEditorService;

    @RequestMapping("/toBlogEditor")
    public String showEditorPage(){
        return "blogEditor";
    }

    @RequestMapping(value = "/handOnBlog", produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String handOnBlog(@RequestBody String data) {
        try {
            String[] decode = URLDecoder.decode(data, "utf-8").split("&");
            for (int i = 0; i < decode.length; i++) {
                decode[i] = decode[i].substring(decode[i].indexOf("=") + 1);
            }
            BlogInfo blogInfo = new BlogInfo(1, 1, decode[1], decode[0], decode[2], 0, new Timestamp(new Date().getTime()), 0, 0, 0, 0, "remain_words");
            blogEditorService.insertBlog(blogInfo);
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/saveToDraft", produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String saveToDraft(@RequestBody String data) {
        try {
            String[] decode = URLDecoder.decode(data, "utf-8").split("&");
            for (int i = 0; i < decode.length; i++) {
                decode[i] = decode[i].substring(decode[i].indexOf("=") + 1);
            }
            BlogInfo blogInfo = new BlogInfo(1, 1, decode[1], decode[0], decode[2], 0, new Timestamp(new Date().getTime()), 0, 0, 1, 0, "remain_words");
            blogEditorService.insertBlog(blogInfo);
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/content")
    public String showContent() {
        System.out.println("调用了content");
        return "blogcontent.html";
    }

    @RequestMapping("/findBlogContentByID/{blogID}")
    @ResponseBody
    public BlogInfo findBlogContentByID(@PathVariable("blogID") long id) {
        BlogInfo blog = blogEditorService.findBlogByBlogID(id);
        return blog;
    }

    @RequestMapping("/addAgreeNum/{blogid}")
    @ResponseBody
    public void addAgreeNum(@PathVariable("blogid") long id) {
        blogEditorService.addAgreeNum(id);
    }

    @RequestMapping("/getAgreeNum/{blogid}")
    @ResponseBody
    public long getAgreeNum(@PathVariable("blogid") long id) {
        return blogEditorService.getAgreeNum(id);
    }

    @RequestMapping("/addCommentNum/{blogid}")
    @ResponseBody
    public void addCommentNum(@PathVariable("blogid") long id) {
        blogEditorService.addCommentNum(id);
    }

    @RequestMapping("reduceCommentNum/{blogid}")
    @ResponseBody
    public void reduceCommentNum(@PathVariable("blogid") long id) {
        blogEditorService.reduceCommentNum(id);
    }

    @RequestMapping("/getCommentNum/{blogid}")
    @ResponseBody
    public long getCommentNum(@PathVariable("blogid") long id) {
        return blogEditorService.getCommentNum(id);
    }

    @RequestMapping("/getViewNum/{blogid}")
    @ResponseBody
    public long getViewNum(@PathVariable("blogid") long id) {
        return blogEditorService.getViewNum(id);
    }

    @RequestMapping("/addViewNum/{blogid}")
    @ResponseBody
    public void addViewNum(@PathVariable("blogid") long id) {
        blogEditorService.addViewNum(id);
    }

    @RequestMapping("/updateBlogFromDraftToFormal/{blogID}")
    @ResponseBody
    public void updateBlogFromDraftToFormal(@RequestBody String data, @PathVariable("blogID") long id) {
        try {
            String[] decode = URLDecoder.decode(data, "utf-8").split("&");
            for (int i = 0; i < decode.length; i++) {
                decode[i] = decode[i].substring(decode[i].indexOf("=") + 1);
            }
            BlogInfo blogInfo = new BlogInfo(id, 1, decode[1], decode[0], decode[2], 0, new Timestamp(new Date().getTime()), 0, 0, 0, 0, "remain_words");
            blogEditorService.updateBlogFromDraftToFormal(blogInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateBlogFromDraftToDraft/{blogID}")
    @ResponseBody
    public void updateBlogFromDraftToDraft(@RequestBody String data, @PathVariable("blogID") long id) {
        try {
            String[] decode = URLDecoder.decode(data, "utf-8").split("&");
            for (int i = 0; i < decode.length; i++) {
                decode[i] = decode[i].substring(decode[i].indexOf("=") + 1);
            }
            BlogInfo blogInfo = new BlogInfo(id, 1, decode[1], decode[0], decode[2], 0, new Timestamp(new Date().getTime()), 0, 0, 1, 0, "remain_words");
            blogEditorService.updateBlogFromDraftToDraft(blogInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/loadAllUser")
    @ResponseBody
    public List<String> loadAllUser() {
        return blogEditorService.loadAllUser();
    }

    @RequestMapping("/findBlogsByView")
    @ResponseBody
    public BlogInfo[] findBlogsByView() {
        return blogEditorService.findBlogsByView();
    }
}
