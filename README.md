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
<td>spring-cloud-study-demo</td>  <td>DEMO项目(含websocket，json，不含jpa)</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-configcenter</td>  <td>配置中心</td>  <td>5555</td>
</tr>
<tr>
<td>spring-cloud-study-jpa</td>  <td>JPA(hibernate实现)</td>  <td>4444</td>
</tr>
<td>spring-cloud-study-feign</td>  <td>微服务远程调用</td>  <td>6666</td>
</tr>
<td>spring-cloud-study-redis</td>  <td>热点数据缓存</td>  <td>2222</td>
</tr>
</tbody></table>
<br>

###一、运行环境

<br>
 - 版本:Spring-Cloud 2.0<br>
 - 环境:JDK1.8(8~10都可以)<br>
 - 编码:UTF-8<br>
 - IDE:Spring Tool Suit(STS)<br>

```
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
  </properties>
```

###二、有关项目启动和配置的说明

 1. 最先启动的是spring-cloud-study-eureka，因为它是注册中心，大多数微服务必须依赖于它才能实现必要的功能。 <br>
 2. 接着zuul路由中心，启用spring-cloud-study-zuul，并配置yml文件即可(已经带了一点小配置，可根据实际情况修改)。 <br>
 3. 然后启用spring-cloud-study-demo，这是一个demo项目<br>
 4. 可以启用spring-cloud-study-configcenter，这里可以从yml或者其他地方读取并统一配置变量<br>
 5. 可以启用spring-cloud-study-jpa，配置一下yml里面数据库连接池的地址，默认是127.0.0.1:3306 root/root，
启动项目可以自动建表，使用init方法可以自动初始化语句，无需自己动数据库<br>
 6. 可以启动spring-cloud-study-feign，他会远程调用demo的内容<br>
 6. 可以单独启动spring-cloud-study-redis需要自己启动一个redis，参考https://blog.csdn.net/moshowgame/article/details/80792774<br>

###三、使用说明

eureka
----
注册中心这个优先启动，是一切微服务的基础也可以修改配置，进行集群，这里默认单机单例 <br>
<table><tbody>
<tr><td>http://127.0.0.1:8888/eureka</td> <td>注册中心</td></tr><br>
</tbody></table>

zuul
----
分发方式一，分发搭配/api1，修改yml就可以了，推荐用指定serviceId的<br>
分发方式二，分发路由，直接根据serviceId访问，无需配置<br>
转发的ServiceId是根据项目配置的spring:application:name: spring-cloud-study-demo 来的<br>
<table><tbody>
<tr><td>http://127.0.0.1:7777/spring-cloud-study-demo/demo/index</td> <td>自动分发请求</td></tr>
<tr><td>http://127.0.0.1:7777/api2/demo/index</td> <td>路由转发请求到配置文件配置的/api2上</td></tr>
<tr><td>http://127.0.0.1:7777/api1/demo/socket/222</td> <td>路由转发请求到配置文件配置的/api1上</td></tr>
</tbody></table>


demo
----
正常的访问请求而已，返回json什么的
还支持websocket，对WebSocket不懂的可以看我这个文章https://blog.csdn.net/moshowgame/article/details/80275084 <br>
<table><tbody>
<tr><td>http://127.0.0.1:9999/demo/socket/222</td> <td>websocket请求页面</td></tr>
<tr><td>http://127.0.0.1:9999/demo/index</td> <td>json数据返回</td></tr>
<tr><td>http://127.0.0.1:9999/demosocket/222</td> <td>socket请求地址</td></tr>
<tr><td>http://127.0.0.1:9999/basepath</td><td>获取微服务路径 </td></tr>
</tbody></table>

configcenter
----
配置中心,用于读取公共配置文件
<table><tbody>
<tr><td>http://127.0.0.1:5555/getparam</td><td>获取变量  </td></tr>
<tr><td>http://127.0.0.1:5555/application/dev</td><td>获取application-dev.yml的变量 </td></tr>
</tbody></table>

