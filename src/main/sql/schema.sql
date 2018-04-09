--数据库初始化脚本
--创建数据库
CREATE DATABASE seckill;
USE seckill;

CREATE TABLE seckill(
`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` VARCHAR(120) NOT NULL COMMENT '商品名称',
`number` INT NOT NULL COMMENT '库存数量',
`start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
`end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=UTF8 COMMENT='秒杀库存表';

--初始化数据
INSERT INTO seckill(name,number,start_time,end_time)
    VALUES
    ('100元秒杀小米6',10,'2018-04-04 00:00:00','2018-04-06 00:00:00'),
    ('500元秒杀小米7',10,'2018-04-04 00:00:00','2018-04-06 00:00:00'),
    ('1000元秒杀iphoneX',10,'2018-04-04 00:00:00','2018-04-06 00:00:00'),
    ('5元秒杀ipad2',10,'2018-04-04 00:00:00','2018-04-06 00:00:00'),
    ('100元秒杀华为mateRS',10,'2018-04-04 00:00:00','2018-04-06 00:00:00');

--秒杀成功明细表
CREATE TABLE  success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品id',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL COMMENT '状态 -1:无效,0-成功 1:已付款',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),
  KEY idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='秒杀成功明细表';