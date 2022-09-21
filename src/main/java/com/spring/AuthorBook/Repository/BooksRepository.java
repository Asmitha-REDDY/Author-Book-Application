package com.spring.AuthorBook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.AuthorBook.Entity.Books;

public interface BooksRepository extends JpaRepository<Books,Integer> {


}