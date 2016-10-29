package com.victor.dto;

//所有ajax请求返回封装json结果
public class SecKillResult<T> {
	private boolean success;
	private T data;
	private String error;
	public SecKillResult(boolean success){
		this.success=success;
	}
	public SecKillResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}
	public SecKillResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	
}
