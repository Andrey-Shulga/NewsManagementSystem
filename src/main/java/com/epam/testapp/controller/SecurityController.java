package com.epam.testapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {


    @RequestMapping(value = "/sec/1", method = RequestMethod.GET)
    public ModelAndView form() {

        return new ModelAndView("/sec/admin");
    }


}
