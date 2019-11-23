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



#### 17 查看redis 内存占用

进入redis 执行

```shell
info Memory
```

used_memory:853032

由 Redis 分配器分配的内存总量，以字节（byte）为单位

used_memory_human:833.04K

以人类可读的格式返回 Redis 分配的内存总量

used_memory_rss:10620928

从操作系统的角度，返回 Redis 已分配的内存总量（俗称常驻集大小）。这个值和 top 、 ps 等命令的输出一致。

used_memory_rss_human:10.13M

以人类可读的格式返回 Redis 的内存消耗峰值

used_memory_peak:875208

Redis 的内存消耗峰值（以字节为单位）

used_memory_peak_human:854.70K
used_memory_peak_perc:97.47%
used_memory_overhead:841806
used_memory_startup:792008
used_memory_dataset:11226
used_memory_dataset_perc:18.40%
allocator_allocated:1256912
allocator_active:1507328
allocator_resident:7254016
total_system_memory:1927254016
total_system_memory_human:1.79G
used_memory_lua:37888
used_memory_lua_human:37.00K
used_memory_scripts:0
used_memory_scripts_human:0B
number_of_cached_scripts:0
maxmemory:0
maxmemory_human:0B
maxmemory_policy:noeviction
allocator_frag_ratio:1.20
allocator_frag_bytes:250416
allocator_rss_ratio:4.81
allocator_rss_bytes:5746688
rss_overhead_ratio:1.46
rss_overhead_bytes:3366912
mem_fragmentation_ratio:13.08
mem_fragmentation_bytes:9808920
mem_not_counted_for_evict:0
mem_replication_backlog:0
mem_clients_slaves:0
mem_clients_normal:49686
mem_aof_buffer:0
mem_allocator:jemalloc-5.1.0
active_defrag_running:0
lazyfree_pending_objects:0

​			

