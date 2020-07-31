package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.models.Product;
import fr.romainguilbeau.cefim.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Product services
 */
@Service("products")
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    /**
     * {{@inheritDoc}}
     */
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Product findProductById(Long id) throws ResourceNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        } else {
            return productOptional.get();
        }
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
