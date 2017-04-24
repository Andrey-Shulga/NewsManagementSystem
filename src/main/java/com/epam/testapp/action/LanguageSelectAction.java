package com.epam.testapp.action;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static com.epam.testapp.constant.ConstantHolder.*;

public class LanguageSelectAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String locale = request.getParameter(LOCALE_ATTRIBUTE);
        Locale userLocale = new Locale(locale);
        request.getSession().setAttribute(Globals.LOCALE_KEY, userLocale);
        return getCurrentPage(mapping, request);
    }

    private ActionForward getCurrentPage(ActionMapping mapping, HttpServletRequest request) {

        String pageURL = request.getHeader(REFERRER);
        ActionForward currentPage;
        if (pageURL != null) {
            currentPage = new ActionForward(pageURL, true);
        } else {
            currentPage = mapping.findForward(SUCCESS);
        }
        return currentPage;
    }
}
