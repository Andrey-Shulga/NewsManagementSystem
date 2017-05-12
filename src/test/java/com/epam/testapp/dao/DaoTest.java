package com.epam.testapp.dao;

import com.epam.testapp.exception.DateConverterException;
import com.epam.testapp.model.News;
import com.epam.testapp.util.DateConverter;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:testAppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@Transactional
public class DaoTest {

    private static final Logger log = LoggerFactory.getLogger("DaoTest");

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;

    @Test
    public void testSaveNews() {

        final long nullId = 0;
        News news = createTestNews();
        News savedNews = newsDao.save(news);
        assertNotSame("Id not created", nullId, savedNews.getId());

        News result = (News) sessionFactory.getCurrentSession().get(News.class, savedNews.getId());
        assertEquals(savedNews, result);
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void testGetNewsByID() throws DateConverterException {

        final long testId = 1L;
        Date expectedDate = DateConverter.getStrToDate("2017-05-06 17:31:32");
        News expectedNews = new News(testId, "testTitle", expectedDate, "testBrief", "testContent");
        News result = newsDao.findById(News.class, testId);
        assertEquals(expectedNews, result);
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void testEditNews() throws DateConverterException {

        final long testId = 1L;
        News originalNews = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        Date editedDate = DateConverter.getStrToDate("2017-05-07 17:31:32");
        News editedNews = new News(testId, "testTitleUpdate", editedDate, "testBriefUpdate", "testContentUpdate");
        assertNotEquals(editedNews, originalNews);
        sessionFactory.getCurrentSession().clear();

        newsDao.save(editedNews);
        News result = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertEquals(editedNews, result);
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void deleteNews() {

        final long testId = 2L;
        News existNews = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertNotNull(existNews);
        sessionFactory.getCurrentSession().clear();

        News newsToDelete = new News(testId);
        newsDao.delete(newsToDelete);
        News result = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertNull(result);

    }

    private News createTestNews() {
        return new News("testTitle", new Date(), "testBrief", "testContent");
    }
}
