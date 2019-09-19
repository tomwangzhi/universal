---------------------------
当前接入的apollo版本为1.1.2
---------------------------

相关服务包网盘地址下载
链接：https://pan.baidu.com/s/1UEgT7HoX2VtBGLlilZQiFA
提取码：4wya

或github到 https://github.com/ctripcorp/apollo

apollo服务端搭建:
    java版本1.8
    Apollo服务端共需要两个数据库：ApolloPortalDB和ApolloConfigDB，我们把数据库、表的创建和样例数据都分别准备了sql文件，只需要导入数据库即可。
    需要注意的是ApolloPortalDB只需要在生产环境部署一个即可，而ApolloConfigDB需要在每个环境部署一套，如fat、uat和pro分别部署3套ApolloConfigDB。

    之后就是运行apollo的三个jar文件，admin,config,portal已经准备好,只需配置每个文件夹中的config文件夹对应的application-github.properties数据库信息即可
    连接的是你导入sql文件的数据库

    最后一步，启动三个文件夹中对应的scripts文件夹中的启动文件即可

    启动完毕后，会多出三个进程 admin config portal 端口对应8090 8080 8070
    通过url:8070可访问页面，登录账号密码默认 apollo  admin 之后即可创建创建对应服务的配置

Java客户端接入:
     根据自己所搭建的版本，选择对应的依赖,本次搭建2.1.2
     <!--1.1.2 apollo接入-->
             <dependency>
                 <groupId>com.ctrip.framework.apollo</groupId>
                 <artifactId>apollo-client</artifactId>
                 <version>1.1.2</version>
             </dependency>

      引入依赖完成后,在启动类上添加相应注解 @EnableApolloConfig
      resources下创建META-INF文件夹，文件夹中创建app.properties文件
      文件内容如下
      app.id=api-zuul # 指定apollo AppId
      env=dev #指定环境
      apollo.meta=http://192.168.6.174:8080 #指向对应的meta server(当前指向的是dev,具体要切换的其他环境的配置，请看https://github.com/ctripcorp/apollo/wiki/Java客户端使用指南)

      只有将你的配置移入apollo即可