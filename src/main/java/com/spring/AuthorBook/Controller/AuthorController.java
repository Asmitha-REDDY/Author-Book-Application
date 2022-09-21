package com.spring.AuthorBook.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.AuthorBook.Entity.Author;
import com.spring.AuthorBook.Service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	public AuthorService authorservice;

	@GetMapping("/authorlist")
	public List<Author> getAuthor(@RequestBody Author author) {
		return this.authorservice.listAll();
	}

	@PostMapping("/addauthor")
	public Author addAuthor(@Valid @RequestBody Author author) {
		return this.authorservice.addAuthor(author);
	}

	@PutMapping("/updateauthor/{authorId}")
	public Author updateAuthor(@RequestBody Author a, @PathVariable int authorId) {
		return authorservice.updateAuthor(a, authorId);
	}

	@DeleteMapping("/delauthor/{authorId}")
	public String deleteAuthor(@PathVariable int authorId) {
		this.authorservice.deleteAuthor(authorId);
		boolean flag = true;
		new ResponseEntity<Boolean>(flag, HttpStatus.OK);

		return "author has been deleted";
	}

	@GetMapping("/search/{id}")
	public Author searchById(@PathVariable int id) {
		return this.authorservice.searchById(id);
	}
}
