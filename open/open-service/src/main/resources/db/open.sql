/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/23 15:00:47                           */
/*==============================================================*/


drop table if exists app;

drop index app_pay_index on app_pay_config;

drop table if exists app_pay_config;

drop table if exists app_pay_config_details;

drop table if exists app_social;

/*==============================================================*/
/* Table: app                                                   */
/*==============================================================*/
create table app
(
   app_id               varchar(128) not null,
   app_secret           varchar(100) not null,
   domain               varchar(100) not null,
   created_time         timestamp not null default CURRENT_TIMESTAMP,
   updated_time         timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (app_id)
);

/*==============================================================*/
/* Table: app_pay_config                                        */
/*==============================================================*/
create table app_pay_config
(
   app_pay_config_id    bigint not null auto_increment,
   app_id               varchar(128) not null,
   pay_platform         enum("alipay","wechat_pay") not null,
   created_time         timestamp not null default CURRENT_TIMESTAMP,
   updated_time         timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (app_pay_config_id)
);

/*==============================================================*/
/* Index: app_pay_index                                         */
/*==============================================================*/
create unique index app_pay_index on app_pay_config
(
   app_id,
   pay_platform
);

/*==============================================================*/
/* Table: app_pay_config_details                                */
/*==============================================================*/
create table app_pay_config_details
(
   app_pay_config_id    bigint not null,
   attr_name            enum("app_id","app_secret","mch_id","pay_key","cert") not null,
   attr_value           text,
   created_time         timestamp default CURRENT_TIMESTAMP,
   updated_time         timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (app_pay_config_id, attr_name)
);

/*==============================================================*/
/* Table: app_social                                            */
/*==============================================================*/
create table app_social
(
   app_id               varchar(128) not null,
   social               enum("WECHAT","QQ","GITHUB") not null,
   social_app_id        varchar(256) not null,
   social_app_secret    varchar(256) not null,
   created_time         timestamp not null default CURRENT_TIMESTAMP,
   updated_time         timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (app_id)
);

alter table app_pay_config add constraint FK_app_pay_config_ref foreign key (app_id)
      references app (app_id) on delete restrict on update restrict;

alter table app_pay_config_details add constraint FK_app_pay_config_detail_ref foreign key (app_pay_config_id)
      references app_pay_config (app_pay_config_id) on delete restrict on update restrict;

alter table app_social add constraint FK_app_social_ref foreign key (app_id)
      references app (app_id) on delete restrict on update restrict;




create table account
(
  account_id   int auto_increment
    primary key,
  app_id       varchar(100)                        not null
  comment '应用编号',
  account_name varchar(100)                        not null,
  first_name   varchar(100)                        null,
  last_name    varchar(100)                        null,
  phone        varchar(100)                        null,
  email        varchar(100)                        null,
  account_from varchar(100)                        null
  comment '用户来源：github,qq,wx,weibo,null（不是通过社交网站注册的）',
  created_time timestamp default CURRENT_TIMESTAMP not null,
  updated_time timestamp                           null,
  constraint account_account_name_uindex
  unique (account_name, account_from)
);

create table account_password
(
  account_id       int                                     not null
    primary key,
  account_password varchar(256)                            null,
  created_time     timestamp default CURRENT_TIMESTAMP     not null
  on update CURRENT_TIMESTAMP,
  updated_time     timestamp default '0000-00-00 00:00:00' not null
)
  comment '用户密码';

create table account_social_ref
(
  account_id   int                                 not null,
  social       enum ('weixin', 'weibo', 'github')  not null
  comment '社交网站，如：weixin，weibo，github',
  app_id       varchar(100)                        not null
  comment '应用编号',
  username     varchar(100)                        null,
  first_name   varchar(100)                        null,
  last_name    varchar(100)                        null,
  email        varchar(100)                        null,
  created_time timestamp default CURRENT_TIMESTAMP not null,
  updated_time timestamp                           null,
  primary key (account_id, social, app_id)
)
  comment '账号关联的社交账号';




