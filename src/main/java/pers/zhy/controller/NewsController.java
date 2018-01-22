package pers.zhy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.frame4j.annotation.Action;
import pers.frame4j.annotation.Controller;
import pers.frame4j.annotation.Inject;
import pers.frame4j.bean.Data;
import pers.zhy.model.News;
import pers.zhy.service.NewsService;

@Controller
public class NewsController {
	
	@Inject
	private NewsService newsService;
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	@Action("get:/allNews")
    public Data index() {
        List<News> newsList = newsService.getNewsList();
        logger.debug(newsList.toString());
        return new Data(newsList);
    }
}
