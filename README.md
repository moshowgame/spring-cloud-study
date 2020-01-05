![image](https://img.shields.io/badge/SpringBoot2-%E2%98%85%E2%98%85%E2%98%85%E2%98%85%E2%98%85-brightgreen.svg)
![image](https://img.shields.io/badge/SpringCloud2-%E2%98%85%E2%98%85%E2%98%85%E2%98%85%E2%98%85-brightgreen.svg)
[![Build Status](https://travis-ci.org/moshowgame/spring-cloud-study.svg?branch=master)](https://travis-ci.org/moshowgame/spring-cloud-study)

SpringBootLearning && SpringCloudLearning
===
SpringBoot+微服务学习项目。
<br>
http://blog.csdn.net/moshowgame

<table>
<tr>
<th>工程名</th>  <th>描述</th>  <th>端口</th>
</tr>
<tbody>
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
<tr>
<td>spring-cloud-study-feign</td>  <td>微服务远程调用</td>  <td>6666</td>
</tr>
<tr>
<td>spring-cloud-study-redis</td>  <td>热点数据缓存</td>  <td>2222</td>
</tr>
<tr>
<td>spring-cloud-study-jms</td>  <td>JMS(Java消息服务，ActiveMQ实现)</td>  <td>1111</td>
</tr>
<tr>
<td>spring-cloud-study-mybatisplus</td>  <td>mybatisplus(mybatis的加强版)</td>  <td>3333</td>
</tr>
<tr>
<td>spring-cloud-study-poi</td>  <td>poi导入</td>  <td>8899</td>
</tr>
<tr>
<td>spring-cloud-study-aop</td>  <td>aop切面编程</td>  <td>9998</td>
</tr>
<tr>
<td>spring-cloud-study-udp</td>  <td>netty实现udp</td>  <td>9898</td>
</tr>
<tr>
<td>spring-cloud-study-netty-websocket</td>  <td>netty实现websocket</td>  <td>6688</td>
</tr>
<tr>
<td>spring-cloud-study-security</td>  <td>spring-security-demo自定义授权</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-security-jwt</td>  <td>spring-security-JWT授权</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-elasticsearch</td>  <td>spring-data-elasticsearch，强大的搜索和分析引擎</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-drools</td>  <td>drools(jboss rules)强大的业务规则引擎</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-logstash</td>  <td>springboot2+logback+logstash+elasticsearch+kibana打造强大的日志收集分析系统</td>  <td>9999</td>
</tr>
<tr>
<td>spring-cloud-study-websocket</td>  <td>springboot2+websocket,整合基于IM的优化版本</td>  <td>9999</td>
</tr>
</tbody></table>
<br>

一、运行环境
----

<br>
  -  版本:SpringCloud/SpringBoot 2.X<br>
  -  环境:JDK8/11<br>
  -  编码:UTF-8<br>
 - IDE:Spring Tool Suit(STS)/IDEA(推荐)/VSCode with STS(New)<br>

```xml
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
  </properties>
```

二、有关项目启动和配置的说明
----

- 由于子项目太多，暂时移除所有模块的引用，有需要请再父项目的module中启用pom.xml <br>
- 其他未提及模块均为springboot，可独立启动，可不依赖eureka注册中心。
- 微服务模块，请先启动spring-cloud-study-eureka，因为它是注册中心，大多数微服务必须依赖于它才能实现必要的功能。 <br>
- zuul路由中心(后续会升级为ApiGateway)，启用spring-cloud-study-zuul，并配置yml文件即可(已经带了一点小配置，可根据实际情况修改)。 <br>
- 按需启用spring-cloud-study-demo/spring-cloud-study-configcenter/spring-cloud-study-jpa/spring-cloud-study-feign等等<br>
- 其他模块均不需要eureka等模块，可直接启动

三、使用说明
----

Eureka
----
微服务注册中心，SpringCloud全家桶，Netflix版注册中心。这个优先启动，是一切微服务的基础也可以修改配置，进行集群，这里默认单机单例 <br>
<table><tbody>
<tr><td>http://127.0.0.1:8888/eureka</td> <td>注册中心</td></tr><br>
</tbody></table>

Zuul(@Deprecated,应该用ApiGateway了)
----
API网关/路由，ZUUL是阻塞的，APIGateway是NIO的。<br>
分发方式一，分发搭配/api1，修改yml就可以了，推荐用指定serviceId的<br>
分发方式二，分发路由，直接根据serviceId访问，无需配置<br>
转发的ServiceId是根据项目配置的spring:application:name: spring-cloud-study-demo 来的<br>
<table><tbody>
<tr><td>http://127.0.0.1:7777/spring-cloud-study-demo/demo/index</td> <td>自动分发请求</td></tr>
<tr><td>http://127.0.0.1:7777/api2/demo/index</td> <td>路由转发请求到配置文件配置的/api2上</td></tr>
<tr><td>http://127.0.0.1:7777/api1/demo/socket/222</td> <td>路由转发请求到配置文件配置的/api1上</td></tr>
</tbody></table>


DEMO
----
正常的访问请求而已，返回json什么的
还支持WebSocket，对WebSocket不懂的可以看我这个文章https://blog.csdn.net/moshowgame/article/details/80275084 <br>
<table><tbody>
<tr><td>http://127.0.0.1:9999/demo/socket/222</td> <td>websocket请求页面</td></tr>
<tr><td>http://127.0.0.1:9999/demo/index</td> <td>json数据返回</td></tr>
<tr><td>http://127.0.0.1:9999/demosocket/222</td> <td>socket请求地址</td></tr>
<tr><td>http://127.0.0.1:9999/basepath</td><td>获取微服务路径 </td></tr>
</tbody></table>

Configcenter
----
配置中心,用于读取公共配置文件
<table><tbody>
<tr><td>http://127.0.0.1:5555/getparam</td><td>获取变量  </td></tr>
<tr><td>http://127.0.0.1:5555/application/dev</td><td>获取application-dev.yml的变量 </td></tr>
</tbody></table>

JPA
----
JPA是一个标准，Hibernate是实现，实现简单、强大的CRUD功能。已经脱离eureka，需要加入的话自己去掉pom和启动器的eureka相关注释即可。另外，只要数据库连接正常，启动项目可以自动建表，使用init方法可以自动初始化数据，无需自己动数据库 <br>
<table><tbody>
<tr><td>http://127.0.0.1:4444/jpa/user/init/8899</td><td>初始化8899的用户 <br>
<tr><td>http://127.0.0.1:4444/jpa/user/roles/8899</td><td>获取8899用户的角色 <br>
</tbody></table>

Feign
----
Feign用于远程调用微服务，这里用来调用demo的内容，请先启动eureka+demo再启动这个<br>
具体配置可以看我的文章https://blog.csdn.net/moshowgame/article/details/80616624
<table><tbody>
<tr><td>http://127.0.0.1:9999/demo/getData/222?data=hahahha</td><td></td></tr>
<tr><td>http://127.0.0.1:6666/feign/remote/demo/getData/222?data=springcloudstudy</td><td>远程调用demo </td></tr>
<tr><td>http://127.0.0.1:7777/spring-cloud-study-feign/feign/remote/demo/getData/222?data=springcloudstudybyzuul</td><td>理由转发+远程调用demo </td></tr>
</tbody></table>

Redis/SpringCache
----
操作实名参考https://blog.csdn.net/moshowgame/article/details/80792774
<table><tbody>
<tr><td>
【放入缓存】</td><td>
http://127.0.0.1:2222/redis/item/2</td><td>{"itemId":2,"itemName":"德玛西亚2"}</td></tr>
<tr><td>
【放入缓存】</td><td>
http://127.0.0.1:2222/redis/item/3</td><td>{"itemId":3,"itemName":"德玛西亚3"}</td></tr>
<tr><td>
【读取缓存(可以去RedisDesktopManager看一下，已经有数据了)】</td><td>
http://127.0.0.1:2222/redis/item/2</td><td>{"itemId":2,"itemName":"德玛西亚2"}</td></tr>
<tr><td>
【读取缓存(可以去RedisDesktopManager看一下，已经有数据了)】</td><td>
http://127.0.0.1:2222/redis/item/3</td><td>{"itemId":3,"itemName":"德玛西亚3"}</td></tr>
<tr><td>
【放入list缓存】</td><td>
http://127.0.0.1:2222/redis/item/all</td><td>[{"itemId":666,"itemName":"德玛西亚666"},{"itemId":999,"itemName":"德玛西亚999"}]</td></tr>
<tr><td>
【读取list缓存（这是一个空方法，只是因为有了缓存才有数据）】</td><td>
http://127.0.0.1:2222/redis/item/all2</td><td>[{"itemId":666,"itemName":"德玛西亚666"},{"itemId":999,"itemName":"德玛西亚999"}]</td></tr>
<tr><td>
【更新缓存】</td><td>
http://127.0.0.1:2222/redis/item/2/update</td><td>{"itemId":2,"itemName":"德玛西亚XXX2"}</td></tr>
<tr><td>
【重新读取缓存】</td><td>
http://127.0.0.1:2222/redis/item/2</td><td>{"itemId":2,"itemName":"德玛西亚XXX2"}</td></tr>
<tr><td>
【EL表达式指定KEY】</td><td>
http://127.0.0.1:2222/redis/item/object?itemId=4&itemName=XXXX</td><td>  
返回结果 {"itemId":4,"itemName":"XXXX"}</td></tr>
<tr><td>
【获取缓存（结果不变还是XXXX不是4444）】</td><td>
http://127.0.0.1:2222/redis/item/object?itemId=4&itemName=4444</td><td>  
返回结果 {"itemId":4,"itemName":"XXXX"}</td></tr>
</tbody></table>

JMS/ActiveMQ
----
概念和操作可以参考https://blog.csdn.net/moshowgame/article/details/80836621
<table><tbody>
<tr><td>
发送消息</td><td>
http://127.0.0.1:1111/jms/email/send</td><td>控制台显示Received
</td></tr>
</tbody></table>

Mybatis-Plus 3
----
Mybatis-Plus 是一款 Mybatis 动态 SQL 自动注入 Mybatis 增删改查 CRUD 操作中间件， 减少你的开发周期优化动态维护 XML 实体字段，无入侵全方位 ORM 辅助层让您拥有更多时间陪家人。<br>

具体配置可以看我的文章https://blog.csdn.net/moshowgame/article/details/81008485
<table><tbody>
<tr><td>http://127.0.0.1:3333/mybatisplus/user/init</td><td>数据初始化</td></tr>
<tr><td>http://127.0.0.1:3333/mybatisplus/user/find</td><td>通过QueryWarrap构造器查询</td></tr>
</tbody></table>

POI-TL/Word Model
----
很多时候我们网站或者系统需要提供一些word文件，例如证明.docx或者订单.docx等文件供用户下载打印等。

用Java操作word文档，毫无疑问，当下最流行apache poi，对于poi如何操作word文档，这里不作过多介绍。

这里主要讲解如何通过一个制作好的word模板文件，通过数据填充，生成加工好的word文件。

具体可以看我的文章https://blog.csdn.net/moshowgame/article/details/81702029
<table><tbody>
<tr><td>http://127.0.0.1:8899/poi/generateWord</td><td>通过Word模板生成Word文件</td></tr>
</tbody></table>

Spring AOP
----
Aspect Oriented Programming(AOP)，面向切面编程，是一个比较热门的话题。AOP主要实现的目的是针对业务处理过程中的切面进行提取，它所面对的是处理过程中的某个步骤或阶段，以获得逻辑过程中各部分之间低耦合性的隔离效果。比如我们最常见的就是日志记录了，不可能每个业务都去加写日志发的功能吧，我们就用切面，将需要记录日志的地方切一下，配置自动记录日志即可。

具体可以看我的文章https://blog.csdn.net/moshowgame/article/details/85814808
<table><tbody>
<tr><td>http://127.0.0.1:9998/aop/index</td><td>查看控制台AOP情况</td></tr>
</tbody></table>

Netty-UDP
----
UDP是用户数据报协议（User Datagrame Protocol,UDP）的简称，主要作用是将网络数据流压缩成数据报的形式，提供面向事务的简单信息传送服务。<br>
具体可以看我的文章https://blog.csdn.net/moshowgame/article/details/88420880
<table><tbody>
<tr><td>服务端运行方法</td><td>运行ChineseProverbServer的main方法</td></tr>
<tr><td>客户端运行方法</td><td>运行ChineseProverbClient的main方法</td></tr>
</tbody></table>

Netty-WebSocket
----
基于Netty的Websocket，稳定性性能秒杀原生。<br>
具体可以看我的文章https://blog.csdn.net/moshowgame/article/details/91552993
<table><tbody>
<tr><td>http://127.0.0.1:6688/netty-websocket/index</td><td>运行多个查看结果</td></tr>
</tbody></table>

Spring-Security-Filter
----
基于spring-security的自定义登录模块。<br>
<table><tbody>
<tr><td>http://127.0.0.1:9999/security/index</td><td>首页</td></tr>
<tr><td>http://127.0.0.1:9999/security/login</td><td>登录页面</td></tr>
<tr><td>http://127.0.0.1:9999/security/user/list</td><td>需要授予USER权限访问的页面</td></tr>
</tbody></table>

Spring-Security-JWT
----
基于spring-security-jwt授权模块。详情请看https://blog.csdn.net/moshowgame/article/details/96476554<br>
<table><tbody>
<tr><td>http://127.0.0.1:9999/security/auth</td><td>登录接口，json body是{"username":"users","password":"pass"}</td></tr>
<tr><td>http://127.0.0.1:9999/security/token</td><td>获取Token信息，Header是Authorization:Bearer +Token</td></tr>
</tbody></table>

Spring-Data-ElasticSearch
----
基于spring-boot-starter-data-elasticsearch的搜索和分析引擎模块。详情请看https://blog.csdn.net/moshowgame/article/details/96768494<br>
<table><tbody>
<tr><td>http://127.0.0.1:9999/es/save</td><td>新增记录</td></tr>
<tr><td>http://127.0.0.1:9999/es/search</td><td>搜索记录</td></tr>
</tbody></table>

Springboot2+Drools
----
Drools是一个易于访问企业策略、易于调整以及易于管理的开源业务规则引擎，特点就是速度快、效率高。 如果你还在使用复杂的`JAVA代码`校验复杂的`优惠券/超市打折/计价规则/商品定价/阶梯定价/游戏规则/业务规则`？试试用Drools来解救代码吧，适用但不仅仅包含以上场景。详情请看https://blog.csdn.net/moshowgame/article/details/98061651<br>
<table><tbody>
<tr><td>http://127.0.0.1:9999/drools/taxi/cal?distanceInMile=18</td><td>打车18公里</td></tr>
<tr><td>http://127.0.0.1:9999/drools/taxi/cal?distanceInMile=2</td><td>打车2公里</td></tr>
<tr><td>http://127.0.0.1:9999/drools/taxi/cal?distanceInMile=3.5</td><td>打车3.5公里</td></tr>
</tbody></table>

SpringBoot2+Logback+Logstash+ElasticSearch+Kibana
----
Logstash收集AppServer产生的Log，并存放到ElasticSearch集群中，而Kibana则从ES集群中查询数据生成图表，再返回给Browser。详情请看https://blog.csdn.net/moshowgame/article/details/98851656<br>
<table><tbody>
<tr><td>http://127.0.0.1:9200</td><td>ElasticSearch查看运行情况</td></tr>
<tr><td>http://127.0.0.1:9999/logstash</td><td>输出Log日志</td></tr>
<tr><td>http://127.0.0.1:5601/app/kibana</td><td>kibana查看日志</td></tr>
</tbody></table>

Websocket IM
----
基于SpringBoot2+WebSocket,整合了简单IM的优化版,简单明了入门无压力,集群部分未实现(即发送的userId不在当前服务器)
<table><tbody>
<tr><td>http://127.0.0.1:9999/demo/page</td><td>打开第一个页面,userId=10/toUserId=20</td></tr>
<tr><td>http://127.0.0.1:9999/demo/page</td><td>打开第二个页面,userId=20/toUserId=10</td></tr>
<tr><td>http://127.0.0.1:9999/demo/push/10?message=moshowCallU</td><td>给对应的用户推送信息</td></tr>
</tbody></table>

四、版本更新
----

<br><br>
  <table>
   <tr>
      <th>更新时间</th>
      <th>更新内容</th>
    </tr>
   <tbody> 
    <tr> 
        <td>20200105</td> 
        <td>- 新增SpringBoot2+WebSocket的简单IM优化版,优化连接技术相关内容,目前是单机版,集群版本近期发布。</td> 
    </tr>
    <tr> 
        <td>20190810</td> 
        <td>- 新增SpringBoot2+Logback+Logstash+ElasticSearch+Kibana打造强大的日志收集分析系统。</td> 
    </tr>
    <tr> 
        <td>20190802</td> 
        <td>- 新增Spring-Drools业务规则引擎模块。<br>- 由于子项目太多，暂时移除所有模块的引用，有需要请再父项目的module中启用<br>- empty为空白项目，可以直接copy出来改一下当新模块使用 <br>新增Travis CI </td> 
       </tr> 
    <tr> 
    <tr> 
        <td>20190722</td> 
        <td>- 新增Spring-Data-ElasticSearch授权验证模块。</td> 
    </tr> 
    <tr> 
     <td>20190720</td> 
     <td>- 新增SpringSecurity-JWT授权验证模块。</td> 
    </tr> 
    <tr>
     <td> 20190716 </td>
     <td> - 新增SpringSecurity自定义登录模块。 </td>
    </tr> 
    <tr>
     <td> 20190612 </td>
     <td> - 新增基于Netty的WebSocket模块。 </td>
    </tr> 
    <tr>
     <td> 20190122 </td>
     <td> - 新增基于Netty的UDP模块。 </td>
    </tr> 
    <tr>
     <td>20190105 </td>
     <td> - 新增AOP模块，可以练习AOP功能。<br>- 更新SpringBoot到2.0.5版本。 <br>- 更新lombok，修复某些JDK不兼容问题 </td>
    </tr> 
    <tr>
     <td>20181112 </td>
     <td> - 优化mybatis-plus模块的导入，使用mybatis-plus stater简化操作 </td>
    </tr> 
    <tr>
     <td>20180815 </td>
     <td> - 新增POI-TL模块，POI根据Word模板输出文件 </td>
    </tr> 
    <tr>
     <td>20180711 </td>
     <td> - 新增MybatisPlus3.0模块，比Mybatis更简单爆炸 </td>
    </tr> 
    <tr>
     <td>20180627 </td>
     <td> - 新增JMS模块，ActiveMQ实现，订阅/消费 </td>
    </tr> 
    <tr>
     <td>20180624 </td>
     <td> - 新增Redis模块，完美集成SpringCache </td>
    </tr> 
    <tr>
     <td>20180609 </td>
     <td> - 新增Feign模块，MicroService之间相互调用 <br>- 优化说明 </td>
    </tr> 
    <tr>
     <td>20180603 </td>
     <td> - 新增JPA模块，Hibernate实现，基于实体，简单CRUD <br>- 优化调整 </td>
    </tr> 
    <tr>
     <td>20180602 </td>
     <td> - 优化调整 <br>- 新增configcenter模块，集中式配置管理 </td>
    </tr> 
   </tbody>
  </table>
