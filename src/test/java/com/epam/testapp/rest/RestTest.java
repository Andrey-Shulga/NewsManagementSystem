package com.epam.testapp.rest;

import com.epam.testapp.model.News;
import com.epam.testapp.util.DateConverter;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static com.jayway.jsonassert.impl.matcher.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(locations = {"classpath:testAppContext.xml", "classpath:dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@Transactional
@WebAppConfiguration
public class RestTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SessionFactory sessionFactory;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void getAllNewsListTest() throws Exception {

        mockMvc.perform(get("/rest/news"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].title", is("testTitle2")))
                .andExpect(jsonPath("$[0].date", is(DateConverter.getStrDateToLong("2017-05-07 17:31:32"))))
                .andExpect(jsonPath("$[0].brief", is("testBrief2")))
                .andExpect(jsonPath("$[0].content", is("testContent2")))
                .andExpect(jsonPath("$[1].id", is(1)))
                .andExpect(jsonPath("$[1].title", is("testTitle")))
                .andExpect(jsonPath("$[1].date", is(DateConverter.getStrDateToLong("2017-05-06 17:31:32"))))
                .andExpect(jsonPath("$[1].brief", is("testBrief")))
                .andExpect(jsonPath("$[1].content", is("testContent")));
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void getNewsByIdTest() throws Exception {

        final long testId = 1L;
        mockMvc.perform(get("/rest/news/get/{id}", testId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(testId)))
                .andExpect(jsonPath("$.title", is("testTitle")))
                .andExpect(jsonPath("$.date", is(DateConverter.getStrDateToLong("2017-05-06 17:31:32"))))
                .andExpect(jsonPath("$.brief", is("testBrief")))
                .andExpect(jsonPath("$.content", is("testContent")));
    }

    @Test
    public void saveNews() throws Exception {

        final long givenId = 1;
        final long jsonDate = 1494569142000L;
        Date testDate = new Date(jsonDate);
        News newsToSave = new News("testTitle", testDate, "testBrief", "testContent");
        ObjectMapper mapper = new ObjectMapper();

        News notExistNews = (News) sessionFactory.getCurrentSession().get(News.class, givenId);
        assertNull(notExistNews);

        mockMvc.perform(post("/rest/news/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(newsToSave)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is((int) givenId)))
                .andExpect(jsonPath("$.title", is("testTitle")))
                .andExpect(jsonPath("$.date", is(jsonDate)))
                .andExpect(jsonPath("$.brief", is("testBrief")))
                .andExpect(jsonPath("$.content", is("testContent")));
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void deleteNews() throws Exception {

        final long testId = 1;
        News newsToDelete = new News(testId);
        ObjectMapper mapper = new ObjectMapper();

        News existNews = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertNotNull(existNews);
        sessionFactory.getCurrentSession().clear();

        mockMvc.perform(post("/rest/news/delete")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(newsToDelete)))
                .andExpect(status().isOk());

        News notExistNews = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertNull(notExistNews);
    }

    @Test
    @DatabaseSetup("/sampleData.xml")
    public void editNews() throws Exception {

        final long testId = 1;
        ObjectMapper mapper = new ObjectMapper();

        Date editedDate = DateConverter.getStrToDate("2017-05-07 17:31:32");
        News editedNews = new News(testId, "testTitleUpdate", editedDate, "testBriefUpdate", "testContentUpdate");
        News originalNews = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertNotEquals(editedNews, originalNews);
        sessionFactory.getCurrentSession().clear();

        mockMvc.perform(post("/rest/news/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(editedNews)))
                .andExpect(status().isOk());

        News result = (News) sessionFactory.getCurrentSession().get(News.class, testId);
        assertEquals(editedNews, result);
    }
}
