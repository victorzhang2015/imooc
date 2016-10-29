package com.victor.exception;
/**
 * 
 * 秒杀业务项目异常
 * @author zhangteng
 *
 */
public class SecKillException extends RuntimeException{

	public SecKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SecKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
