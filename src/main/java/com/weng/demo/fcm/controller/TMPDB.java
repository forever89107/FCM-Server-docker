package com.weng.demo.fcm.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class TMPDB {
    public static final Map<String, String> userToken = new TreeMap<>();
    private Logger Logger = LoggerFactory.getLogger(PushNotificationController.class);

    public void addDevice(String deviceId, String fcmToken) {
        userToken.put(deviceId, fcmToken);
        Logger.info("資料庫中查詢[{}]，查詢結果[{}]", deviceId, userToken.get(deviceId));
    }

    public String getAlltoken(){
        return new Gson().toJson(userToken.toString());
    }

    public String getOneToken(String deviceId){
        return userToken.get(deviceId);
    }
}
