package cn.lkpttxg.sept2.worldofzuul.bean;

import cn.lkpttxg.sept2.worldofzuul.common.consts.Settings;
import cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode.ResultCode;

/**
 * @author TXG
 * @date 2022/6/28$
 */
public class ResultGenerator {
    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResponseData genSuccessResult(){
        return new ResponseData().setVersion(Settings.VERSION)
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T>ResponseData genSuccessResult(T data){
        return new ResponseData<T>().setVersion(Settings.VERSION)
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResponseData genFailResult(String message){
        return new ResponseData().setVersion(Settings.VERSION)
                .setCode(ResultCode.NOT_FOUND)
                .setMessage(message);
    }

    public static <T>ResponseData genFailResult(String message,T data){
        return new ResponseData<T>().setVersion(Settings.VERSION)
                .setCode(ResultCode.NOT_FOUND)
                .setMessage(message)
                .setData(data);
    }

    public static ResponseData genOtherResult(ResultCode resultCode,String message){
        return new ResponseData().setVersion(Settings.VERSION)
                .setCode(resultCode)
                .setMessage(message);
    }

    public static <T>ResponseData genOtherResult(ResultCode resultCode,String message,T data){
        return new ResponseData<T>().setVersion(Settings.VERSION)
                .setCode(resultCode)
                .setMessage(message)
                .setData(data);
    }
}
