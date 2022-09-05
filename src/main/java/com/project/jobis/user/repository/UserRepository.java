package com.project.jobis.user.repository;

import com.project.jobis.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);

    Optional<User> findByUserNo(String email);

}