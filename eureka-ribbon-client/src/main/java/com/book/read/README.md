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
-----------------------------------------------------------------------
####使用Hystrix Dashboard
0.pom.xml:
  [		<dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-starter-hystrix</artifactId>
   		</dependency>
   
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-actuator</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-starter-hystrix</artifactId>
   		</dependency>
   ]
1.在启动类上加@EnableHystrixDashboard
####查看效果 
1：启动一个eureka server 端口8761
2：启动两个eureka client 端口8762 8763  [先打包，如果打包不能成果，则把pom.xml 相对路径配置一下]
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8762
   java -jar .\eureka-client-0.0.1-SNAPSHOT.jar --server.port=8763
3：启动eureka-ribbon-client
4: http://localhost:8764/hi?name=jie [依次轮询8762，8763 端口](服务正常时显示)
5：http://localhost:8764/hystrix.stream[浏览器访问，显示熔断器的数据指标]
6：http://localhost:8764/hystrix[浏览器访问，显示dashboard 监控台]
ping: 
data: {"type":"HystrixCommand","name":"hi","group":"RibbonService","currentTime":1542726748518,"isCircuitBreakerOpen":false,"errorPercentage":0,"errorCount":0,"requestCount":0,"rollingCountBadRequests":0,"rollingCountCollapsedRequests":0,"rollingCountEmit":0,"rollingCountExceptionsThrown":0,"rollingCountFailure":0,"rollingCountFallbackEmit":0,"rollingCountFallbackFailure":0,"rollingCountFallbackMissing":0,"rollingCountFallbackRejection":0,"rollingCountFallbackSuccess":0,"rollingCountResponsesFromCache":0,"rollingCountSemaphoreRejected":0,"rollingCountShortCircuited":0,"rollingCountSuccess":0,"rollingCountThreadPoolRejected":0,"rollingCountTimeout":0,"currentConcurrentExecutionCount":0,"rollingMaxConcurrentExecutionCount":0,"latencyExecute_mean":7,"latencyExecute":{"0":5,"25":5,"50":5,"75":9,"90":9,"95":9,"99":9,"99.5":9,"100":9},"latencyTotal_mean":7,"latencyTotal":{"0":5,"25":5,"50":5,"75":9,"90":9,"95":9,"99":9,"99.5":9,"100":9},"propertyValue_circuitBreakerRequestVolumeThreshold":20,"propertyValue_circuitBreakerSleepWindowInMilliseconds":5000,"propertyValue_circuitBreakerErrorThresholdPercentage":50,"propertyValue_circuitBreakerForceOpen":false,"propertyValue_circuitBreakerForceClosed":false,"propertyValue_circuitBreakerEnabled":true,"propertyValue_executionIsolationStrategy":"THREAD","propertyValue_executionIsolationThreadTimeoutInMilliseconds":1000,"propertyValue_executionTimeoutInMilliseconds":1000,"propertyValue_executionIsolationThreadInterruptOnTimeout":true,"propertyValue_executionIsolationThreadPoolKeyOverride":null,"propertyValue_executionIsolationSemaphoreMaxConcurrentRequests":10,"propertyValue_fallbackIsolationSemaphoreMaxConcurrentRequests":10,"propertyValue_metricsRollingStatisticalWindowInMilliseconds":10000,"propertyValue_requestCacheEnabled":true,"propertyValue_requestLogEnabled":true,"reportingHosts":1,"threadPool":"RibbonService"}


