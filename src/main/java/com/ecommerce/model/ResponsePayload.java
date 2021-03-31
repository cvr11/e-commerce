package com.ecommerce.model;

public class ResponsePayload {
	private String status;
	private Long ordId;
	
	public ResponsePayload() {
		
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

}
