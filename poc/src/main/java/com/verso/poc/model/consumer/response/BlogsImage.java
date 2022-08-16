package com.verso.poc.model.consumer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlogsImage {

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("contentUrl")
    private String contentUrl;

    @JsonProperty("imageId")
    private String imageId;
}
