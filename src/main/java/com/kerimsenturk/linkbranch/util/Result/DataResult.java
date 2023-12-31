package com.kerimsenturk.linkbranch.util.Result;

public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data=data;
	}
	
	public DataResult(T data,boolean success) {
		super(success);
		this.data=data;
	}

	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data=data;
	}

}
