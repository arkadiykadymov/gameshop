package ru.shop.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.shop.game.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
