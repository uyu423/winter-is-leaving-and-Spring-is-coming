package com.timeline.repository;

import org.springframework.data.repository.CrudRepository;
import com.timeline.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
