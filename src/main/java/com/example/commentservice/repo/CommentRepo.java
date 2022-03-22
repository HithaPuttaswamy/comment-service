package com.example.commentservice.repo;

import com.example.commentservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CommentRepo extends MongoRepository<Comment,Integer> {
  Optional<Comment> findByPostId(String postId);
  Comment findByPostIdAndCommentId(String postId, String commentId);
  void deleteCommentByPostId(String postId, String commentId);
  Long countByPostId(String postId);
}
