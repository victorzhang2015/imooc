package com.victor.dao;

import org.apache.ibatis.annotations.Param;

import com.victor.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * ���빺����ϸ���ɹ����ظ�
	 * @param secKillId
	 * @param userphone
	 * @return
	 * ���������������0��ʾ����ʧ��
	 */
	int insertSuccessKilled(@Param("secKillId")long secKillId,@Param("userphone")long userphone);
	/**
	 * ����id��ѯsuccesskilled��Я��seckill
	 * @param secKillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("secKillId")long secKillId,@Param("userphone")long userphone);
	
}
