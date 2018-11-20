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
-------------------------------------------------------
####在feign 加熔断器
1.在接口上加fallback 快速失败的处理类。该处理类是作为feign熔断器的逻辑处理类，必须实现被@FeignClient修改的接口。
2.该类需要实现EurekaClientFeign接口.
3.查看效果：
    1：启动一个eureka server 端口8761
    2：启动两个eureka client 端口8762 8763  [先打包，如果打包不能成果，则把pom.xml 相对路径配置一下]
       java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
       java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
    3：启动eureka-feign-client
    4: http://127.0.0.1:8765/hi [依次轮询8762，8763 端口] 
    5: 结果显示feign client  有负载均衡的能力
    6:关闭eureka client[模拟服务异常] (执行快速失败)  
    

