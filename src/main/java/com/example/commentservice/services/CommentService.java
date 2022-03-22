package com.example.commentservice.services;

import com.example.commentservice.model.Comment;

import java.util.List;
import java.util.Optional;


public interface CommentService {
  Comment addComment(String postId, Comment comment);
  Optional<Comment> getCommentsByPostId(String postId);
  Comment updateCommentByPostIdAndCommentId(String postId, String commentId, Comment comment);
  String deleteCommentByCommentId(String postId, String commentId);
  Comment getCommentByPostIdAndCommentId(String postId, String commentId);
  Long getCommentsCount(String postId);
}

