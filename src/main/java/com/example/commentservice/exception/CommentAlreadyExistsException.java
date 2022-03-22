package com.example.commentservice.exception;

public class CommentAlreadyExistsException extends RuntimeException {
  public CommentAlreadyExistsException(String message) {
    super(message);
  }
}
