package com.victor.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.victor.dao.SeckillDao;
import com.victor.dao.SuccessKilledDao;
import com.victor.dto.Exposer;
import com.victor.dto.SecKillExecution;
import com.victor.entity.SecKill;
import com.victor.entity.SuccessKilled;
import com.victor.enums.SecKillStatusEnum;
import com.victor.exception.RepeatKillException;
import com.victor.exception.SecKillCloseException;
import com.victor.exception.SecKillException;
import com.victor.service.SecKillService;
//@component@service @Dao @Controller

@Service
public class SecKillServiceImpl implements SecKillService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//ע��Service����
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	private final String salt="#$%wdiaerdsdfqeqr!@#!@1231231";
	@Override
	public List<SecKill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public SecKill getById(long secKillId) {
		// TODO Auto-generated method stub
		return seckillDao.queryById(secKillId);
	}

	@Override
	public Exposer exportSecKillUrl(long secKillId) {
		// TODO Auto-generated method stub
		SecKill seckill =seckillDao.queryById(secKillId);
		if(seckill==null){
			return new Exposer(false,secKillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if(nowTime.getTime()>endTime.getTime()||nowTime.getTime()<startTime.getTime()){
			return new Exposer(false,secKillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		//ת���ض��ַ��Ĺ���
		String md5=getMD5(secKillId);
		return new Exposer(true,md5,secKillId);
	}
	private String getMD5(long secKillId){
		String base = secKillId+"/"+salt;
		String md5=DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
		
	}
	@Override
	@Transactional
	/**
	 * ʹ��ע��������񷽷����ŵ�
	 * 1�������ŶӴ��һ��Լ������ȷ��ע���񷽷��ı�̷��
	 * 2����֤���񷽷�ִ�е�ʱ�価���̣ܶ���Ҫ���������������RPC/http������߰��뵽���񷽷��ⲿ
	   3:�������еķ�������Ҫ������ֻ��һ���޸Ĳ�����ֻ����������Ҫ�������
	 */
	public SecKillExecution executeSeckill(long seckillid, long userphone,
			String md5) throws RepeatKillException, SecKillCloseException,
			SecKillException {
		// TODO Auto-generated method stub
		if(md5==null||!md5.equals(getMD5(seckillid))){
			throw new SecKillException("rewrite data");
		}
		//ִ����ɱ�߼��������+��¼������Ϊ
		Date nowTime = new Date();
		try{
			int updateCount = seckillDao.reduceNumber(seckillid, nowTime);
			if(updateCount<=0){
				//û�и��µ���¼
				throw new SecKillCloseException("seckill is close");
			}else{
				//��¼������Ϊ
				int insertCount = successKilledDao.insertSuccessKilled(seckillid, userphone);
				//Ψһ��֤
				if(insertCount<=0){
					throw new RepeatKillException("seckill repeat");
				}else{
					SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillid,userphone);
					return new SecKillExecution(seckillid,SecKillStatusEnum.SUCCESS,successKilled);
				}
			}
		} catch (SecKillCloseException e1) {
			e1.getMessage();
		} catch (RepeatKillException e2) {
			e2.getMessage();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// ���б������쳣ת��Ϊ�������쳣
			throw new SecKillException("seckill inner exception"
					+ e.getMessage());
		}
		return null;
	}

}
