--数据库初始化脚本
create database seckill;
--使用数据库
use seckill
--创建秒杀库存表
create table seckill(
	`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
	`name` varchar(120) NOT NULL COMMENT '商品名称',
	`number` int NOT NULL COMMENT '库存数量',
	`create_time` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
	`start_time` timestamp NOT NULL COMMENT '秒杀开启时间',
	`end_time` timestamp NOT NULL COMMENT '秒杀结束时间',
	primary key (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';
--innoDB 支持事物
--初始化数据
insert into seckill (name,number,start_time,end_time) values 
('1000元秒杀iphone 6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('500元秒杀ipad2',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('300元秒杀小米 6',300,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('200元秒杀红米note',400,'2015-11-01 00:00:00','2015-11-02 00:00:00');
--秒杀成功明细表
--用户登录认证相关的信息
create table success_killed(
	`seckill_id` bigint not null COMMENT '秒杀商品id',
	`user_phone` bigint not null COMMENT '用户手机号',
	`status` tinyint not null default -1  COMMENT '状态表示: -1:无效 0：成功 1：已付款 2：已发货',
	`create_time` timestamp not null COMMENT '创建时间',
	primary key(seckill_id,user_phone),/* 联合主键方式*/
	key idx_create_time(create_time)
)Engine=innoDB DEFAULT CHARSET=utf8 COMMENT='秒杀明细表';

--连接数据库控制台
mysql -uroot -p