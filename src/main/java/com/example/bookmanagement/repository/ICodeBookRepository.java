package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook, Long> {
}
