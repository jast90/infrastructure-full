create table post
(
  id               int auto_increment
    primary key,
  app_id           varchar(100)                        not null,
  post_author      int                                 not null,
  post_title       varchar(500)                        not null,
  post_description varchar(200)                        not null,
  post_content     varchar(5000)                       not null,
  created_time     timestamp default CURRENT_TIMESTAMP not null,
  updated_time     timestamp                           null
)
  engine = InnoDB;

create table post_comment
(
  comment_id           int auto_increment
    primary key,
  app_id               varchar(100)                        not null,
  post_id              int                                 not null,
  comment_author       int                                 not null,
  comment_author_ip    int                                 null,
  comment_author_email varchar(100)                        null,
  comment_author_url   varchar(100)                        null,
  comment_parent       int                                 null,
  created_time         timestamp default CURRENT_TIMESTAMP not null,
  updated_time         timestamp                           null
)
  engine = InnoDB;


