package com.esprit.forum.forum.services;

import com.esprit.forum.forum.entity.Forum;
import com.esprit.forum.forum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {
    @Autowired
    private ForumRepository forumRepository;

    public List<Forum> getAll(){
        return forumRepository.findAll();
    }
    public Forum addForum(Forum forum) {
        return forumRepository.save(forum);
    }

    public Forum updateForum(int idForum, Forum newForum) {
        if (forumRepository.findById(idForum).isPresent()) {
            Forum existingForum = forumRepository.findById(idForum).get();
            existingForum.setTitre(newForum.getTitre());
            existingForum.setDescription(newForum.getDescription());
            return forumRepository.save(existingForum);
        } else
            return null;
    }

    public String deleteForum(int idForum) {
        if (forumRepository.findById(idForum).isPresent()) {
            forumRepository.deleteById(idForum);
            return "forum supprimé";
        } else
            return "forum non supprimé";
    }
}
