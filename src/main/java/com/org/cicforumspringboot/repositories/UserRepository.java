package com.org.cicforumspringboot.repositories;

import com.org.cicforumspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
