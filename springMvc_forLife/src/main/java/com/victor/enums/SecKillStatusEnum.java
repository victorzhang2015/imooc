package com.victor.enums;

public enum SecKillStatusEnum {
	SUCCESS(1,"秒杀成功"),
	END(2,"秒杀结束"),
	REPEAT_KILL(-1,"重复秒杀"),
	INNER_ERROR(-2,"系统异常"),
	DATA_REWRITE(-3,"数据篡改");
	private int status;
	private String statusInfo;
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the statusInfo
	 */
	public String getStatusInfo() {
		return statusInfo;
	}
	/**
	 * @param statusInfo the statusInfo to set
	 */
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	private SecKillStatusEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}
	public static SecKillStatusEnum statusOf(int index){
		for(SecKillStatusEnum status:values()){
			if(status.getStatus()==index){
				
			}
		}
		return null;
	}
	
}
