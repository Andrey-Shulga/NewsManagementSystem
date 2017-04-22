package com.epam.testapp.action;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static com.epam.testapp.constant.ConstantHolder.SUCCESS;

public class LanguageSelectAction extends DispatchAction {

    public ActionForward english(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);

        return mapping.findForward(SUCCESS);
    }

    public ActionForward russian(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        java.util.Locale ruLocale = new java.util.Locale("ru");
        request.getSession().setAttribute(Globals.LOCALE_KEY, ruLocale);

        return mapping.findForward(SUCCESS);
    }
}
