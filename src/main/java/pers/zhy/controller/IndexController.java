package pers.zhy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.frame4j.annotation.Action;
import pers.frame4j.annotation.Controller;
import pers.frame4j.bean.View;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Action("get:/index")
	public View index() {
		logger.debug("index is ok");
		return new View("index.html");
	}
	
	@Action("get:/about")
	public View about() {
		logger.debug("about is ok");
		return new View("about.html");
	}
	
	@Action("get:/contact")
	public View contact() {
		return new View("contact.html");
	}
	
	@Action("get:/display")
	public View display() {
		return new View("display.html");
	}
	
	@Action("get:/news")
	public View news() {
		return new View("news.html");
	}
	
	@Action("get:/order")
	public View order() {
		return new View("order.html");
	}
	
	@Action("get:/route")
	public View route() {
		return new View("route.html");
	}
}
