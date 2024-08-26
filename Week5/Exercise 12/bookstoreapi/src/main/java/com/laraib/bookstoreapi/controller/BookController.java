package com.laraib.bookstoreapi.controller;

import com.laraib.bookstoreapi.assembler.BookResourceAssembler;
import com.laraib.bookstoreapi.dto.BookDTO;
import com.laraib.bookstoreapi.model.Book;
import com.laraib.bookstoreapi.service.BookService;
//import model.com.laraib.bookstoreapi.Book;
//import org.springframework.hateoas.EntityModel;
//import exception.com.laraib.bookstoreapi.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    public BookController(BookService bookService, BookResourceAssembler bookResourceAssembler) {
        this.bookService = bookService;
    }

    /*@GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Optional<BookDTO> bookDTO = bookService.getBookById(id);
        return bookDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }  

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    } */

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        // Your service logic here
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        // Your service logic here
        BookDTO createdBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO updatedBookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, updatedBookDTO);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

   /*  @GetMapping("/books/{id}")
    public EntityModel<BookDTO> getBookById(@PathVariable Long id) {
    Book book = bookService.findById(id);
    if (book == null) {
        throw new ResourceNotFoundException("Book not found with id " + id);
    }
    return null;  */

    // Convert Book entity to BookDTO and add HATEOAS links using the assembler
    //BookDTO bookDTO = bookMapper.toDTO(book);
    //return bookResourceAssembler.toModel(bookDTO);
}



