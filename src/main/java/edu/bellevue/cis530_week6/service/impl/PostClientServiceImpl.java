/*
    Citation for directed coding here
 */
package edu.bellevue.cis530_week6.service.impl;

import edu.bellevue.cis530_week6.client.JsonPlaceholderClient;
import edu.bellevue.cis530_week6.dto.PostDto;
import edu.bellevue.cis530_week6.service.PostClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PostClientServiceImpl implements PostClientService {
    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostClientServiceImpl(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }


    @Override
    public List<PostDto> getAllPosts() {
        return jsonPlaceholderClient.getAllPosts();
    }

    @Override
    public PostDto getPostById(Long id) {
        Logger.getLogger(PostClientServiceImpl.class.getName()).log(Level.INFO,
                "getPostById: " + id);
        return jsonPlaceholderClient.getPostById(id);
    }

    @Override
    public List<PostDto> getPostsByUserId(Long userId) {
        return jsonPlaceholderClient.getPostsByUserId(userId);
    }
}
