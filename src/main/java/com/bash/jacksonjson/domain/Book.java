package com.bash.jacksonjson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// We can configure all lot of other things inside
// of Jackson and ObjectMapper.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private String isbn;
    private String title;
    private String author;
    // Anytime we take Java Object to JSON object, yearPublished will be 'year'.
    @JsonProperty("year")
    private String yearPublished;

}
