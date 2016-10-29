package com.victor.service;

import java.util.List;

import com.victor.dto.Exposer;
import com.victor.dto.SecKillExecution;
import com.victor.entity.SecKill;
import com.victor.exception.RepeatKillException;
import com.victor.exception.SecKillCloseException;
import com.victor.exception.SecKillException;

/**
 * ҵ��ӿڣ�վ�ڡ�ʹ���ߡ��Ƕ���ƽӿ�
 * ���������������������ȣ��������������ͣ�return ����/�쳣��
 * @author zhangteng
 *
 */
public interface SecKillService {
	/**
	 * ��ѯ������ɱ��¼
	 * @return
	 */
	List<SecKill> getSeckillList();
	/**
	 * ��ѯ������ɱ�ӿ�
	 * @param SecKillId
	 * @return
	 */
	SecKill getById(long secKillId);
	/**
	 * ��ɱ��ʼʱ�����ɱ�ӿڵĵ�ַ���������ϵͳʱ��
	 * @param secKillId
	 */
	Exposer exportSecKillUrl(long secKillId);

	/**
	 * ִ����ɱ����
	 * @param seckillid
	 * @param userphone
	 * @param md5
	 */
	SecKillExecution executeSeckill(long seckillid,long userphone,String md5) throws RepeatKillException,SecKillCloseException,SecKillException;
	

}
