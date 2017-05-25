package com.epam.ejb.service;

import com.epam.ejb.model.News;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface EjbWebService {

    List<News> getAll();
}
