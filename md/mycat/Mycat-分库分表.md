## MyCat 分表
### 单库分表 
逻辑表配置,通过设置`subTables`属性来配置分表
```xml
<table name="order" primaryKey="id" autoIncrement="true" subTables="order_$1-2" dataNode="dn1" rule="mod-long">
</table>
```
在节点`dn1`上建立2个分表`order_1`和`order_2`，语句如下：
```sql 
create table `order_1`(
	id bigint UNSIGNED not null auto_increment,
    `no` varchar(20) not null,
    primary key (`id`)
);

create table `order_2` like `order_1`;
```
## 单库主、子表(E-R表)
Mycat不支持单库主子表的

## 多库分表
配置逻辑表
```xml
<table name="order" primaryKey="id" autoIncrement="true" dataNode="dn1,dn2" rule="mod-long">
    <childTable name="order_detail" primaryKey="id" joinKey="order_id" parentKey="id"></childTable>
</table>
```
注意：childTable的 joinKey是`order_detail`表中的字段，parentKey是`order`表中的字段。

创建物理表
```sql
create table `order`(
id bigint unsigned not null auto_increment,
order_no varchar(128) not null ,
primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;

create table `order_detail`(
id bigint unsigned not null auto_increment,
order_id bigint not null,
product_id bigint not null,
qty int not null,
primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

```

## 连接到mycat 插入数据
```sql
use store;
insert into `order`(`order_no`) values("201911190001");-- order_id=2
insert into `order`(`order_no`) values("201911190002");-- order_id=3
insert into `order`(`order_no`) values("201911190003");-- order_id=4

insert into order_detail(`order_id`,product_id,qty) values("2",2,2);
insert into order_detail(`order_id`,product_id,qty) values("3",2,2);
insert into order_detail(`order_id`,product_id,qty) values("4",2,2);
```
可以看到
order_detail按order_id分布到与order中id相同的记录分布在同一个分区上。
