package com.example.commentservice.services;

import com.example.commentservice.exception.CommentAlreadyExistsException;
import com.example.commentservice.exception.CommentNotFoundException;
import com.example.commentservice.model.Comment;
import com.example.commentservice.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.commentservice.constants.Constants.COMMENT_ALREADY_EXISTS;
import static com.example.commentservice.constants.Constants.COMMENT_NOT_FOUND;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  private CommentRepo commentRepo;
  @Override
  public Comment addComment(String postId,Comment comment) {
    Comment commentData = commentRepo.findByPostIdAndCommentId(postId, comment.getId());
    if (commentData != null)
      throw new CommentAlreadyExistsException(COMMENT_ALREADY_EXISTS);
    return commentRepo.save(comment);
  }


  @Override
  public Optional<Comment> getCommentsByPostId(String postId) {
    Optional<Comment> commentData = commentRepo.findByPostId(postId);
    if (!commentData.isPresent())
      throw new CommentNotFoundException(COMMENT_NOT_FOUND + postId);
    return commentData;
  }
  @Override
  public Comment updateCommentByPostIdAndCommentId(String commentId, String postsId, Comment comment) {
    Optional<Comment> commentInfo = Optional.ofNullable(commentRepo.findByPostIdAndCommentId(postsId, commentId));
    if (commentInfo.isPresent()) {
      Comment commentDetails = commentInfo.get();
      commentDetails.setComment(commentDetails.getComment());
      commentDetails.setCreatedAt(commentDetails.getCreatedAt());
      commentDetails.setCommentedBy(commentDetails.getCommentedBy());
      commentDetails.setUpdatedAt(commentDetails.getUpdatedAt());
      return commentDetails;
    } else {
      throw new CommentNotFoundException(COMMENT_NOT_FOUND);
    }
  }
  @Override
  public String deleteCommentByCommentId( String postId, String commentId) {
    commentRepo.deleteCommentByPostId(postId, commentId);
    return "Comment deleted";
  }
  @Override
  public Comment getCommentByPostIdAndCommentId(String commentId, String postsId) {
    return commentRepo.findByPostIdAndCommentId(commentId, postsId);
  }

  @Override
  public Long getCommentsCount(String postId) {
    Long count=commentRepo.countByPostId(postId);
    return count;
  }
}
