参考书籍：《深入浅出springboot2.x》
一、引入依赖：
只是在默认的情况下 spring-boot starter data redis
版本 2.x 会依赖Lettuce的Redis客户端驱动，而在一般的项目中，我们使用Jedis ，所以在代码
中使用了＜exclusions＞元素将其依赖排除了，与此同时引 Jedis 的依赖，这样就可以使用 Jedis
行编程了。

二、配置属性
需要配置连接池属性和Redis服务器属性

