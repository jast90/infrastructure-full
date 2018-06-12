create table post.post
(
  id           int auto_increment
    primary key,
  post_author  int                                 not null,
  post_title   varchar(500)                        not null,
  post_content varchar(5000)                       not null,
  created_time timestamp default CURRENT_TIMESTAMP not null,
  updated_time timestamp                           null
)
  engine = InnoDB;


