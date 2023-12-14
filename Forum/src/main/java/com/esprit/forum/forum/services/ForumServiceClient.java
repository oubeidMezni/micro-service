package com.esprit.forum.forum.services;

import com.esprit.forum.forum.entity.Forum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "forum-service") // The name of the microservice to communicate with
public interface ForumServiceClient {
    @GetMapping("/api/events") // Define the endpoint and method
    List<Forum> getListForumid() ; // Define the method signature
}
