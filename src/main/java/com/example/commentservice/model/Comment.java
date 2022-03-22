package com.example.commentservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {
  @Id
  private String id;
  @NotBlank()
  private String commentedBy;
  @Size(min=10, message = "comments should have at least 10 characters ")
  private String comment;
  private Date createdAt;
  private Date updatedAt;
}
