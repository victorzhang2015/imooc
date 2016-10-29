package com.victor.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.victor.dto.Exposer;
import com.victor.dto.SecKillExecution;
import com.victor.entity.SecKill;
import com.victor.exception.RepeatKillException;
import com.victor.exception.SecKillCloseException;
import com.victor.exception.SecKillException;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({
			"classpath:spring/spring-dao.xml",
			"classpath:spring/spring-service.xml"})
public class SecKillServiceImplTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SecKillService secKillService;
	@Test
	public void testSecKillLogic() throws Exception{
		long seckillid =1000;
		Exposer exposer = secKillService.exportSecKillUrl(seckillid);
		if(exposer.isExposed()){
			logger.info("Exposer={}",exposer);
			long userphone = 18916933131L;
			String md5 = exposer.getMd5();
			try{
				SecKillExecution execution = secKillService.executeSeckill(seckillid, userphone, md5);
				logger.info("Execution={}",execution);
			}catch(RepeatKillException e){
				logger.error(e.getMessage());
			}catch(SecKillCloseException e){
				logger.error(e.getMessage());
			}catch(SecKillException e){
				logger.error(e.getMessage());
			}
		}else{
			//秒杀未开启
			logger.info("Exposer={}",exposer);
		}
	}
	@Test
	public void testGetById() throws Exception{
		SecKill seckill = secKillService.getById(1000);
		logger.info("seckill={}",seckill);
	}
	@Test
	public void testGetSeckillList() throws Exception{
		List<SecKill> list = secKillService.getSeckillList();
		logger.info("List={}",list);
	}
}
