package com.ecommerce.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderReqPayload {
	private Long ordNum;
	private boolean locked;
	private String ordDB;
	private Long grpId;
	private String grpTyp;
	private String ordTyp;
	private String hybOfferFlg;
	private Date crDt;
	private String crBy;
	private Date updDt;
	private String updBy;
	
	public OrderReqPayload() {
		
	}
	
	public Long getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(Long ordNum) {
		this.ordNum = ordNum;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getOrdDB() {
		return ordDB;
	}
	public void setOrdDB(String ordDB) {
		this.ordDB = ordDB;
	}
	public Long getGrpId() {
		return grpId;
	}
	public void setGrpId(Long grpId) {
		this.grpId = grpId;
	}
	public String getGrpTyp() {
		return grpTyp;
	}
	public void setGrpTyp(String grpTyp) {
		this.grpTyp = grpTyp;
	}
	public String getOrdTyp() {
		return ordTyp;
	}
	public void setOrdTyp(String ordTyp) {
		this.ordTyp = ordTyp;
	}
	public String getHybOfferFlg() {
		return hybOfferFlg;
	}
	public void setHybOfferFlg(String hybOfferFlg) {
		this.hybOfferFlg = hybOfferFlg;
	}
	public Date getCrDt() {
		return crDt;
	}
	public void setCrDt(Date crDt) {
		this.crDt = crDt;
	}
	public String getCrBy() {
		return crBy;
	}
	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}
	public Date getUpdDt() {
		return updDt;
	}
	public void setUpdDt(Date updDt) {
		this.updDt = updDt;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	

}
