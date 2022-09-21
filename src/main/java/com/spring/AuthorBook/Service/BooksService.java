package com.spring.AuthorBook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.AuthorBook.Entity.Books;
import com.spring.AuthorBook.Repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	private BooksRepository booksRepository;
	
	public List<Books> getAllVBooks()
	{
		return booksRepository.findAll();
	}
	
	public Books addBooks(Books books)
	{
		return booksRepository.save(books);
	}
	
	public void deleteBooks(int bookId)
	{
			booksRepository.deleteById(bookId);			
		}
	
	public Books updateBook(Books books,int bookId)
	{
		return booksRepository.save(books);
	}
	
	public Books searchById(int bookId)
	{
		return  booksRepository.findById(bookId).get();
	}
		
	}
	
	

