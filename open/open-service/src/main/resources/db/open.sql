create table app
(
  app_id       varchar(100)                        not null
    primary key,
  app_secret   varchar(100)                        not null,
  domain       varchar(100)                        not null,
  created_time timestamp default CURRENT_TIMESTAMP null,
  updated_time timestamp                           null
);

create table app_social_ref
(
  app_id            int                                      not null
    primary key,
  social            enum ('WECHAT', 'WEIBO', 'QQ', 'GITHUB') not null,
  social_app_id     varchar(256)                             not null,
  social_app_secret varchar(256)                             not null,
  created_time      timestamp default CURRENT_TIMESTAMP      not null,
  updated_time      timestamp default '0000-00-00 00:00:00'  not null
)
  comment '应用社交配置';


