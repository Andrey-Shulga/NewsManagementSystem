package com.epam.testapp.dao;

import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:testAppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;

    @BeforeClass
    public static void setUp() throws Exception {

        Configuration cfg = new Configuration();
        cfg.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        HibernateUtil.setSessionFactory(sessionFactory);

    }

    @AfterClass
    public static void tearDown() throws Exception {

        HibernateUtil.closeSessionFactory();
    }

    @Test
    public void testSaveNews() {

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        News news = new News("testTitle", new Date(), "testBrief", "testContent");
        News savedNews = newsDao.save(news);

        assertNotNull(savedNews);
        assertNotNull(savedNews.getId());
    }
}
