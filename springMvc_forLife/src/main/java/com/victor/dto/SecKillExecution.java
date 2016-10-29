package com.victor.dto;

import com.victor.entity.SuccessKilled;
import com.victor.enums.SecKillStatusEnum;

/**
 * ������װ��ɱִ�к�Ĳ���
 * @author zhangteng
 *
 */
public class SecKillExecution {
	private long seckillId;
	//ִ����ɱ���״̬
	private int state;
	//״̬��ʾ
	private String stateinfo;
	//��ɱ�ɹ�����
	private SuccessKilled successKilled;
	
	public SecKillExecution(long seckillId, SecKillStatusEnum statusEnum) {
		super();
		this.seckillId = seckillId;
		this.state = statusEnum.getStatus();
		this.stateinfo = statusEnum.getStatusInfo();
	}
	public SecKillExecution(long seckillId, SecKillStatusEnum statusEnum,SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = statusEnum.getStatus();
		this.stateinfo = statusEnum.getStatusInfo();
		this.successKilled = successKilled;
	}
	
	/**
	 * @return the seckillId
	 */
	public long getSeckillId() {
		return seckillId;
	}
	/**
	 * @param seckillId the seckillId to set
	 */
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the stateinfo
	 */
	public String getStateinfo() {
		return stateinfo;
	}
	/**
	 * @param stateinfo the stateinfo to set
	 */
	public void setStateinfo(String stateinfo) {
		this.stateinfo = stateinfo;
	}
	/**
	 * @return the successKilled
	 */
	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
	/**
	 * @param successKilled the successKilled to set
	 */
	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecKillExecution [seckillId=" + seckillId + ", state=" + state
				+ ", stateinfo=" + stateinfo + ", successKilled="
				+ successKilled + "]";
	}
}
