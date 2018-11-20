# spring cloud
####项目访问地址：
http://localhost:8764/
####效果查看-启动步骤：
1：启动一个eureka server 端口8761
2：启动两个eureka client 端口8762 8763  [先打包，如果打包不能成果，则把pom.xml 相对路径配置一下]
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
3：启动eureka-ribbon-client
4: http://127.0.0.1:8764/hi [依次轮询8762，8763 端口] 
-----------------------------------------------------------------
####效果ribbon查看-启动步骤：
1：启动一个eureka server 端口8761
2：启动两个eureka client 端口8762 8763  [先打包，如果打包不能成果，则把pom.xml 相对路径配置一下]
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
3：启动eureka-ribbon-client
4: http://127.0.0.1:8764/test-ribbon [依次轮询8762，8763 端口] 
-------------------------------------------------------------------
####熔断器
1.添加熔断器依赖，在启动类上加上熔断器注解。
2.在方法上加上熔断器注解。
####查看效果
1：启动一个eureka server 端口8761
2：启动两个eureka client 端口8762 8763  [先打包，如果打包不能成果，则把pom.xml 相对路径配置一下]
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
3：启动eureka-ribbon-client
4: http://localhost:8764/hi?name=jie [依次轮询8762，8763 端口](服务正常时显示)
5：关闭eureka client [模拟服务异常](浏览器指定快速失败，这就是熔断器的效果)
 


