package com.epam.testapp.dao;

import com.epam.testapp.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:testAppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value = "transactionManager")
public class DaoTest {

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;


    @Test
    @Transactional(value = "transactionManager")

    public void testSaveNews() {

        // com.epam.testapp.util.HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        News news = new News("testTitle", new Date(), "testBrief", "testContent");
        News saveNews = newsDao.save(news);
        // com.epam.testapp.util.HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

        assertNotNull(saveNews);
    }
}
