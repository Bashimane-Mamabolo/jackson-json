package com.bash.jacksonjson;

import com.bash.jacksonjson.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
// Unit test
import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTests {
    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        // Arrange
        // Initialize mock classes and objects we need for our methods
        final ObjectMapper objectMapper = new ObjectMapper();
        Book book = Book.builder()
                        .isbn("123456789")
                        .title("Title")
                        .author("Author")
                        .yearPublished("1995").build();
        // Act
        String result = objectMapper.writeValueAsString(book);
        // Assert or verify
        assertThat(result).isEqualTo("{"
                + "\"isbn\":\"123456789\","
                + "\"title\":\"Title\","
                + "\"author\":\"Author\","
                + "\"year\":\"1995\""
                + "}");

    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJson() throws JsonProcessingException {
        // Arrange
        final ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = "{"
                + "\"isbn\":\"123456789\","
                + "\"title\":\"Title\","
                + "\"author\":\"Author\","
                + "\"year\":\"1995\""
                + "}";
        // Act
        Book book = objectMapper.readValue(jsonObject, Book.class);
        // Assert or verify
        assertThat(book).isEqualTo(Book.builder()
                .isbn("123456789")
                .title("Title")
                .author("Author")
                .yearPublished("1995").build());
    }
}
