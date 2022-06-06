package com.api.safetech.userservice.user.domain.persistence;

import com.api.safetech.userservice.user.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> findByFirstNameAndLastNameContaining(String firstName, String lastName);

}
