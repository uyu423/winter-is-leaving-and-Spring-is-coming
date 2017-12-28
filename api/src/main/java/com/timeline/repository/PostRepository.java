package com.timeline.repository;

import com.timeline.domain.Post;
import com.timeline.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.stream.Stream;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("select p from Post p, FollowRelation f where f.user = :user and p.user = f.followUser order by p.createdAt desc")
    Collection<Post> findPostsByFollowInfo(@Param("user") User user);

    Collection<Post> findByUserOrderByCreatedAtDesc(User user);
}

