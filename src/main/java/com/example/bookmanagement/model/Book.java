package com.example.bookmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<CodeBook> codeBookSet;

    public Set<CodeBook> getCodeBookSet() {
        return codeBookSet;
    }

    public void setCodeBookSet(Set<CodeBook> codeBookSet) {
        this.codeBookSet = codeBookSet;
    }

    public Book(Long id, String title, int quantity) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
    }

    public Book(Long id, String title, int quantity, Set<CodeBook> codeBookSet) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.codeBookSet = codeBookSet;
    }

    public Book() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
