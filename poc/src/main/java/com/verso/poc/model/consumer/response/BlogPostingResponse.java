package com.verso.poc.model.consumer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BlogPostingResponse {

    @JsonProperty("dateCreated")
    private String dateCreated;

    @JsonProperty("description")
    private String description;

    @JsonProperty("headline")
    private String headLine;

    @JsonProperty("image")
    private BlogsImage image;

    @JsonProperty("numberOfComments")
    private String comments;

    @JsonProperty("alternativeHeadline")
    private String subtitle;
}
