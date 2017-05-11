package com.epam.testapp.dao;

import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:testAppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
public class DaoTest {

    private static final Logger log = LoggerFactory.getLogger("DaoTest");
    @Autowired
    @Qualifier("HibernateJpaNewsDao")

    private NewsDao newsDao;

    @BeforeClass
    public static void setUp() throws Exception {


    }

    @AfterClass
    public static void tearDown() throws Exception {


        HibernateUtil.closeSessionFactory();
    }


    @Test
    @Transactional
    @Rollback
    public void testSaveNews() {

        News news = createTestNews();
        News savedNews = newsDao.save(news);

        assertNotNull(savedNews);
        assertNotSame("Id not created", 0, savedNews.getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetNewsByID() {

        News news = createTestNews();
        newsDao.save(news);
        News result = newsDao.findById(News.class, news.getId());

        assertNotNull(result);
        assertNotSame("Id not created", 0, result.getId());
        assertEquals(news.getId(), result.getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testEditNews() {

        log.debug("!!!!!!!!!");
        News news = createTestNews();
        String oldTitle = "oldTestTitle";
        String newTitle = "newTestTitle";
        news.setTitle(oldTitle);
        News savedNews = newsDao.save(news);
        assertEquals(oldTitle, savedNews.getTitle());
        savedNews.setTitle(newTitle);
        newsDao.save(savedNews);
        News result = newsDao.findById(News.class, savedNews.getId());
        assertEquals(newTitle, result.getTitle());

    }

    @Test
    @Transactional

    @Rollback
    public void deleteNews() {

        News news = createTestNews();
        News savedNews = newsDao.save(news);
        assertNotNull(savedNews);
        newsDao.delete(savedNews);
        News result = newsDao.findById(News.class, savedNews.getId());
        assertNull(result);

    }

    private News createTestNews() {
        return new News("testTitle", new Date(), "testBrief", "testContent");
    }
}
