# MySQL 复制


## My SQL binlog的操作及使用
- 查看binlog文件

show master status字段有哪些？

- 可以从binlog中恢复数据？


## 主从架构原理
### 原理
### 存在的问题？
- 主从数据不一致
- 半同步

### 场景应用
- 京东电商：半同步
- 弹幕系统：异步同步


## 主从架构方案
- 一主一从（主要方式）
- 一主多从
- 双主
- 级联同步
- 环形同步


## 主从节点配置
### master配置
show master status


### 创建复制账号
```mysql
grant replication slave on *.* to 'rep'@'%' identified by '123456';
```
### slave配置


- 查看状态
```mysql
show slave status
```
- 配置master 信息
```mysql
stop slave;

# master_host是docker物理主机的IP
# change master to master_host='docker host ip',master_user='root',master_password='123456',master_log_file='mysql-bin.000003',master_log_pos=0;
change master to master_host='docker host ip',master_user='rep',master_password='123456',master_log_file='mysql-bin.000003',master_log_pos=0;

start slave;
````


### slave_io_running 不是yes的解决方法



