package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("HibernateJpaNewsDao")
public class HibernateJpaNewsDao extends GenericDao<News> implements NewsDao {
}
