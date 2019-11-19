## MyCat
### MyCat 数据库唯一主键自增长配置
#### 1. server.xml配置
使用数据库序列
```xml
<!-- sequnceHandlerType取值说明：
0: 本地文件方式(sequence_conf.properties)
1: 数据库方式(MYCAT_SEQUENCE表、sequence_db_conf.properties)
2: 本地时间戳方式(sequence_time_conf.properties)
3: 分布式ZK ID生成器
4: ZK递增方式
-->
<system>
    <property name="sequnceHandlerType">1</property>
</system>
```
#### 2. schema.xml配置
定义逻辑表
```xml
<table name="store" primaryKey="id" autoIncrement="true" dataNode="dn1,dn2" rule="mod-long"></table>
```
定义序列表并指定存放在的数据结点
```xml
<table name="mycat_sequence" primaryKey="name" dataNode="dn1"></table>
```

#### 3. sequence_db_conf.properties配置
定义逻辑表store的序列记录(注意：逻辑表名要大写)
```
STORE=dn1
```

#### 4. 创建序列表
可以直接连接mycat后执行该语句
 ```sql
 DROP TABLE IF EXISTS MYCAT_SEQUENCE;
 CREATE TABLE MYCAT_SEQUENCE(
     name VARCHAR(50) NOT NULL,
     current_value INT NOT NULL,
     increment INT NOT NULL DEFAULT 100,
     PRIMARY KEY(name)
 ) ENGINE=InnoDB;
 ```
 
 #### 5. 创建逻辑表
 5.1 可以直接连接mycat后执行该语句
 ```sql
 drop table if exists store;
 CREATE TABLE store (
     `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
     `name` VARCHAR(256) NOT NULL,
     PRIMARY KEY (`id`)
 );
 ```
 5.2 创建 逻辑表对应的 的序列
 ```sql
insert into MYCAT_SEQUENCE(`name`,current_value,increment) values("STORE",0,1);
```
 
#### 6. 创建存储函数必须和序列表在一个数据库结点上
必须在相关的结点上运行？不能在mycat连接上运行，不然会报错
```sql
-- 获取当前sequence的值 (返回当前值,增量)
DROP FUNCTION IF EXISTS mycat_seq_currval;
DELIMITER $
CREATE FUNCTION mycat_seq_currval(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
DETERMINISTIC
BEGIN
DECLARE retval VARCHAR(64);
SET retval="-999999999,null";
SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR)) INTO retval FROM MYCAT_SEQUENCE WHERE name = seq_name;
RETURN retval;
END $
DELIMITER ;
-- 设置sequence值
DROP FUNCTION IF EXISTS mycat_seq_setval;
DELIMITER $
CREATE FUNCTION mycat_seq_setval(seq_name VARCHAR(50),value INTEGER) RETURNS varchar(64) CHARSET utf8
DETERMINISTIC
BEGIN
UPDATE MYCAT_SEQUENCE
SET current_value = value
WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END $
DELIMITER ;
-- 获取下一个sequence值
DROP FUNCTION IF EXISTS mycat_seq_nextval;
DELIMITER $
CREATE FUNCTION mycat_seq_nextval(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
DETERMINISTIC
BEGIN
UPDATE MYCAT_SEQUENCE
SET current_value = current_value + increment WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END $
DELIMITER ;
```
#### 重启、连接mycat使用
重启mycat后就能像使用mysql一样使用了！！！不重启的话会出现莫名其妙的NPE异常
