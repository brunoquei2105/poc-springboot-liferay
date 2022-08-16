package com.verso.poc.model.producer.dto;

import com.verso.poc.model.consumer.response.BlogsImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogsDTO {

    private String dateCreated;
    private String description;
    private String headLine;
    private BlogsImage image;
    private String comments;
    private String subtitle;
}
