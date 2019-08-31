-- 为什么要写该.sql脚本？
-- 权当是对数据库操作的一个记录，在企业开发中，可能会存在多个版本，使用该脚本可以清楚的看出每个版本进行了哪些更新，并且对于其他开发人员
-- 更友好

--数据库初始化脚本

--创建数据库
CREATE  DATABASE seckill;
--使用数据库
use seckill;

--创建秒杀库存表;
CREATE  TABLE seckill(
  seckill_id  BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  name VARCHAR(120) NOT NULL COMMENT'商品名称',
  number int NOT NULL COMMENT '商品数量',
  start_time timestamp NOT NULL COMMENT '秒杀开启时间',
  end_time timestamp NOT NULL COMMENT '秒杀结束时间',
  create_time timestamp NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  PRIMARY KEY(seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=UTF8 COMMENT '秒杀库存表';--最后一个分号一定要打,不然无法运行

--初始化数据
insert into
  seckill(name,number,start_time,end_time)
values
  ('3000元秒杀iphoneXr','100','2019-06-04 00:0000','2019-06-04 00:00:00'),
  ('2000元秒杀ipad mini','200','2019-06-01 00:0000','2019-06-15 00:00:00'),
  ('1000元秒杀小米9','300','2019-06-01 00:0000','2019-06-15 00:00:00'),
  ('1500元秒杀华为mate10','100','2019-06-01 00:0000','2019-06-15 00:00:00');

--秒杀成功明细表
--用户登入验证消息
create table success_killed(
  seckill_id BIGINT not NULL comment '商品id',
  user_phone BIGINT NOT NULL COMMENT '用户手机号',
  state TINYINT NOT NULL DEFAULT -1 COMMENT '秒杀状态，-1代表失败；0代表成功；1代表已付款',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '秒杀行为创建时间',
  PRIMARY KEY (seckill_id, user_phone),    /*联合主键，保证一个用户对同一商品只能秒杀一次*/
  KEY idx_create_time(create_time)
) ENGINE Innodb DEFAULT CHARSET = utf8 COMMENT '秒杀明细表';

--链接数据库控制台
mysql -uroot -p