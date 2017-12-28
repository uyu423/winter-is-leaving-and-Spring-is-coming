package com.timeline.repository;

import com.timeline.domain.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.stream.Stream;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("select p from Post p, FollowRelation f where f.user.id = :userId and p.user = f.followUser order by p.createdAt desc")
    Collection<Post> findPostsByFollowInfo(@Param("userId") Long userId);
}

