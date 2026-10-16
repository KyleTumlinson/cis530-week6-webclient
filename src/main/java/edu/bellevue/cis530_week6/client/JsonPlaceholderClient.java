/*
    Modified citation goes here
 */
package edu.bellevue.cis530_week6.client;

import edu.bellevue.cis530_week6.dto.PostDto;
import edu.bellevue.cis530_week6.exception.ApiClientException;
import edu.bellevue.cis530_week6.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;

@Component
public class JsonPlaceholderClient {
    private final WebClient webClient;

    public JsonPlaceholderClient(WebClient webClient) {this.webClient = webClient;}

    public List<PostDto> getAllPosts(){
        List<PostDto> posts = webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();

        return posts != null ? posts : Collections.emptyList();
    }

    public PostDto getPostById(Long id){
        try{
                return webClient.get()
                    .uri("/posts/{id}", id)
                    .retrieve()
                    .bodyToMono(PostDto.class)
                    .block();
        }
        catch(WebClientResponseException.NotFound ex){
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        catch(WebClientResponseException ex) {
            throw new ApiClientException("External API failed with status: " + ex.getStatusCode());
        }
    }

    public List<PostDto> getPostsByUserId(Long userId){
        // use queryParam to send userId as a query parameter
        List<PostDto> posts = webClient.get()
                .uri("/posts?userId={userId}", userId)
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();
        return posts != null ? posts : Collections.emptyList();
    }
}
