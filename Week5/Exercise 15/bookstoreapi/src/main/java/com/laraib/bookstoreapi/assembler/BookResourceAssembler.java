package com.laraib.bookstoreapi.assembler;

import com.laraib.bookstoreapi.controller.BookController;
import com.laraib.bookstoreapi.dto.BookDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler {

    public EntityModel<BookDTO> toModel(BookDTO bookDTO) {
        EntityModel<BookDTO> bookModel = EntityModel.of(bookDTO);
        
        // Add self link
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel();
        bookModel.add(selfLink);
        
        // Add other relevant links
        // Link otherLink = WebMvcLinkBuilder.linkTo(...).withRel("other");
        // bookModel.add(otherLink);
        
        return bookModel;
    }
}

