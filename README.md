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
<td>spring-cloud-study-oaurth2(待添加)</td>  <td>TOKEN认证中心</td>  <td>6666</td>
</tr>
</tbody></table>

环境：JDK1.8(8~10都可以)
编码：UTF-8

```
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
  </properties>
```

有关项目启动和配置的说明：

1、最先启动的是spring-cloud-study-eureka，因为它是注册中心，大多数微服务必须依赖于它才能实现必要的功能。 <br>
2、接着zuul路由中心，启用spring-cloud-study-zuul，并配置yml文件即可(已经带了一点小配置，可根据实际情况修改)。 <br>
3、然后启用pring-cloud-study-demo，这是一个demo项目<br>



端口启动情况：
【eureka】 <br>
http://127.0.0.1:8888/eureka 注册中心<br>
【zuul】 <br>
http://127.0.0.1:7777/api1/demo/index 路由转发请求，反正就是http://127.0.0.1:7777/api1/+demo项目的路径即可<br>
http://127.0.0.1:7777/api2/demo/index <br>
http://127.0.0.1:7777/api1/demo/socket/222 <br>
【demo】 <br>
http://127.0.0.1:9999/demo/socket/222  websocket请求页面<br>
http://127.0.0.1:9999/demo/index json数据返回<br>
http://127.0.0.1:9999/demosocket/222  socket请求地址<br>
http://127.0.0.1:9999/basepath 获取微服务路径<br>


