create table `order`
(
  order_id     int auto_increment
    primary key,
  order_no     varchar(100)                                                               not null,
  total_amount decimal                                                                    not null,
  pay_amount   decimal                                                                    not null,
  status       enum ('pending', 'unreachable', 'unpaid', 'paid', 'unshipped', 'finished') null
  comment '订单状态，取值：pending（待处理），unreachable（无法到货），unpaid（未付款），paid（付款成功），unshipped（未出货）
	，finished（已完成）',
  payment_type enum ('wxpay', 'alipay')                                                   null
  comment '支付方式，取值：wxpay（微信），alipay（支付宝）',
  account_id   int                                                                        not null
  comment '下单账户',
  created_time timestamp default CURRENT_TIMESTAMP                                        null,
  updated_time timestamp default CURRENT_TIMESTAMP                                        null,
  constraint p_order_order_no_uindex
  unique (order_no)
)
  engine = InnoDB;

create table order_item
(
  item_id      int auto_increment
    primary key,
  order_id     int                                 not null,
  product_id   int                                 not null,
  product_name varchar(100)                        null,
  quantity     int                                 null,
  pay_amount   decimal                             not null,
  created_time timestamp default CURRENT_TIMESTAMP not null,
  update_time  timestamp default CURRENT_TIMESTAMP not null
)
  comment '明细'
  engine = InnoDB;


