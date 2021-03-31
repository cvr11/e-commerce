package com.ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "OMDB.Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ordNum;
	private String ordDB;
	private String grpTyp;
	private String ordTyp;
	private String status;
	private String hybOfferFlg;
	private Date crDt = new Date();
	private String crBy = "User";
	//private Date updDt = new Date();
	//private String updBy = "User";
	
	public Orders () {
		
	}
	
	public String getGrpTyp() {
		return grpTyp;
	}

	public void setGrpTyp(String grpTyp) {
		this.grpTyp = grpTyp;
	}

	public Long getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(Long ordNum) {
		this.ordNum = ordNum;
	}
	public String getOrdDB() {
		return ordDB;
	}
	public void setOrdDB(String ordDB) {
		this.ordDB = ordDB;
	}
	public String getOrdTyp() {
		return ordTyp;
	}
	public void setOrdTyp(String ordTyp) {
		this.ordTyp = ordTyp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHybOfferFlg() {
		return hybOfferFlg;
	}
	public void setHybOfferFlg(String hybOfferFlg) {
		this.hybOfferFlg = hybOfferFlg;
	}
	
	public String getCrBy() {
		return crBy;
	}
	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}

	public Date getCrDt() {
		return crDt;
	}

	public void setCrDt(Date crDt) {
		this.crDt = crDt;
	}
		
}
