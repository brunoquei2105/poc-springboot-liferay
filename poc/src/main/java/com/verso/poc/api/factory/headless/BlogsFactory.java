package com.verso.poc.api.factory.headless;

import com.verso.poc.model.consumer.response.headless.BlogPostingResponse;
import com.verso.poc.model.consumer.response.headless.BlogsPostingsResponse;
import com.verso.poc.model.producer.headless.BlogDTO;
import com.verso.poc.model.producer.headless.BlogsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogsFactory {

    public BlogDTO setBlogDto(BlogPostingResponse response){
        var dto = new BlogDTO();
        BeanUtils.copyProperties(response, dto);
        return dto;
    }

    public BlogsDTO setBlogsPostingsDTO(BlogsPostingsResponse response){
        var blogsDTO = new BlogsDTO();
        List<BlogPostingResponse> blogResponse = response.getBlogs();
        List<BlogDTO> blog = new ArrayList<>();

        for (BlogPostingResponse posting : blogResponse){
            blog.add(setBlogDto(posting));
        }
        blogsDTO.setBlogs(blog);
        return blogsDTO;

    }
}
