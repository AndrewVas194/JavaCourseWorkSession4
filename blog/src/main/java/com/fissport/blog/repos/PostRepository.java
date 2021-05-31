package com.fissport.blog.repos;

import com.fissport.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, Long> {

   public List<Post> findByNameContainingIgnoreCase(String name);


}
