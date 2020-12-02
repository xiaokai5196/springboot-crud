package com.dict.emp.common;


import com.alibaba.fastjson.JSONObject;

public class ReturnUtil {

    public static final String RETRUN_CODE_NAME = "code";
    public static final String RETRUN_MSG_NAME = "msg";
    public static final String RETRUN_BODY_NAME = "content";

    public static final Integer SUCCESS_CODE = 0;
    public static final Integer ERROR_CODE = -1;


    public static JSONObject baseResult(int code, String message){
        JSONObject result = new JSONObject();
        result.put(RETRUN_CODE_NAME, code);
        result.put(RETRUN_MSG_NAME, message);
        return result;
    }

    public static JSONObject baseResult(int code, String message, Object content){
        JSONObject result = new JSONObject();
        result.put(RETRUN_CODE_NAME, code);
        result.put(RETRUN_MSG_NAME, message);
        result.put(RETRUN_BODY_NAME, content);
        return result;
    }

    // 返回成功，不带数据
    public static JSONObject returnSuccess(String message){
        return baseResult(SUCCESS_CODE, message);
    }

    // 返回失败
    public static JSONObject returnError(String message){
        return baseResult(ERROR_CODE, message);
    }

    //返回成功，带数据
    public static JSONObject returnSuccess(String message, Object content){
        return baseResult(SUCCESS_CODE, message, content);
    }







}
