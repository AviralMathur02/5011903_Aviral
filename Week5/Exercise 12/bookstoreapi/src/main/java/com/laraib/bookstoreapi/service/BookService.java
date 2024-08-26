package com.laraib.bookstoreapi.service;

import com.laraib.bookstoreapi.model.Book;
import com.laraib.bookstoreapi.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookById(Long id);

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(Long id, BookDTO updatedBookDTO);

    boolean deleteBook(Long id);

    Book findById(Long id);
}

