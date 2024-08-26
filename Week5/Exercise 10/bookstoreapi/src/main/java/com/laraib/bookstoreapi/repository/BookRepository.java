package com.mansoor.bookstoreapi.repository;

import com.mansoor.bookstoreapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

