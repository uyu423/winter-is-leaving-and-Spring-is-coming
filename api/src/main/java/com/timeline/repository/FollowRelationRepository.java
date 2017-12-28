package com.timeline.repository;

import com.timeline.domain.FollowRelation;
import com.timeline.domain.Post;
import com.timeline.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FollowRelationRepository extends CrudRepository<FollowRelation, Long> {
    FollowRelation findByUserAndFollowUser(User user, User followUser);

    Collection<FollowRelation> findByUser(User user);
}
