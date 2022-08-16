package com.verso.poc.api.controller.interfaces;

import com.verso.poc.model.producer.dto.BlogsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Validated
@Tag(name = "Blogs API")
public interface BlogsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @GetMapping(value = "/blog/{blogId}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "Return a BlogDTO.", responseCode = "200")
    }, summary = "", tags = {})
     default ResponseEntity<BlogsDTO> getBlogsById(@PathVariable String blogId){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
