package com.victor.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.victor.entity.SecKill;

public interface SeckillDao {
	/**
	 * 减库存
	 * @param secKillid
	 * @param killTime
	 * @return
	 * 如果影响行数>1 表示更新的记录行数
	 */
	int reduceNumber(@Param("secKillId")long secKillId,@Param("killTime")Date killTime);
	
	/**
	 * 
	 * 根据id查询一条秒杀信息
	 * @param seckillId
	 * @return
	 */
	SecKill queryById(long seckillId);
	/**
	 * 根据偏移量查询秒杀信息
	 * @return
	 */
	List<SecKill> queryAll(@Param("offset")int offset,@Param("limit")int limit);

}
