# 載入openjdk
FROM openjdk:8-jdk-alpine


# 加入bash功能
RUN apk add --no-cache bash


# 將檢測MySQL是否Ready的腳本加入
COPY wait-for-it.sh /wait-for-it.sh


# 調整權限
RUN chmod +x /wait-for-it.sh


# 將目標WAR放入Docker Image中
ADD demo-0.0.1-snapshot.jar .

# 此對外Port設定
EXPOSE 8890