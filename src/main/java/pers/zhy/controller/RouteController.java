package pers.zhy.controller;

import java.util.List;

import pers.frame4j.annotation.Action;
import pers.frame4j.annotation.Controller;
import pers.frame4j.annotation.Inject;
import pers.frame4j.bean.Data;
import pers.zhy.model.Route;
import pers.zhy.service.RouteService;

@Controller
public class RouteController {
	
	@Inject
	private RouteService routeService; 
	
	@Action("get:/allRoute")
	public Data getRouteList() {
		List<Route> list = routeService.getRouteList();
		return new Data(list);
	}
}
