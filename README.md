# Spring-Cloud Demo
**项目使用Springboot与SpringCloud，注册中心使用Eureka和Consul，服务之间使用Feign进行调用**
## 模块说明
* common                公共模块
* consul-order          消费者-注册中心使用Consul
* consul-product        生产者-注册中心使用Consul
* eureka-server         Eureka注册中心
* hystrix-order         开启hystrix熔断的消费者 服务之间使用Feign调用
* hystrix-product       开启hystrix熔断的生产者 服务之间使用Feign调用
* hystrix-order-rest    开启hystrix熔断的消费者 服务之间使用RestTemplate调用
* hystrix-product-rest  开启hystrix熔断的生产者 服务之间使用RestTemplate调用
* order                 消费者
* product               生产者