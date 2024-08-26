package com.laraib.bookstoreapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


@AutoConfigureMockMvc
@SpringBootTest
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBook() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"title\": \"New Book\", \"author\": \"John Doe\", \"price\": 29.99, \"isbn\": \"1234567890\" }"))
            .andExpect(status().isCreated());

        resultActions.andExpect(jsonPath("$.title").value("New Book"))
                     .andExpect(jsonPath("$.author").value("John Doe"));
    }
}
