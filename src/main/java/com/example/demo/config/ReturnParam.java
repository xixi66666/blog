package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnParam {
    private Integer status;
    private String message;
    private Object object;

    public static ReturnParam success(String massage){
        return new ReturnParam(200,massage,null);
    }

    public static ReturnParam success(Object obj){
        return new ReturnParam(200,"请求成功！",obj);
    }

    public static ReturnParam success(String message,Object object){
        return new ReturnParam(200,message,object);
    }

    public static ReturnParam error(String message){
        return new ReturnParam(501,message,null);
    }

    public static ReturnParam error(Integer code,String message){
        return new ReturnParam(code,message,null);
    }

    public static ReturnParam error(String message,Object object){
        return new ReturnParam(501,message,object);
    }
}
