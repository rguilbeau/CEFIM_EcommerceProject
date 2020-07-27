package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.models.Product;

import java.util.List;

/**
 * Product service interface
 */
public interface ProductService {

    /**
     * Get all products
     *
     * @return all products
     */
    List<Product> getAllProducts();

    /**
     * Find product with his id
     *
     * @param id The wanted product id
     * @return The product
     * @throws ResourceNotFoundException if product is not found
     */
    Product findProductById(Long id);

    /**
     * Add new product
     *
     * @param product The product to add
     * @return The product added
     */
    Product save(Product product);

}
