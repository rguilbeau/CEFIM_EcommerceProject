package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Product services
 */
public class ProductServiceImpl implements ProductService {

    /**
     * List of all products
     */
    private final List<Product> allProduct = new ArrayList<>();

    /**
     * {{@inheritDoc}}
     */
    @Override
    public List<Product> getAllProducts() {
        return allProduct;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Product findProductById(Long id) throws ResourceNotFoundException {
        Optional<Product> productOptional = allProduct.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();

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
        allProduct.add(product);
        return product;
    }
}
