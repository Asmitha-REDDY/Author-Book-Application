package com.spring.AuthorBook.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.AuthorBook.Entity.Author;
import com.spring.AuthorBook.Entity.Books;
import com.spring.AuthorBook.Service.AuthorService;
import com.spring.AuthorBook.Service.BooksService;

@RestController
public class BooksController {
	@Autowired
	private BooksService booksService;
	@Autowired
	private AuthorService authorService;

	@GetMapping("/bookslist")
	public List<Books> getBooks() {
		return this.booksService.getAllVBooks();
	}

	@PostMapping("/addbooks")
	public String addBooks(@Valid @RequestBody Books books, @RequestParam("authorid") int authorId) {
		Author a = this.authorService.searchById(authorId);
		books.setAuthor(a);

		this.booksService.addBooks(books);
		return "book added has been successfully";

	}

	@PostMapping("/addbooks1/{authorId}")
	public String addBook1(@Valid @RequestBody Books books, @PathVariable int authorId) {
		Author a1 = this.authorService.searchById(authorId);
		books.setAuthor(a1);

		this.booksService.addBooks(books);
		return "Book added has been successfully";

	}

	@DeleteMapping("/delbooks/{bookId}")
	public String deleteBooks(@PathVariable int bookId) {
		this.booksService.deleteBooks(bookId);
		/*
		 * boolean flag = true; new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		 */

		return "book has been deleted";
	}

	@PutMapping("/updatebook")
	public Books updateBook(@Valid @RequestBody Books b, @PathVariable int bookId) {
		return booksService.updateBook(b, bookId);
	}

	@GetMapping("/search/{bookId}")
	public Books searchById(@PathVariable int bookId) {
		return this.booksService.searchById(bookId);
	}
}
