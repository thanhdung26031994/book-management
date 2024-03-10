package com.example.bookmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private Set<CodeBook> codeBookSet;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<CodeBook> getCodeBookSet() {
        return codeBookSet;
    }

    public void setCodeBookSet(Set<CodeBook> codeBookSet) {
        this.codeBookSet = codeBookSet;
    }

    public User(Long id, String phoneNumber, Set<CodeBook> codeBookSet) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.codeBookSet = codeBookSet;
    }
}