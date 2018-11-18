# spring cloud
####项目访问地址：
http://localhost:8765/hi
####效果查看-启动步骤：
1：启动一个eureka server 端口8761
2：启动两个eureka client 端口8762 8763  [先打包，如果打包不能成果，则把pom.xml 相对路径配置一下]
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
3：启动eureka-feign-client
4: http://127.0.0.1:8765/hi [依次轮询8762，8763 端口] 
5: 结果显示feign client  有负载均衡的能力
  

