package com.example.commentservice.Feign;


import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackFactory implements FallbackFactory<CommentFeignClient> {
  @Override
  public CommentFeignClient create(Throwable cause) {
//        return id -> {
//            // dummyMethod();
//            System.out.println("fallback; reason was: " + cause.getMessage());
//            return null;
//        };
    return null;
  }
}
