package ru.shop.game.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.game.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}