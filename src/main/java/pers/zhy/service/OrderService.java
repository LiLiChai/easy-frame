package pers.zhy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.frame4j.annotation.Service;
import pers.frame4j.helper.DatabaseHelper;
import pers.zhy.model.Order;

@Service
public class OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public List<Order> getOrderList(){
		String sql = "SELECT * FROM order";
		logger.debug(sql);
		List<Order> list = DatabaseHelper.queryEntityList(Order.class, sql);
		return list;
	}
}
