package com.victor.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * ����junit��spring������
 * @author zhangteng
 *
 */
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.victor.entity.SecKill;

@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	/**
	 * �����
	 * @param secKillid
	 * @param killTime
	 * @return
	 * ���Ӱ������>1 ��ʾ���µļ�¼����
	 */
	@Resource //spring ��ȥ������ȥ����
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
	 * ����id��ѯһ����ɱ��Ϣ
	 * @param seckillId
	 * @return
	 */
	
	/**
	 * ����ƫ������ѯ��ɱ��Ϣ
	 * @return
	 */
	@Test
	public void  testQueryAll()  throws Exception {
		
	}

}
