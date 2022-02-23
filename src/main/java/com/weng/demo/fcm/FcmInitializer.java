package com.weng.demo.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * FCMInitializer
 */
@Configuration
public class FcmInitializer {
   private static final Logger logger = LoggerFactory.getLogger(FcmInitializer.class);
      @Value("${app.firebase-configuration-file}")
      private String firebaseConfigPath;

      @PostConstruct
      public void initialize() {
         try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())).build();
            if (FirebaseApp.getApps().isEmpty()) {
               FirebaseApp.initializeApp(options);
               logger.info("Firebase application has been initialized");
            }
         } catch (IOException e) {
            logger.error(e.getMessage());
         }
      }
}
