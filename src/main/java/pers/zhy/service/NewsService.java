package pers.zhy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.frame4j.annotation.Service;
import pers.frame4j.helper.DatabaseHelper;
import pers.zhy.model.News;

@Service
public class NewsService {
	private static final Logger logger = LoggerFactory.getLogger(NewsService.class);

	public List<News> getNewsList() {
		String sql = "SELECT * FROM news";
		logger.debug(sql);
		return DatabaseHelper.queryEntityList(News.class, sql);
	}
}
