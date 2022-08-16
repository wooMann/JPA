package com.jpa.service;

import com.jpa.DAO.CommentDAO;
import com.jpa.entity.Comment;

public class CommentService {
    CommentDAO commentDAO = new CommentDAO();

    public Comment createComment(Comment comment){

        return commentDAO.create(comment);
    }
}
