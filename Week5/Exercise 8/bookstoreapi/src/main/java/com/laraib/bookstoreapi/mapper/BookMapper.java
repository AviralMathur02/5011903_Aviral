package com.laraib.bookstoreapi.mapper;

import com.laraib.bookstoreapi.dto.BookDTO;
import com.laraib.bookstoreapi.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}

