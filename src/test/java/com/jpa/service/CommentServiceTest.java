package com.jpa.service;

import com.jpa.entity.Comment;
import com.jpa.entity.Post;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentServiceTest {
    CommentService commentService = new CommentService();

    @Test
    public void createCommentSuccess(){
        Comment comment = new Comment();

        Post post = new Post();
        post.setId(1);
        comment.setBody("123");
        comment.setPost(post);
        Comment result =  commentService.createComment(comment);

        assertEquals(comment.getBody(),result.getBody());
    }

    @Test
    public void createCommentFail(){
        Comment comment = new Comment();

        Post post = new Post();
        post.setId(0);
        comment.setBody("NO");
        comment.setPost(post);
        Comment result = commentService.createComment(comment);
        assertFalse(result.getClass() == Comment.class);
    }

}