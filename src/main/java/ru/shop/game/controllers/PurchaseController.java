package ru.shop.game.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shop.game.domain.Product;
import ru.shop.game.domain.Purchase;
import ru.shop.game.domain.User;
import ru.shop.game.repositories.ProductRepository;
import ru.shop.game.service.PurchaseService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class PurchaseController {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final PurchaseService purchaseService;

    public PurchaseController(ProductRepository productRepository, PurchaseService purchaseService) {
        this.productRepository = productRepository;
        this.purchaseService = purchaseService;
    }

    private static final Logger logger = LogManager.getLogger(PurchaseController.class);


    @PostMapping("/buy")
    public String buyProduct(
            @AuthenticationPrincipal User user,
            @RequestParam("prod_id") String prod_id,
            @RequestParam("count") int count,
            Map<String, Object> model) {
        Optional<Product> productOptional = productRepository.findById(Long.valueOf(prod_id));
        Object buyedProduct = null;
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getStorage_count() < count) {
                model.put("errorMessage", "Insert correct product count");
                Iterable<Product> products = productRepository.findAll();
                model.put("products", products);
                return "main";
            }
            try {
                buyedProduct = purchaseService.createPurchase(product, user, count);
                logger.debug("Success purchase " + buyedProduct);
            } catch (Exception e) {
                logger.error("Error while buying product " + product);
            }
            model.put("product", buyedProduct);
            return "purchaseReport";
        }
        return "redirect:/getProductList";
    }

    @GetMapping("/getPurchaseList")
    private String getPurchaseList(Map<String, Object> model) {
        List<Purchase> allPurchases = purchaseService.findAll();
        model.put("purchases", allPurchases);
        return "purchaseList";
    }


}
