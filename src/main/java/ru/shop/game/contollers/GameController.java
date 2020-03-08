package ru.shop.game.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.shop.game.domain.Product;
import ru.shop.game.domain.User;
import ru.shop.game.repositories.ProductRepository;
import ru.shop.game.service.PurchaseService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class GameController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private final ProductRepository productRepository;

    public GameController(ProductRepository productRepository, PurchaseService purchaseService) {
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

    @GetMapping("/addProduct")
    public String adProduct(Map<String, Object> map) {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String desc,
            @RequestParam String price,
            @RequestParam String count,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model
    ) throws IOException {

        Product product = new Product(title, desc, Double.parseDouble(price), Integer.parseInt(count));
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File fileDir = new File(uploadPath);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            String uuidFileId = UUID.randomUUID().toString();
            String resultFileName = uuidFileId + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setFilename(resultFileName);
        }
        productRepository.save(product);
        List<Product> all = (List<Product>) productRepository.findAll();
        model.put("products", all);
        return "main";
    }

    @PostMapping("/delete")
    private String deleteProduct(
            @RequestParam("prod_id") String prod_id,
            Map<String, Object> model) {
        productRepository.deleteById(Long.valueOf(prod_id));
        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);
        return "main";
    }

    @GetMapping("/edit/{product}")
    private String editProduct(
            @PathVariable("product") String prod_id,
            Map<String, Object> model) {
        Product product = null;
        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(prod_id));
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
            model.put("productEdit", product);
        }
        return "editProduct";
    }

    @PostMapping("/edit/{product}")
    private String saveEditing(
            @PathVariable("product") String prod_id,
            @RequestParam String title,
            @RequestParam String desc,
            @RequestParam String price,
            @RequestParam String count,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException {
        Product product = null;
        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(prod_id));
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
            product.setTitle(title);
            product.setDescription(desc);
            product.setPrice(Double.parseDouble(price));
            product.setStorage_count(Integer.parseInt(count));
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File fileDir = new File(uploadPath);
                if (!fileDir.exists()) {
                    fileDir.mkdir();
                }
                String uuidFileId = UUID.randomUUID().toString();
                String resultFileName = uuidFileId + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                product.setFilename(resultFileName);
            }
            productRepository.save(product);
        }
        List<Product> all = (List<Product>) productRepository.findAll();
        model.put("products", all);
        return "main";
    }


}

