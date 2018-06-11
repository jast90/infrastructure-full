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
  unique (account_name),
  constraint account_username_from_pk
  unique (account_from)
)
  engine = InnoDB;

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
  comment '账号关联的社交账号'
  engine = InnoDB;


