package pers.zhy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.frame4j.annotation.Service;
import pers.frame4j.helper.DatabaseHelper;
import pers.zhy.model.Route;

@Service
public class RouteService {
	
	private static final Logger logger = LoggerFactory.getLogger(RouteService.class);
	
	public List<Route> getRouteList(){
		String sql = "SELECT * FROM ROUTE";
		logger.debug(sql);
		List<Route> list = DatabaseHelper.queryEntityList(Route.class,sql);
		return list;
	}
}
