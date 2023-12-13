package com.esprit.forum.forum.controller;
import com.esprit.forum.forum.entity.Forum;
import com.esprit.forum.forum.services.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumRestController {
    @Autowired
    private ForumService forumService;

    @RequestMapping
    public List<Forum> getListForumid() {
        return forumService.getAll();
    }

    @PostMapping(value = "/ajouterForum" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    //@PostMapping("/ajouterForum")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.addForum(forum), HttpStatus.OK);
    }


    @PutMapping(value = "/{idForum}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Forum> updateForum(@PathVariable(value = "idForum") int idForum,
                                                   @RequestBody Forum forum){
        return new ResponseEntity<>(forumService.updateForum(idForum, forum), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{idForum}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteForum(@PathVariable(value = "idForum") int idForum){
        return new ResponseEntity<>(forumService.deleteForum(idForum), HttpStatus.OK);
    }

}
