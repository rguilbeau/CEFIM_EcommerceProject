package fr.romainguilbeau.cefim.ecommerce.controllers;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.services.ProductService;
import fr.romainguilbeau.cefim.ecommerce.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StockService stockService;

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }


    @GetMapping("/Product/{productId}")
    public String product(Model model, @PathVariable("productId") Long id) {
        try {
            model.addAttribute("product", productService.findProductById(id));
            model.addAttribute("stock", stockService.findStockByProductId(id));
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }

        return "product";
    }
}
