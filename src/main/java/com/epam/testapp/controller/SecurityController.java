package com.epam.testapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";
    private static final String ANONYMOUS_ROLE = "ANONYMOUS";

    @PreAuthorize("hasRole('" + ADMIN_ROLE + "')")
    @RequestMapping(value = "/news-form", method = RequestMethod.GET)
    public ModelAndView newsForm() {

        return new ModelAndView("add-form");
    }

    @PreAuthorize("hasRole('" + ADMIN_ROLE + "') || hasRole('" + USER_ROLE + "')")
    @RequestMapping(value = "/news-list", method = RequestMethod.GET)
    public ModelAndView newsList() {

        return new ModelAndView("redirect:/News.do?method=list");
    }

    @PreAuthorize("hasRole('" + ANONYMOUS_ROLE + "')")
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView login() {

        return new ModelAndView("login");
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {

        return new ModelAndView("access-denied-403");
    }

}
