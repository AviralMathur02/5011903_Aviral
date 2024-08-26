package com.mansoor.bookstoreapi.mapper;

import com.mansoor.bookstoreapi.dto.BookDTO;
import com.mansoor.bookstoreapi.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}

