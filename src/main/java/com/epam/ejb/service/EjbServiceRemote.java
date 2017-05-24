package com.epam.ejb.service;

import java.util.List;

public interface EjbServiceRemote<T extends com.epam.ejb.model.BaseEntity> {

    List<T> getAll();
}
