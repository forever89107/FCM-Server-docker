package com.weng.demo.fcm.controller;

import com.weng.demo.fcm.model.PushNotificationRequest;
import com.weng.demo.fcm.model.PushNotificationResponse;
import com.weng.demo.fcm.service.FCMService;
import com.weng.demo.fcm.service.PushNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jason Weng
 * @date
 */
@RestController
public class PushNotificationController {
    private Logger Logger = LoggerFactory.getLogger(PushNotificationController.class);

    private PushNotificationService pushNotificationService;
    private TMPDB tmdb;

    @Autowired
    public PushNotificationController(PushNotificationService pushNotificationService, TMPDB tmdb) {
        this.pushNotificationService = pushNotificationService;
        this.tmdb = tmdb;
    }


    @PostMapping("/registerToken")
    public ResponseEntity registerFCMToken(@RequestBody FCMToken request) {
        tmdb.addDevice(request.getDeviceId(), request.getFcmToken());
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "device add"), HttpStatus.OK);
    }

    @PostMapping("/getAllToken")
    public ResponseEntity getAlltoken() {
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), tmdb.getAlltoken()), HttpStatus.OK);
    }

    @GetMapping("/getOneToken/{deviceId}")
    public ResponseEntity getOneToken(@PathVariable("deviceId") String deviceId) {
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), tmdb.getOneToken(deviceId)), HttpStatus.OK);
    }

    @PostMapping("/notification/topic")
    public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationWithoutData(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification(topic) has been sent."), HttpStatus.OK);
    }

    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification(token) has been sent."), HttpStatus.OK);
    }

    @PostMapping("/notification/data")
    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotification(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification(data) has been sent."), HttpStatus.OK);
    }
}
