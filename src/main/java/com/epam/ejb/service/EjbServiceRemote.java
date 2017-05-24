package com.epam.ejb.service;

import com.epam.testapp.model.BaseEntity;

import java.util.List;

public interface EjbServiceRemote<T extends BaseEntity> {

    List<T> getAll();
}
