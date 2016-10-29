package com.victor.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * 配置junit与spring的整合
 * @author zhangteng
 *
 */
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.victor.entity.SecKill;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	/**
	 * 减库存
	 * @param secKillid
	 * @param killTime
	 * @return
	 * 如果影响行数>1 表示更新的记录行数
	 */
	@Resource //spring 会去容器中去查找
	private SeckillDao  seckillDao;
	
	@Test
	public void  testQueryById()  throws Exception{
		long id =1000;
		SecKill secKill =seckillDao.queryById(id);
		System.out.println(secKill.getName());
		System.out.println(secKill.toString());
	}
	
	@Test
	public void testReduceNumber() throws Exception{
		
	}
	
	/**
	 * 
	 * 根据id查询一条秒杀信息
	 * @param seckillId
	 * @return
	 */
	
	/**
	 * 根据偏移量查询秒杀信息
	 * @return
	 */
	@Test
	public void  testQueryAll()  throws Exception {
		
	}

}
