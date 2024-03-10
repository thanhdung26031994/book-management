package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.CodeBook;
import com.example.bookmanagement.model.User;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);

    void save(CodeBook codeBook);

    void saveBook(Book book);

    List<CodeBook> findAllCodeBook();

    void saveUser(User user);

}
