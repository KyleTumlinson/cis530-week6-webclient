/*
    Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University. Modified by A. Student 2021
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

    /*
        Method to get all posts from our json server
        No params
        returns the list of PostDtos
     */
    public List<PostDto> getAllPosts(){
        List<PostDto> posts = webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();

        return posts != null ? posts : Collections.emptyList();
    }

    /*
        Method that gets a specific post by id from json server
        @param id Long
        @return the PostDto converted from the Post retrieved from the json server
     */
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

    /*
        Method that gets all posts made by a specific user by ID
        @param userId Long
        @return the list of PostDtos converted from the Post retrieved from the json server
     */
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
