package com.victor.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.victor.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessSeckillDaoTest {
	@Resource
	private  SuccessKilledDao SuccesskilledDao;
	@Test
	public void testInsertSuccessKilled() throws Exception{
		long secKillId =1001L;
		long userphone=18916933130L;
		int num =SuccesskilledDao.insertSuccessKilled(secKillId, userphone);
		System.out.println("insertnum="+num);
	}
	@Test
	public void testQueryByIdWithSeckill() throws Exception{
		long secKillId =1001L;
		long userphone=18916933130L;
		SuccessKilled successKilled =SuccesskilledDao.queryByIdWithSeckill(secKillId, userphone);
		System.out.println("successKilled="+successKilled);
		System.out.println("secKill="+successKilled.getSecKill());
	}

}
