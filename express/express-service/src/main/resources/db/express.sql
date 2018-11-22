create table account_express
(
  express_id        int auto_increment
    primary key,
  app_id            varchar(100)                            not null,
  sender_account_id int                                     not null,
  longitude         decimal(10, 4)                          not null
  comment '经度',
  latitude          decimal(10, 4)                          null
  comment '纬度',
  from_address      varchar(512)                            not null,
  to_address        varchar(512)                            null,
  item_description  varchar(256)                            not null
  comment '寄件物品描述，多大体积、多大质量（如：鞋子一双，2kg）',
  created_time      timestamp default CURRENT_TIMESTAMP     not null,
  updated_time      timestamp null
);


