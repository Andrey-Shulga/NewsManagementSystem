package com.epam.testapp.controller;

import com.epam.ejb.service.EjbServiceRemote;
import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

@Controller
public class SecurityController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("SecurityController");

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/news-form", method = RequestMethod.GET)
    public ModelAndView newsForm() {

        return new ModelAndView("redirect:/News.do?method=showNewsForm");
    }

    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @RequestMapping(value = "/news-list", method = RequestMethod.GET)
    public ModelAndView newsList() {

        return new ModelAndView("redirect:/News.do?method=list");
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView login() {

        return new ModelAndView("login");
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {

        return new ModelAndView("access-denied-403");
    }

    @RequestMapping(value = "/ejb", method = RequestMethod.GET)
    public ModelAndView ejbTest() throws ControllerException {

        try {
            Properties jndiProps = new Properties();
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8082");
            jndiProps.put(Context.SECURITY_PRINCIPAL, "admin");
            jndiProps.put(Context.SECURITY_CREDENTIALS, "admin");
            jndiProps.put("jboss.naming.client.ejb.context", true);
            Context ctx = new InitialContext(jndiProps);
            EjbServiceRemote<News> ejbServiceRemote = (EjbServiceRemote) ctx.lookup("EjbServer/EjbService!com.epam.ejb.service.EjbServiceRemote");
            List<News> newsList = ejbServiceRemote.getAll();
            log.debug("news list = {}", newsList);
        } catch (NamingException e) {
            throw new ControllerException(e);
        }
        return new ModelAndView("ejb");
    }
}
