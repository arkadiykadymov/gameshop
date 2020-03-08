package ru.shop.game.contollers;

import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/buy")
    public String buyProduct(
            @AuthenticationPrincipal User user,
            @RequestParam("prod_id") String prod_id,
            @RequestParam("count") int count,
            Map<String, Object> model) {
        Optional<Product> productOptional = productRepository.findById(Long.valueOf(prod_id));
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getStorage_count() < count) {
                model.put("errorMessage", "Insert correct product count");
                Iterable<Product> products = productRepository.findAll();
                model.put("products", products);
                return "main";
            }
            Product buyedProduct = purchaseService.createPurchase(product, user, count);
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
