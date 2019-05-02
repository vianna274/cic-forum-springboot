package com.org.cicforumspringboot.repositories;

import com.org.cicforumspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByFacebookUid(String facebookUid);
}
