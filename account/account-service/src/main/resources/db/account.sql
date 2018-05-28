create table account
(
  account_id   int auto_increment
    primary key,
  account_name varchar(100)                        not null,
  first_name   varchar(100)                        null,
  last_name    varchar(100)                        null,
  email        varchar(100)                        null,
  username     varchar(100)                        null,
  acount_from  varchar(100)                        null
  comment '用户来源：github,qq,wx,weibo',
  created_time timestamp default CURRENT_TIMESTAMP not null,
  updated_time timestamp                           null,
  constraint account_username_from_pk
  unique (username, acount_from)
);


