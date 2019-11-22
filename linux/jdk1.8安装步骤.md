#### jdk1.8安装步骤

1 下载jdk <https://github.com/frekele/oracle-java/releases> 这里有完整的jdk备份。oracle官网的要注册了，很麻烦。

2 通过  wget  https://github.com/frekele/oracle-java/releases 下载jdk

  或者通过先下载到本地在上传至服务器，也可以。

3 解压 

```shell
tar  -zxvf  xxxx -C /usr/local/java/jdk/
```

4 如果进行了第三步的-c 操作 ，就不需要如下操作

```shell
mv xxxx /opt/apps 
```

5 建立软连接，防止以后升级，直接修改jdk 就可以了，不需要修改配置文件

```shell
ln -s jdk1.8_xxxx_xxx/ jdk
```

6 配置环境变量

```shell
vim /etc/profile

export JAVA_HOME=/usr/local/java/jdk/
export JRE_HOME=/usr/local/java/jdk/jre
export PATH=$PATH:/usr/local/java/jdk/bin
export CLASSPATH=./:/usr/local/java/jdk/lib:/usr/local/java/jdk/jre/lib
```

7 使配置文件生效

```shell
 source /etc/profile
```

8 查看时候安装成功

```shell
java -version

java version "1.8.0_212"
Java(TM) SE Runtime Environment (build 1.8.0_212-b10)
Java HotSpot(TM) 64-Bit Server VM (build 25.212-b10, mixed mode)
```

 安装完成！