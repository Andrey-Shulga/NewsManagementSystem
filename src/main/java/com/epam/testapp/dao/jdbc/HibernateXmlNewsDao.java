package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("HibernateXmlNewsDao")
public class HibernateXmlNewsDao extends GenericDao<News> implements NewsDao {
}
