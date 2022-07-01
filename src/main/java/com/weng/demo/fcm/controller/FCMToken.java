package com.weng.demo.fcm.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FCMToken {
    private String deviceId;
    private String fcmToken;
}
