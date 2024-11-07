package com.abhinav.prod_ready_features.prod_ready_features.services;

import com.abhinav.prod_ready_features.prod_ready_features.dto.PostDTO;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
