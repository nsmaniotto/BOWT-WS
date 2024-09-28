package com.nsmaniotto.bowt.persistence.repository.user;

import com.nsmaniotto.bowt.persistence.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
