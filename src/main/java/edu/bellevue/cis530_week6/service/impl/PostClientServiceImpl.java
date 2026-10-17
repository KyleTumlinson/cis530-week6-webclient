/*
    Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University. Modified by A. Student 2021
 */
package edu.bellevue.cis530_week6.service.impl;

import edu.bellevue.cis530_week6.client.JsonPlaceholderClient;
import edu.bellevue.cis530_week6.dto.PostDto;
import edu.bellevue.cis530_week6.service.PostClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostClientServiceImpl implements PostClientService {
    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostClientServiceImpl(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }


    /*
        Function for service layer that calls the Client.getAllPosts function
        @return the list of PostDtos derived from the json servers Get response
     */
    @Override
    public List<PostDto> getAllPosts() {
        return jsonPlaceholderClient.getAllPosts();
    }

    /*
        Function for service layer that calls the Client.getPostById function
        @param id Long
        @return a PostDto derived from the json servers Get response
     */
    @Override
    public PostDto getPostById(Long id) {
        return jsonPlaceholderClient.getPostById(id);
    }

    /*
        Function for service layer that calls the Client.getPostsByUserId function
        @param userId Long
        @return the list of PostDtos derived from the json servers Get response
     */
    @Override
    public List<PostDto> getPostsByUserId(Long userId) {
        return jsonPlaceholderClient.getPostsByUserId(userId);
    }
}
