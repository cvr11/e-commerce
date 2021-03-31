package com.ecommerce.util;

import org.springframework.stereotype.Component;

import com.ecommerce.model.OrderReqPayload;
import com.ecommerce.model.Orders;
import com.ecommerce.model.ResponsePayload;

@Component
public class OrdersUtil {

	public ResponsePayload getResponse(Orders order, OrderReqPayload request) {
		ResponsePayload resp = new ResponsePayload();
		try {
		if (order.getOrdNum()!=null) {
			resp.setOrdId(order.getOrdNum());
		}
		resp.setStatus("Sucess");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception {}" +e);
		}
		return resp;
	}

}
