create table store
(
  store_id     int auto_increment
    primary key,
  store_name   varchar(256)                            not null,
  address      varchar(256)                            not null,
  longitude    decimal(7, 4)                           not null
  comment '经度',
  latitude     decimal(7, 4)                           not null
  comment '纬度',
  created_time timestamp default CURRENT_TIMESTAMP     not null,
  updated_time timestamp default '0000-00-00 00:00:00' not null
)
  engine = InnoDB;

create table store_sku_stock
(
  store_id     int                                 not null,
  product_id   int                                 not null,
  sku_id       int                                 not null,
  sku_price    decimal(18, 4)                      not null,
  sku_stock    decimal(18, 2)                      not null,
  created_time timestamp default CURRENT_TIMESTAMP not null,
  update_time  timestamp                           null,
  primary key (product_id, store_id)
)
  engine = InnoDB;


