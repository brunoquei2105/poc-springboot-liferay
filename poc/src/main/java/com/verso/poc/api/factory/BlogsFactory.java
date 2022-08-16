package com.verso.poc.api.factory;

import com.verso.poc.model.consumer.response.BlogPostingResponse;
import com.verso.poc.model.producer.dto.BlogsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogsFactory {

    public BlogsDTO setBlogDto(BlogPostingResponse response){
        var dto = new BlogsDTO();
        BeanUtils.copyProperties(response, dto);
        return dto;
    }
}
