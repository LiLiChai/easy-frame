package pers.zhy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.frame4j.annotation.Action;
import pers.frame4j.annotation.Controller;
import pers.frame4j.annotation.Inject;
import pers.frame4j.bean.Data;
import pers.zhy.model.Order;
import pers.zhy.service.OrderService;

@Controller
public class OrderController {
	
	@Inject
	private OrderService orderService;
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Action("get:/allOrder")
	public Data getOrderList() {
		
		List<Order> list = orderService.getOrderList();
		logger.debug(list.toString());
		return new Data(list);
	}
}
