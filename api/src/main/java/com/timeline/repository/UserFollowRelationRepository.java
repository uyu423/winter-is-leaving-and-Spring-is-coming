package com.timeline.repository;

import com.timeline.domain.UserFollowRelation;
import org.springframework.data.repository.CrudRepository;

public interface UserFollowRelationRepository extends CrudRepository<UserFollowRelation, Long> {
    Iterable<UserFollowRelation> findByUserId(Long userId);

    Iterable<UserFollowRelation> findByFollowUserId(Long FollowUserId);
}
