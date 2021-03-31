package com.ecommerce.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.OrderReqPayload;
import com.ecommerce.model.Orders;
import com.ecommerce.model.ResponsePayload;
import com.ecommerce.repository.OrdersRepository;
import com.ecommerce.service.OrdersService;
import com.ecommerce.util.OrdersUtil;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	private static final Logger log = LoggerFactory.getLogger(OrdersServiceImpl.class);
	@Autowired
	OrdersRepository orderrepo;
	@Autowired
	OrdersUtil util;
	
	@Override
	public ResponsePayload processOrder(OrderReqPayload request) {
		ResponsePayload response = new ResponsePayload();
		try {
			log.info("started");
			long startDate = System.currentTimeMillis();
			response = processRequest(request);
			long endDate = System.currentTimeMillis();
			log.info("Processing Time {}", endDate-startDate," in sec:{}",(endDate-startDate)/1000);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("erroe",e);
		}
		log.info("Completed");
		return response;
	}

	private ResponsePayload processRequest(OrderReqPayload request) {
		ResponsePayload response = new ResponsePayload();
		Orders order = new Orders();
		order = orderBuilder(request);
		orderrepo.save(order);
		try {
		 response = util.getResponse(order,request);
			//response = buildResp(order,request);
		}catch (Exception e) {
			// TODO: handle exception
			log.error("error...",e);
		}
		return response;
	}

	/*
	 * private ResponsePayload buildResp(Orders order, OrderReqPayload request) {
	 * ResponsePayload resp = new ResponsePayload(); try { if
	 * (order.getOrdNum()!=null) { resp.setOrdId(order.getOrdNum()); }
	 * resp.setStatus("Sucess");
	 * log.info("Response - ordId {}, Status{} ...",resp.getOrdId(),resp.getStatus()
	 * ); }catch (Exception e) { // TODO: handle exception
	 * System.out.println("Exception {}" +e); } return resp; }
	 */

	private Orders orderBuilder(OrderReqPayload request) {
		Orders order = new Orders();
		String hybOfferFlg = "N";
		try {
			order.setOrdDB(request.getOrdDB());
	//order.setGrpId(request.getGrpId());
	//order.setGrpTyp(request.getGrpTyp());
			if (request.getHybOfferFlg()!=null && request.getHybOfferFlg()!="N") {
				order.setHybOfferFlg(request.getHybOfferFlg());
			}else {
				order.setHybOfferFlg(hybOfferFlg);
			}
			if(request.getOrdDB()!=null && request.getOrdDB()!="MySql") {
				order.setOrdDB(request.getOrdDB());
			}else {
				order.setOrdDB("MySQL");
			}
			if(request.getOrdTyp()!=null && request.getOrdTyp()!="OnLine"){
				order.setOrdTyp(request.getOrdTyp());
			}else {
				order.setOrdTyp("Vendor");
			}
			if(request.getGrpTyp()!=null) {
				order.setGrpTyp(request.getGrpTyp());
			}
			
	//order.setCrBy("USer");
//	order.setCrDt(new Date());
//	order.setUpdDt(new Date());
//	order.setUpdBy("User");
			order.setStatus("Created");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("error:{}",e);
		}
		return order;
	}
}
