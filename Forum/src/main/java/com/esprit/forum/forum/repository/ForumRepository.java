package com.esprit.forum.forum.repository;

import com.esprit.forum.forum.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum,Integer> {
}
