/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 */

package edu.bellevue.cis530_week6.service;

import edu.bellevue.cis530_week6.dto.PostDto;

import java.util.List;

public interface PostClientService {
    List<PostDto> getAllPosts();
    PostDto getPostById(Long id);
    List<PostDto> getPostsByUserId(Long userId);
}
