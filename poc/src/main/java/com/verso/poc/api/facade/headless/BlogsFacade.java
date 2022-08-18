package com.verso.poc.api.facade.headless;

import com.verso.poc.api.facade.LiferayAuthFacade;
import com.verso.poc.model.consumer.response.headless.BlogPostingResponse;
import com.verso.poc.model.consumer.response.headless.BlogsPostingsResponse;
import com.verso.poc.model.consumer.response.objects.LiferayAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BlogsFacade {

    @Value("${base.url.liferay.object}")
    private String baseUrl;

    @Value("${uri.headless.blogs.get}")
    private String blogURI;

    @Value("${uri.headless.site.blogs}")
    private String blogsFromSiteURI;

    @Autowired
    private LiferayAuthFacade authFacade;

    public BlogPostingResponse getBlogById(String blogId){
        WebClient webClient = WebClient.create(baseUrl);

        LiferayAuthResponse auth = authFacade.getAuth();

        return webClient.get().uri(uriBuilder -> uriBuilder.path(blogURI).build(blogId))
                .header(HttpHeaders.AUTHORIZATION, auth.getTokenType() + " " + auth.getAccessToken())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BlogPostingResponse.class)
                .block();
    }

    public BlogsPostingsResponse getBlogFromSite(String siteId){
        WebClient webClient = WebClient.create(baseUrl);

        LiferayAuthResponse auth = authFacade.getAuth();

        return webClient.get().uri(uriBuilder -> uriBuilder.path(blogsFromSiteURI).build(siteId))
                .header(HttpHeaders.AUTHORIZATION, auth.getTokenType() + " " + auth.getTokenType())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BlogsPostingsResponse.class)
                .block();
    }
}
