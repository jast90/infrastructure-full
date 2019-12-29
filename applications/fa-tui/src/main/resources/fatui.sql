create database fatui;
use fatui;
drop table  if exists store;
CREATE TABLE store (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    user_name VARCHAR(128) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(256) NOT NULL,
    main_pic VARCHAR(256) NOT NULL,
    create_time DATETIME DEFAULT now(),
    update_time DATETIME NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB AUTO_INCREMENT=1 CHARSET=UTF8;

drop table if exists chat;
CREATE TABLE chat (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    unique_topic varchar(256) not null,
    create_time DATETIME DEFAULT now(),
    update_time DATETIME NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB AUTO_INCREMENT=1 CHARSET=UTF8;

drop table if exists post;
create table post(
	id bigint not null auto_increment,
    title varchar(512) not null ,
    description varchar(512) not null,
    content varchar(2014) not null,
    create_time DATETIME DEFAULT now(),
    update_time DATETIME NULL,
    PRIMARY KEY (id)
)engine=InnoDB auto_increment=1 charset=utf8;
