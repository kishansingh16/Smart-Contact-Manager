package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email); // ✅ Find user by email

    Optional<User> findByEmailAndPassword(String email, String password);
}
