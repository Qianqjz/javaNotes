#### zk单机版安装

1 wget https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.5.6/apache-zookeeper-3.5.6-bin.tar.gz

这里一定要注意下载带bin.tar.gz 不然安装完成后会找不到主类

2.tar -zxvf apache-zookeeper-3.5.6-bin.tar.gz -C /usr/local/

3 ln -s  apache-zookeeper-3.5.6-bin zk

4 cd  zk/conf

5 cp zoo_sample.cfg  zoo.cfg

6 配置环境变量

vim  /etc/profile

export ZK_HOME=/usr/local/zk

export PATH=$ZK_HOME/bin:$PATH

保存。

7 source /etc/profile

8 启动

cd /usr/local/zk/bin

./zkServer.sh start

./zkServer.sh status

./zkServer.sh stop



