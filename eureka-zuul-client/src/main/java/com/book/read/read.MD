####ZUUL 的配置注意：
1.zuul:
    routes:
      hiapi:
        path: /hiapi/**
        serviceId: eureka-client

######上述这两个配置就可以将以""hiapi"开头的Url 路由到eureka-client。hiapi 是自己定义的，需要指定它的path 和serviceId,两者
######配合使用，就可以将指定类型的请求Url 路由到指定的serviceId。            


####查看效果：
1.启动eureka-server
2.启动eureka-client
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
3.启动eureka-ribbon-client
4.启动eureka-feign-client
5.启动eureka-zuul-client
6.访问：http://localhost:5000/hiapi/hi?name=jie[轮询： hi:jiehow are you?8763 hi:jiehow are you?8762 ](负载均衡的体现)
7.访问：[http://localhost:5000/ribbonapi/hi?name=jie  |  http://localhost:5000/feignapi/hi?name=jie] (这就是负载均衡)
----------------------------------------------------------------------------
如果加版本号，则在yml 如上配置，访问：[http://localhost:5000/v1/feignapi/hi?name=jie](负载均衡，一样的效果)

----------------------------------------------------------------------------
####在zuul 上配置熔断器
    zuul 作为netflix 组件，可以与ribbon,eureka ,hystrix 等组件相结合，实现负载均衡，熔断器的功能。
    在zuul 中实现熔断功能需要实现ZuulFallbackProvider 接口。getRoute 用于指定熔断功能应用于哪些路
    由的服务"eureka-client","*"则代表所有的服务。代码中用*。
    
 访问：[http://localhost:5000/v1/hiapi/hi?name=jie](想看效果，关闭一个服务即可)
 #### zuul 上使用过滤器
 1.zuul 实现过滤器只需要集成ZuulFilter，并实现ZuulFilter 中的抽象方法，filterType() 和 filterOrder()
   是过滤器的类型，共有四种：pre 过滤器   routing 过滤器   post 过滤器   error 过滤器
   filterOrder() 是过滤顺序，它是一个int 类型的值，值越小，越早执行该过滤器
   shouldFilter() 表示该过滤器是否过滤逻辑，如果为true,则执行 run()方法，如果未false ，则不执行run()方法，run()
   方法写具体的过滤逻辑。
 访问：[http://localhost:5000/v1/hiapi/hi?name=jie&token=2345](可以正常访问，去掉token则不可以访问，这就是过滤器)  


