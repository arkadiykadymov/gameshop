package ru.shop.game.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shop.game.domain.Product;
import ru.shop.game.repositories.ProductRepository;

import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    @Autowired
    private final ProductRepository productRepository;

    public GameController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/getProductList")
    public String productList(Map<String, Object> model) {
        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);
        return "main";
    }
}
