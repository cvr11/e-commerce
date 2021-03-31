package com.ecommerce.service;

import com.ecommerce.model.OrderReqPayload;
import com.ecommerce.model.ResponsePayload;

public interface OrdersService {

	ResponsePayload processOrder(OrderReqPayload reqPaylaod);

}
