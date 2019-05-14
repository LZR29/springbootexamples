一、引入依赖
在pom文件引入spring-boot-starter-jdbc的依赖，引入mysql连接类和连接池

二、配置相关文件
在application.properties文件配置mysql的驱动类，数据库地址，数据库账号、密码信息。
通过引入这些依赖和配置一些基本信息，springboot就可以访问数据库类。