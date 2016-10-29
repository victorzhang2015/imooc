--���ݿ��ʼ���ű�
create database seckill;
--ʹ�����ݿ�
use seckill
--������ɱ����
create table seckill(
	`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
	`name` varchar(120) NOT NULL COMMENT '��Ʒ����',
	`number` int NOT NULL COMMENT '�������',
	`create_time` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��',
	`start_time` timestamp NOT NULL COMMENT '��ɱ����ʱ��',
	`end_time` timestamp NOT NULL COMMENT '��ɱ����ʱ��',
	primary key (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='��ɱ����';
--innoDB ֧������
--��ʼ������
insert into seckill (name,number,start_time,end_time) values 
('1000Ԫ��ɱiphone 6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('500Ԫ��ɱipad2',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('300Ԫ��ɱС�� 6',300,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('200Ԫ��ɱ����note',400,'2015-11-01 00:00:00','2015-11-02 00:00:00');
--��ɱ�ɹ���ϸ��
--�û���¼��֤��ص���Ϣ
create table success_killed(
	`seckill_id` bigint not null COMMENT '��ɱ��Ʒid',
	`user_phone` bigint not null COMMENT '�û��ֻ���',
	`status` tinyint not null default -1  COMMENT '״̬��ʾ: -1:��Ч 0���ɹ� 1���Ѹ��� 2���ѷ���',
	`create_time` timestamp not null COMMENT '����ʱ��',
	primary key(seckill_id,user_phone),/* ����������ʽ*/
	key idx_create_time(create_time)
)Engine=innoDB DEFAULT CHARSET=utf8 COMMENT='��ɱ��ϸ��';

--�������ݿ����̨
mysql -uroot -p