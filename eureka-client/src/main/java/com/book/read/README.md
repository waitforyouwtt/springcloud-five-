# spring cloud
####项目访问地址：
http://localhost:8762/
####开启服务注册功能：
@EnableEurekaClient
####项目启动有先后顺序，先启动eureka server,再启动eureka client ,不然报错：找不到注册中心
测试：http://localhost:8762/index?name=jie

看成果：  
项目打包，运行jar 包：

Java -jar xxx.jar --spring.profiles.active=peer1

java -jar xxx.jar --spring.profiles.active=peer2

启动eureka client 
