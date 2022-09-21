package com.spring.AuthorBook.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.AuthorBook.Entity.Author;


public interface AuthorRepository extends JpaRepository<Author,Integer> {

}

