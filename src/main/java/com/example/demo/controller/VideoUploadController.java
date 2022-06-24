package com.example.demo.controller;

import com.example.demo.config.UploadConstant;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class VideoUploadController {

    @ResponseBody
    @PostMapping("/videoUpload")
    public synchronized Map uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        try {
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
            mapInside.put("url", "http://" + url);
            map.put("data", mapInside);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
