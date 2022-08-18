package com.verso.poc.model.consumer.response.headless;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.verso.poc.model.consumer.response.headless.BlogPostingResponse;
import lombok.Data;

import java.util.List;

@Data
public class BlogsPostingsResponse {

    @JsonProperty("items")
    private List<BlogPostingResponse> blogs;
}
