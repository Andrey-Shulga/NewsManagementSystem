package com.epam.testapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

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

}
