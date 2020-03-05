package ru.shop.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.game.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
