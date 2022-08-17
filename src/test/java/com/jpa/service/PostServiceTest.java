package com.jpa.service;

import com.jpa.entity.Comment;
import com.jpa.entity.Post;
import com.jpa.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostServiceTest {
    PostService postService = new PostService();
    CommentService commentService = new CommentService();

    @Test
    public void postCreateSuccess(){
        Post post = new Post();

        User user = new User();
        user.setId(1);
        post.setUser(user);
        post.setTitle("제목1");
        post.setBody("body1");

        Post result = postService.createPost(post);
        assertEquals(Post.class,result.getClass());
        assertEquals(post.getTitle(),result.getTitle());
    }

    @Test
    public void postCreateWithCommentsSuccess(){
        Post post = new Post();

        User user = new User();
        user.setId(1);
        post.setUser(user);
        post.setTitle("제목2");
        post.setBody("body2");
        postService.createPost(post);

        Comment comment = new Comment();
        comment.setBody("양방향 댓글 test1");
        post.addComments(comment);

        commentService.createComment(comment);
    }

}