package com.victor.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.victor.entity.SecKill;

public interface SeckillDao {
	/**
	 * �����
	 * @param secKillid
	 * @param killTime
	 * @return
	 * ���Ӱ������>1 ��ʾ���µļ�¼����
	 */
	int reduceNumber(@Param("secKillId")long secKillId,@Param("killTime")Date killTime);
	
	/**
	 * 
	 * ����id��ѯһ����ɱ��Ϣ
	 * @param seckillId
	 * @return
	 */
	SecKill queryById(long seckillId);
	/**
	 * ����ƫ������ѯ��ɱ��Ϣ
	 * @return
	 */
	List<SecKill> queryAll(@Param("offset")int offset,@Param("limit")int limit);

}
