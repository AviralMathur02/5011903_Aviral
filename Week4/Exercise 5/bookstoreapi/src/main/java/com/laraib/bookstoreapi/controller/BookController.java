package com.laraib.bookstoreapi.controller;


import com.laraib.bookstoreapi.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 Created
    public Book createBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                
                HttpHeaders headers = new HttpHeaders();
                headers.add("X-Book-Updated", "Book with ID " + id + " was updated.");
                return new ResponseEntity<>(book, headers, HttpStatus.OK); // 200 OK with custom header
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("X-Custom-Header", "Book-Header");
                return new ResponseEntity<>(book, headers, HttpStatus.OK); // 200 OK with custom header
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }
}



