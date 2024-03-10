package com.example.bookmanagement.service;

import java.util.List;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T t);

    void saveBook(T t);

    List<T> findAllCodeBook();

    void saveUser(T t);
}
