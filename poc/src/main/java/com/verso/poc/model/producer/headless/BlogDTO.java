package com.verso.poc.model.producer.headless;

import com.verso.poc.model.consumer.response.headless.BlogsImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {

    private String dateCreated;
    private String description;
    private String headLine;
    private BlogsImage image;
    private String comments;
    private String subtitle;
    private List<String> renderedContents;
    private String siteId;
}
