package com.verso.poc.model.producer.headless;

import com.verso.poc.model.consumer.response.headless.BlogPostingResponse;
import lombok.Data;

import java.util.List;
@Data
public class BlogsDTO {

    private List<BlogDTO> blogs;
}
