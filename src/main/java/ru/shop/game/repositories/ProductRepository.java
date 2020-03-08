package ru.shop.game.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.game.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
