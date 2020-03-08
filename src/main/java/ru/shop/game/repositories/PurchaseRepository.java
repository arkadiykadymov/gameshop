package ru.shop.game.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.game.domain.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
