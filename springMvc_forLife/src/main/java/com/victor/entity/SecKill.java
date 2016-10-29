package com.victor.entity;

import java.util.Date;

public class SecKill {
	private long secKillid;
	private String name;
	private int number;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	public long getSeckillid() {
		return secKillid;
	}
	public void setSeckillid(long seckillid) {
		this.secKillid = seckillid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Seckill [seckillid=" + secKillid + ", name=" + name
				+ ", number=" + number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
	
}
