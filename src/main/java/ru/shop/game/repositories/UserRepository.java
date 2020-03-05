package ru.shop.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.game.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
