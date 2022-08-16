package com.jpa.service;

import com.jpa.DAO.PostDAO;
import com.jpa.entity.Post;

public class PostService {
    PostDAO postDAO = new PostDAO();

    public Post createPost(Post post){
        return postDAO.create(post);
    }
}
