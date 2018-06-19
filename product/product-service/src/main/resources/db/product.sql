create table product
(
  product_id   int auto_increment
    primary key,
  product_name varchar(512)                        not null,
  product_code varchar(128)                        null,
  product_desc varchar(256)                        null,
  app_id       varchar(100)                        not null,
  created_time timestamp default CURRENT_TIMESTAMP not null,
  updated_time timestamp                           null,
  constraint product_product_code_uindex
  unique (product_code)
)
  engine = InnoDB;

create table product_sku_attr_ref
(
  ref_id         int auto_increment
    primary key,
  product_id     int                                 not null,
  sku_attr_id    int                                 not null,
  sku_attr_value varchar(100)                        not null,
  app_id         varchar(100)                        not null,
  created_time   timestamp default CURRENT_TIMESTAMP not null,
  updated_time   timestamp                           null,
  constraint uindex
  unique (product_id, sku_attr_id, sku_attr_value)
)
  engine = InnoDB;

create table sku
(
  sku_id       int auto_increment
    primary key,
  product_id   int                                 not null,
  sku_code     varchar(128)                        not null,
  price        decimal(18, 4)                      null,
  app_id       varchar(100)                        not null,
  created_time timestamp default CURRENT_TIMESTAMP not null,
  updated_time timestamp                           null,
  constraint product_sku_sku_code_uindex
  unique (sku_code)
)
  engine = InnoDB;

create table sku_attr
(
  sku_attr_id     int auto_increment
    primary key,
  attr_name       varchar(128)                        not null,
  attr_code       varchar(128)                        not null,
  attr_desc       varchar(256)                        null,
  sku_category_id int                                 not null,
  app_id          varchar(100)                        not null,
  created_time    timestamp default CURRENT_TIMESTAMP not null,
  updated_time    timestamp                           null
)
  engine = InnoDB;

create table sku_attr_ref
(
  ref_id         int auto_increment
    primary key,
  sku_id         int                                 not null,
  sku_attr_id    int                                 not null,
  sku_attr_value varchar(100)                        not null,
  app_id         varchar(100)                        not null,
  created_time   timestamp default CURRENT_TIMESTAMP not null,
  updated_time   timestamp                           null
)
  engine = InnoDB;

create table sku_category
(
  category_id   int auto_increment
    primary key,
  category_name varchar(128)                        not null,
  category_desc varchar(256)                        null,
  app_id        varchar(100)                        not null,
  created_time  timestamp default CURRENT_TIMESTAMP not null,
  updated_time  timestamp                           null
)
  engine = InnoDB;


