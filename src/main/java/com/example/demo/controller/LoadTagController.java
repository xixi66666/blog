package com.example.demo.controller;

import com.example.demo.bean.Tag;
import com.example.demo.service.implement.TagManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoadTagController {

    @Autowired
    private TagManagementServiceImpl tagManagementService;

    @RequestMapping("/find1/{blog}")
    @ResponseBody
    public Map<String, String> find1(@PathVariable("blog") long blog) {
        int[] tagIDByBlog = tagManagementService.findTagIDByBlog(blog);
        Map<String, String> map = new HashMap<>();
        for (int i : tagIDByBlog) {
            Tag tag = tagManagementService.fingTagContentByTanID(i);
            System.out.println(tag);
            map.put(tag.getName(), tag.getDescription());
        }
        return map;
    }

    @RequestMapping("/loadAllTags")
    @ResponseBody
    public Tag[] loadAllTags(){
        return tagManagementService.findAllTags();
    }

}
