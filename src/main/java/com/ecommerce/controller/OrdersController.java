package com.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.OrderReqPayload;
import com.ecommerce.model.Orders;
import com.ecommerce.model.ResponsePayload;
import com.ecommerce.repository.OrdersRepository;
import com.ecommerce.service.OrdersService;
import com.fasterxml.jackson.core.util.RequestPayload;

@RestController
public class OrdersController {
	
	private static final Logger log = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	OrdersService orderservice;
	@Autowired
	OrdersRepository ordRepository;
	ResponsePayload respPayload = new ResponsePayload();
	
	@PostMapping(value = "processOrder")
	@ResponseBody
	//public ResponsePayload getOrderProcess(@RequestBody OrderReqPayload reqPaylaod) {
	public ResponsePayload getOrderProcess(@RequestBody Orders reqPaylaod) {
		log.info("Order Process have Initiating...");
		try {
			 ordRepository.save(reqPaylaod);
			//respPayload = orderservice.processOrder(reqPaylaod);
			 respPayload.setOrdId(reqPaylaod.getOrdNum());
			 respPayload.setStatus("Suscess");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error",e);
		}
		return respPayload;
	}

	@GetMapping(value = "getorder")
	@ResponseBody
	//public ResponsePayload getOrderProcess(@RequestBody OrderReqPayload reqPaylaod) {
	public List<Orders> getOrder() {
		log.info("Order Process have Initiating...");
		List<Orders> orders= null;
		try {
			orders = ordRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error",e);
		}
		return orders;
	}
	
	@PostMapping(value = "po")
	@ResponseBody
	public ResponsePayload getProcessOrder(@RequestBody OrderReqPayload reqPaylaod) {
		try {
			log.info("Order Process have Initiating...");
			respPayload = orderservice.processOrder(reqPaylaod);
			log.info("Order Process have been Completed Sucessfulluy...");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error",e);
			log.info("Order Process have been throughing an Error {}...", e);
		}
		return respPayload;
	}
}
