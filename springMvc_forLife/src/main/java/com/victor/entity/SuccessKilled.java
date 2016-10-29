package com.victor.entity;

import java.util.Date;

public class SuccessKilled {
	private long secKillid;
	private long userphone;
	private short stats;
	private Date createTime;
	//变通
	// 多对一
	private SecKill secKill;
	/**
	 * @return the secKillid
	 */
	public long getSecKillid() {
		return secKillid;
	}
	/**
	 * @param secKillid the secKillid to set
	 */
	public void setSecKillid(long secKillid) {
		this.secKillid = secKillid;
	}
	/**
	 * @return the userphone
	 */
	public long getUserphone() {
		return userphone;
	}
	/**
	 * @param userphone the userphone to set
	 */
	public void setUserphone(long userphone) {
		this.userphone = userphone;
	}
	/**
	 * @return the stats
	 */
	public short getStats() {
		return stats;
	}
	/**
	 * @param stats the stats to set
	 */
	public void setStats(short stats) {
		this.stats = stats;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the secKill
	 */
	public SecKill getSecKill() {
		return secKill;
	}
	/**
	 * @param secKill the secKill to set
	 */
	public void setSecKill(SecKill secKill) {
		this.secKill = secKill;
	}
	@Override
	public String toString() {
		return "SuccessKilled [seckillid=" + secKillid + ", userphone="
				+ userphone + ", stats=" + stats + ", createTime=" + createTime
				+ "]";
	}
	
	
}
