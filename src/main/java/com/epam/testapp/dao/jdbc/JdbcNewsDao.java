package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcNewsDao extends JdbcGenericDao<News> implements NewsDao {
}
