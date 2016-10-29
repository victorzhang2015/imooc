package com.victor.dao;

import org.apache.ibatis.annotations.Param;

import com.victor.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * 插入购买明细，可过滤重复
	 * @param secKillId
	 * @param userphone
	 * @return
	 * 插入的行数，返回0表示插入失败
	 */
	int insertSuccessKilled(@Param("secKillId")long secKillId,@Param("userphone")long userphone);
	/**
	 * 根据id查询successkilled并携带seckill
	 * @param secKillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("secKillId")long secKillId,@Param("userphone")long userphone);
	
}
