### redis学习总结

#### 1 redis介绍

官方网站：https://redis.io/download

#### 2 单机版安装

##### 2.1 下载redis

```shell
 wget http://download.redis.io/releases/redis-5.0.0.tar.gz
```

##### 2.2 解压

```shell
tar  -zxvf  xxxx -C /opt/apps/
```

##### 2.3 编译

```shell
cd /opt/apps/
ln -s redis5.0.0/ redis

make -j 4 采用4核进行编译

make install /usr/local/ 将编译完成的redis文件放在此处
随后的redis 起停都在此处执行命令

```

##### 2.4 进入软连接的redis

```shell
vim /opt/apps/redis/redis.conf

bind 0.0.0.0 任意地址都可以访问redis

daemonize yes 允许后台执行redis
```

##### 2.5  将第四步的redis.conf 赋值到编译完成的地方

```shell
cp /opt/apps/redis/redis.conf /usr/local/resdis/bin
```

##### 2.6  开启redis 

```shell
cd /usr/local/resdis/bin
./resdis-server redis.conf 
ps -ef |grep redis 这时的redis就在后台挂着呢

./redis-cli 进入客户端
可以存入，取值

```

##### 2.7 关闭redis

```shell
 ./redis-cli shutdown 推荐
 也可以直接杀进程号，
```

 安装完成！

#### 3 redis 客户端

#### 4 数据类型

##### 4.1 String

​	一般适用于简单的key-value缓存，

##### 4.2 hash

​	可以存储对象，key-value键值对，value 里面含有若干key-value ;	

##### 4.3 list

​	可以做队列，是一个双端队列；	

##### 4.4 set

​	只要用于不是重复的值，去重，求并，差集；

##### 4.5 sortset

​	是一个排序的没有重复的集合，可以做排行榜，等有排序，没有重复的场景中使用；

#### 5 redis事物

##### 5.1 multi

##### 5.2 exec

##### 5.3 discard

##### 5.4 watch

#### 6 分布式锁

#### 7 redis持久化方案

#### 8 redis主从复制

#### 9 redis哨兵机制

#### 10 redis cluster集群

#### 11 redis消息模式

#### 12 redis+lua的使用

#### 13 缓存穿透，缓存击穿，热点缓存

#### 14 缓存淘汰策略

#### 15 IO多路复用

#### 16 数据库，缓存双写一致性问题

##### 16.1 采用消息队列的方法

##### 16.2 采用延时双删的方法

​			先删缓存，在更新数据库，在删除缓存。

​			

