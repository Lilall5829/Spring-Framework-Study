package com.rest.webservices.restfulwebservices.jpa;

import com.rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity, Data type>
public interface PostRepository extends JpaRepository<Post, Integer> {
}
