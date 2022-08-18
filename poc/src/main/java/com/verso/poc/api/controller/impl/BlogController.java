package com.verso.poc.api.controller.impl;

import com.verso.poc.api.controller.interfaces.BlogsApi;
import com.verso.poc.api.facade.headless.BlogsFacade;
import com.verso.poc.api.factory.headless.BlogsFactory;
import com.verso.poc.model.consumer.response.headless.BlogPostingResponse;
import com.verso.poc.model.consumer.response.headless.BlogsPostingsResponse;
import com.verso.poc.model.producer.headless.BlogDTO;
import com.verso.poc.model.producer.headless.BlogsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/v1/api")
@Slf4j
public class BlogController implements BlogsApi {

    private final BlogsFacade facade;
    private final BlogsFactory factory;

    public BlogController(BlogsFacade facade, BlogsFactory factory){
        this.facade = facade;
        this.factory = factory;
    }
    @Override
    public ResponseEntity<BlogDTO> getBlogsById(String blogId){
        var dto = new BlogDTO();
       BlogPostingResponse response = facade.getBlogById(blogId);
       if (Objects.nonNull(response)){
           return new ResponseEntity<>(factory.setBlogDto(response), HttpStatus.OK);
       }
       log.info("Blog Posting Not Found.");
       return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
   }
   @Override
   public ResponseEntity<BlogsDTO> getAllBlogsFromSite(String siteId){
        var dtos = new BlogsDTO();
        BlogsPostingsResponse response = facade.getBlogFromSite(siteId);

        if (Objects.nonNull(response) && Objects.nonNull(response.getBlogs()) && response.getBlogs().size() > 0){
            return new ResponseEntity<>(factory.setBlogsPostingsDTO(response),HttpStatus.OK);
        }
        log.info("Blog Posting Not Found.");
        return new ResponseEntity<>(dtos, HttpStatus.NOT_FOUND);

   }
}
