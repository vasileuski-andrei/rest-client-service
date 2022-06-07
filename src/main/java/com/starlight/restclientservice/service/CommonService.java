package com.starlight.restclientservice.service;

import java.util.List;

public interface CommonService<T, V> {

    List<T> getAll();

    T create(T model);

    void delete(V id);

    T update(V id, T t);
}
