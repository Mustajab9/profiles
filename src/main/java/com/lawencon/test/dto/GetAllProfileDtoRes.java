package com.lawencon.test.dto;

import java.util.List;

public class GetAllProfileDtoRes {
	private String msg;
	private List<GetAllProfileDtoDataRes> data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<GetAllProfileDtoDataRes> getData() {
		return data;
	}

	public void setData(List<GetAllProfileDtoDataRes> data) {
		this.data = data;
	}
}
