create table open.app
(
  app_id       varchar(100)                        not null
    primary key,
  app_secret   varchar(100)                        not null,
  domain       varchar(100)                        not null,
  created_time timestamp default CURRENT_TIMESTAMP null,
  updated_time timestamp                           null
)
  engine = InnoDB;


