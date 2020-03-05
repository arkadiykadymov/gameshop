package ru.shop.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.game.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
