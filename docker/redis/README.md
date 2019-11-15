# Redis 
## Redis持久化
### 为什么要持久化
因为Redis 是内存数据库，它将数据库状态储存在内存里，所以如果不想办法将存储在内存中的
数据库状态保存在磁盘上里面，那么一旦服务器进程退出，服务器中的数据库状态也会消失不见。

### 持久化方式
#### RDB持久化（默认的持久化方式）
RDB持久化既可以手动执行，也可以根据服务器配置选项定期执行。RDB 文件是一个经过压缩的二
进制文件，通过该文件可以还原数据库状态。

##### RDB 文件的创建与载入
创建RDB文件的命令
- save：会阻塞Redis服务器进程，直到RDB文件创建完毕为止，在服务器进程服务器阻塞期间，
服务器不能处理任何命令请求。
- bgsave：会派生一个子进程，然后由子进程负责创建RDB文件，服务器进程继续处理命令请求。

载入RDB文件     
RDB文件载入工作是在服务器启动时自动执行的，Redis没有专门用于载入RDB文件的命令，只要
redis服务器启动时检测到rdb文件存在时，它就会自动载入RDB文件。只有在关闭AOF持久化文
功能时才会使用RDB文件来还原数据库状态。载入RDB文件时服务器一直处于阻塞状态，直到载入
工作完成。

##### redis启动过程
1. 服务器启动 
2. 执行载入程序
3. 是否开启AOF持久化功能，是的话执行4，否的话执行5
4. 载入AOF文件
5. 载入RDB文件

##### 自动间隔性保存
配置文件配置
```
# 900 秒内对数据库进行1次修改执行一次BGSAVE
save 900 1
# 300 秒内对数据库进行10次修改执行一次BGSAVE
save 300 10
# 60 秒内对数据库进行10000次修改执行一次BGSAVE
save 60 10000
```

#### AOF持久化 
配置文件中的配置
```
appendonly no
appendfilename "appendonly.aof"
appendfsync always
appendfsync everysec
appendfsync no
no-appendfsync-on-rewrite no
auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb
aof-load-truncated yes
```


## 复制
通过命令
```
SLAVEOF 主机IP 端口
```

### 实现

#### 旧版复制功能的实现


## 高可用
### 哨兵模式
完成主从自动切换
### 集群
