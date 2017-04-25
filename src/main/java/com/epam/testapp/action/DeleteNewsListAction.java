package com.epam.testapp.action;

import com.epam.testapp.model.News;
import com.epam.testapp.model.NewsForm;
import com.epam.testapp.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.epam.testapp.constant.ConstantHolder.SUCCESS;

public class DeleteNewsListAction extends Action {

    @Autowired
    NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        long[] newsIdToDelete = newsForm.getNewsToDelete();
        List<News> newsList = new ArrayList<>();
        for (long newsId : newsIdToDelete) {
            News news = new News(newsId);
            newsList.add(news);
        }
        newsService.deleteList(newsList);

        return mapping.findForward(SUCCESS);

    }
}
