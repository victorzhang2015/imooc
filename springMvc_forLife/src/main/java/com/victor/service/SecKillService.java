package com.victor.service;

import java.util.List;

import com.victor.dto.Exposer;
import com.victor.dto.SecKillExecution;
import com.victor.entity.SecKill;
import com.victor.exception.RepeatKillException;
import com.victor.exception.SecKillCloseException;
import com.victor.exception.SecKillException;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 三个方法：方法定义粒度，参数，返回类型（return 类型/异常）
 * @author zhangteng
 *
 */
public interface SecKillService {
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<SecKill> getSeckillList();
	/**
	 * 查询单个秒杀接口
	 * @param SecKillId
	 * @return
	 */
	SecKill getById(long secKillId);
	/**
	 * 秒杀开始时输出秒杀接口的地址，否则输出系统时间
	 * @param secKillId
	 */
	Exposer exportSecKillUrl(long secKillId);

	/**
	 * 执行秒杀操作
	 * @param seckillid
	 * @param userphone
	 * @param md5
	 */
	SecKillExecution executeSeckill(long seckillid,long userphone,String md5) throws RepeatKillException,SecKillCloseException,SecKillException;
	

}
