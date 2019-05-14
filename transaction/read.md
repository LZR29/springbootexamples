springboot开启事务很简单，只需要一个注解@Transactional 就可以了。
因为在springboot中已经默认对jpa、jdbc、mybatis开启了事事务，引入它们依赖的时候，事物就默认开启。
当然，如果你需要用其他的orm，比如beatlsql，就需要自己配置相关的事物管理器。
由于mybatis是基于注解的，所以这次基于xml的来实现，并开启声明式事务。

一、引入依赖
在pom文件中引入mybatis启动依赖和mysql依赖

二、配置数据文件
通过配置mybatis.mapper-locations来指明mapper的xml文件存放位置，我是放在resources/mybatis文件下的。
mybatis.type-aliases-package来指明和数据库映射的实体的所在包。

三、事务过程
@Transactional，声明事务，并设计一个转账方法，用户1减10块，用户2加10块。
在用户1减10 ，之后，抛出异常，即用户2加10块钱不能执行，当加注解@Transactional之后，两个人的钱都没有增减。
当不加@Transactional，用户1减了10，用户2没有增加，即没有操作用户2 的数据。
可见@Transactional注解开启了事物。

四、两个注解
在项目中大多数用的都是@MapperScan注解，指定basePackages，扫描mybatis Mapper接口类,
另外一种方式是用@Mapper注解，其实这两种方法扫描配置用的是一个地方，只是扫描入口不同。
两者选其一就行，不然无法注册到IOC容器。