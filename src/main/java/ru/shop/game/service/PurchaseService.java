package ru.shop.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shop.game.domain.Product;
import ru.shop.game.domain.Purchase;
import ru.shop.game.domain.User;
import ru.shop.game.repositories.ProductRepository;
import ru.shop.game.repositories.PurchaseRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(ProductRepository productRepository, PurchaseRepository purchaseRepository) {
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public Product createPurchase(Product product, User user, int count) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Purchase purchase = new Purchase();
        purchase.setBuyer(user);
        purchase.setProducts_count(count);
        purchase.setPurchase_date(dateFormat.format(date));
        purchase.setProduct(product);
        purchase.setPurchase_price(product.getPrice() * count);
        product.setStorage_count(product.getStorage_count() - count);
        purchaseRepository.save(purchase);
        return productRepository.save(product);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
}
