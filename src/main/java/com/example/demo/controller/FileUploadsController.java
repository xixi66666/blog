package com.example.demo.controller;

import com.example.demo.config.ReturnParam;
import com.example.demo.config.UploadConstant;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileUploadsController {
//    @Value("${file.upload.path}")
//    private String pathUrl;//上传地址


    /**
     * 上传博客文章图片
     *
     * @param file 文件
     * @return
     */
    @ResponseBody
    @PostMapping("/blogEditor")
    public Map blogEditor(@RequestParam("file") MultipartFile file) {
        try {
//            if (file.isEmpty()){
//                return ReturnParam.error("上传失败");
//            }
            String fileName = file.getOriginalFilename(); //获取上传文件原来的名称
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;

            //---------------------------------------解决文件重名问题
            //String filePath = "http://47.97.212.131:8080/upload/" + fileName;
            String url = "localhost:8080" + "/upload/" + fileName;
            File localFile = new File(UploadConstant.DEV_UPLOAD_PATH + fileName);
            file.transferTo(localFile); //把上传的文件保存至本地

            System.out.println(file.getOriginalFilename()+" 上传成功");
            Map<String, Object> map = new HashMap<>();
            map.put("errno", 0);
            Map<String, Object> mapInside = new HashMap<>();
            mapInside.put("url", "http://" + url);///image/1230png
            mapInside.put("alt", "");
            mapInside.put("href", "");
            map.put("data", mapInside);
            return map;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }



}
