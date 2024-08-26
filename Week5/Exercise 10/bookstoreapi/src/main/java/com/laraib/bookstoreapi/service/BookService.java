package com.mansoor.bookstoreapi.service;

import com.mansoor.bookstoreapi.dto.BookDTO;
import com.mansoor.bookstoreapi.model.Book;

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

