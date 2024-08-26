package com.laraib.bookstoreapi.controller;

import com.laraib.bookstoreapi.dto.BookDTO;
import com.laraib.bookstoreapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetBookById() throws Exception {
        // Arrange: Setup mock behavior
        when(bookService.getBookById(1L)).thenReturn(Optional.of(new BookDTO(1L, "Test Book", "Test Author", 9.99, "1234567890")));

        // Act & Assert: Perform the GET request and validate the response
        mockMvc.perform(get("/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Test Author"));
    }

    @Test
    public void testCreateBook() throws Exception {
    // Arrange: Setup the mock behavior
    BookDTO bookDTO = new BookDTO(null, "New Book", "New Author", 19.99, "0987654321");
    when(bookService.createBook(bookDTO)).thenReturn(new BookDTO(2L, "New Book", "New Author", 19.99, "0987654321"));

    // Act & Assert: Perform the POST request and validate the response
    mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\": \"New Book\", \"author\": \"New Author\", \"price\": 19.99, \"isbn\": \"0987654321\"}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(2L))
            .andExpect(jsonPath("$.title").value("New Book"))
            .andExpect(jsonPath("$.author").value("New Author"));
    }
}

