package com.starlight.restclientservice.service;

import java.util.List;

public interface CommonService<T, K> {

    T create(K k);

    List<T> getAll();

    T update(K k);

    void deleteById(String id);
}
