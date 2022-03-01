
### ＥＮＶ
* springboot http-server (oracle 8)
* firebase-admin(6.8.1)

#### API Test
```
post -- http://url:8890/notification/topic
header:
[{"key":"Content-type","value":"application/json","description":""},
{"key":"Authorization","value":" u'r fcm Server key","description":""}]
body:
    {"title":"Hello", "message":"The message is jason test", "topic":"contactTopic"}
```
```
post -- http://url:8890/notification/token
header:
[{"key":"Content-type","value":"application/json","description":""},
{"key":"Authorization","value":" u'r fcm Server key","description":""}]
body:
    {"title":"Hello", "message":"The message is ...... ", , "token":"u'r device specific token"}
```
```
post -- http://url:8890/notification/data
header:
[{"key":"Content-type","value":"application/json","description":""},
{"key":"Authorization","value":" u'r fcm Server key","description":""}]
body:
    {"title":"Hello", "message":"Data message...... ", , "token":"u'r device specific token"}
```
