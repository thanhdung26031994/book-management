package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.CodeBook;
import com.example.bookmanagement.model.User;
import com.example.bookmanagement.repository.IBookRepository;
import com.example.bookmanagement.repository.ICodeBookRepository;
import com.example.bookmanagement.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private ICodeBookRepository codeBookRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<CodeBook> findAllCodeBook() {
        return codeBookRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
