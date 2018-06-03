![image](https://img.shields.io/badge/Spring%20Cloud-%E2%98%85%E2%98%85%E2%98%85-green.svg)
![image](https://img.shields.io/badge/Netflix-%E2%98%85%E2%98%85%E2%98%85-red.svg)

spring-cloud-study 微服务组件学习
===

http://blog.csdn.net/moshowgame

<table>
<tbody><tr>
<td>工程名</td>  <td>描述</td>  <td>端口</td>
</tr>
<tr>
<td>spring-cloud-study-eureka</td>  <td>服务发现与注册中心</td>  <td>8888</td>
</tr>
<tr>
<td>spring-cloud-study-zuul</td>  <td>动态转发路由器</td>  <td>7777</td>
</tr>
<tr>
<td>spring-cloud-study-demo</td>  <td>配置管理中心</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-configcenter</td>  <td>配置中心</td>  <td>5555</td>
</tr>
<tr>
<td>spring-cloud-study-jpa</td>  <td>JPA(hibernate实现)</td>  <td>4444</td>
</tr>
</tbody></table>
一、环境
版本:Spring-Cloud 2.0
环境:JDK1.8(8~10都可以)<br>
编码:UTF-8<br>
IDE:Spring Tool Suit(STS)<br>

```
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
  </properties>
```

二、有关项目启动和配置的说明：

1、最先启动的是spring-cloud-study-eureka，因为它是注册中心，大多数微服务必须依赖于它才能实现必要的功能。 <br>
2、接着zuul路由中心，启用spring-cloud-study-zuul，并配置yml文件即可(已经带了一点小配置，可根据实际情况修改)。 <br>
3、然后启用spring-cloud-study-demo，这是一个demo项目<br>
4、可以启用spring-cloud-study-configcenter，这里可以从yml或者其他地方读取并统一配置变量<br>
5、可以启用spring-cloud-study-jpa，配置一下yml里面数据库连接池的地址，默认是127.0.0.1:3306 root/root，
启动项目可以自动建表，使用init方法可以自动初始化语句，无需自己动数据库

三、端口情况以及使用说明：

【eureka】 <br>
#####这个优先启动 <br>
http://127.0.0.1:8888/eureka 注册中心<br>

【zuul】 <br>
#####有什么分发需要，修改yml就可以了，推荐用指定serviceId的<br>
http://127.0.0.1:7777/api1/demo/index 路由转发请求，反正就是http://127.0.0.1:7777/api1/+demo项目的路径即可<br>
http://127.0.0.1:7777/api2/demo/index <br>
http://127.0.0.1:7777/api1/demo/socket/222 <br>

【demo】 <br>
#####对WebSocket不懂的可以看我这个文章https://blog.csdn.net/moshowgame/article/details/80275084 <br>
http://127.0.0.1:9999/demo/socket/222  websocket请求页面 <br>
http://127.0.0.1:9999/demo/index json数据返回 <br>
http://127.0.0.1:9999/demosocket/222  socket请求地址 <br>
http://127.0.0.1:9999/basepath 获取微服务路径 <br>

【configcenter】 <br>
#####已经脱离eureka，需要加入的话自己去掉pom和启动器的eureka相关注释即可。另外，只要数据库连接正常，启动项目可以自动建表，使用init方法可以自动初始化数据，无需自己动数据库 <br>
http://127.0.0.1:5555/getparam 获取变量 <br>
http://127.0.0.1:5555/application/dev 获取application-dev.yml的变量 <br>

【jpa】 <br>
#####已经脱离eureka，需要加入的话自己去掉pom和启动器的eureka相关注释即可。另外，只要数据库连接正常，启动项目可以自动建表，使用init方法可以自动初始化数据，无需自己动数据库 <br>
http://127.0.0.1:4444/jpa/user/init/8899 初始化8899的用户 <br>
http://127.0.0.1:4444/jpa/user/roles/8899 获取8899用户的角色 <br>

四、版本更新<br>
20180603 update:<br>
1.新增jpa
2.优化调整<br>
20180602 update:<br>
1.优化调整
2.新增configcenter<br>