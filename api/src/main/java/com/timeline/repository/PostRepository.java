package com.timeline.repository;

import com.timeline.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Iterable<Post> findByUserId(Long userId);
}