jpa
----
已经脱离eureka，需要加入的话自己去掉pom和启动器的eureka相关注释即可。另外，只要数据库连接正常，启动项目可以自动建表，使用init方法可以自动初始化数据，无需自己动数据库 <br>
<table><tbody>
<tr><td>http://127.0.0.1:4444/jpa/user/init/8899</td><td>初始化8899的用户 <br>
<tr><td>http://127.0.0.1:4444/jpa/user/roles/8899</td><td>获取8899用户的角色 <br>
</tbody></table>


feign
----
feign用于远程调用微服务，这里用来调用demo的内容，请先启动eureka+demo再启动这个<br>
具体配置可以看我的文章https://blog.csdn.net/moshowgame/article/details/80616624
<table><tbody>
<tr><td>http://127.0.0.1:9999/demo/getData/222?data=hahahha</td><td></td></tr>
<tr><td>http://127.0.0.1:6666/feign/remote/demo/getData/222?data=springcloudstudy</td><td>远程调用demo </td></tr>
<tr><td>http://127.0.0.1:7777/spring-cloud-study-feign/feign/remote/demo/getData/222?data=springcloudstudybyzuul</td><td>理由转发+远程调用demo </td></tr>
</tbody></table>

redis
----
操作实名参考https://blog.csdn.net/moshowgame/article/details/80792774
<table><tbody>
<tr><td>
【放入缓存】</td><td>
http://localhost:2222/redis/item/2</td><td>{"itemId":2,"itemName":"德玛西亚2"}</td></tr>
<tr><td>
【放入缓存】</td><td>
http://localhost:2222/redis/item/3</td><td>{"itemId":3,"itemName":"德玛西亚3"}</td></tr>
<tr><td>
【读取缓存(可以去RedisDesktopManager看一下，已经有数据了)】</td><td>
http://localhost:2222/redis/item/2</td><td>{"itemId":2,"itemName":"德玛西亚2"}</td></tr>
<tr><td>
【读取缓存(可以去RedisDesktopManager看一下，已经有数据了)】</td><td>
http://localhost:2222/redis/item/3</td><td>{"itemId":3,"itemName":"德玛西亚3"}</td></tr>
<tr><td>
【放入list缓存】</td><td>
http://localhost:2222/redis/item/all</td><td>[{"itemId":666,"itemName":"德玛西亚666"},{"itemId":999,"itemName":"德玛西亚999"}]</td></tr>
<tr><td>
【读取list缓存（这是一个空方法，只是因为有了缓存才有数据）】</td><td>
http://localhost:2222/redis/item/all2</td><td>[{"itemId":666,"itemName":"德玛西亚666"},{"itemId":999,"itemName":"德玛西亚999"}]</td></tr>
<tr><td>
【更新缓存】</td><td>
http://localhost:2222/redis/item/2/update</td><td>{"itemId":2,"itemName":"德玛西亚XXX2"}</td></tr>
<tr><td>
【重新读取缓存】</td><td>
http://localhost:2222/redis/item/2</td><td>{"itemId":2,"itemName":"德玛西亚XXX2"}</td></tr>
<tr><td>
【EL表达式指定KEY】</td><td>
访问地址 http://localhost:2222/redis/item/object?itemId=4&itemName=XXXX</td><td>  
返回结果 {"itemId":4,"itemName":"XXXX"}</td></tr>
<tr><td>
【获取缓存（结果不变还是XXXX不是4444）】</td><td>
访问地址 http://localhost:2222/redis/item/object?itemId=4&itemName=4444</td><td>  
返回结果 {"itemId":4,"itemName":"XXXX"}</td></tr>
</tbody></table>

###四、版本更新
<br><br>
>>>20180624 update:<br>
1.新增Redis<br>
>>>20180609 update:<br>
1.新增feign<br>
2.优化说明<br>
>>>20180603 update:<br>
1.新增jpa<br>
2.优化调整<br>
>>>20180602 update:<br>
1.优化调整<br>
2.新增configcenter<br>