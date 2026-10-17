/*
    Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University. Modified by A. Student 2021
 */

package edu.bellevue.cis530_week6.controller;

import edu.bellevue.cis530_week6.dto.PostDto;
import edu.bellevue.cis530_week6.service.PostClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/posts")
public class PostClientController {
    private final PostClientService postClientService;

    public PostClientController(PostClientService postClientService){
        this.postClientService = postClientService;
    }

    /*
        GetMapping to get all posts
        @return response entity with a 200 ok Http status and body containing all posts
     */
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(postClientService.getAllPosts());
    }

    /*
        GetMapping to get specific post by post ID
        @param id Long
        @return response entity with a 200 ok Http status and body containing the post details
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postClientService.getPostById(id));
    }

    /*
        GetMapping to get all posts made by user with userId
        @param userId Long
        @return response entity with a 200 ok Http status and body containing the post details
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(postClientService.getPostsByUserId(userId));
    }
}
