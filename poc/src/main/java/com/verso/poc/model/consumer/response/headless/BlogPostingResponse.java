package com.verso.poc.model.consumer.response.headless;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


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

    @JsonProperty("renderedContents")
    private List<String> renderedContents;

    @JsonProperty("siteId")
    private String siteId;

}
