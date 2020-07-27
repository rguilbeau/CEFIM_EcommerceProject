package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Product;
import fr.romainguilbeau.cefim.ecommerce.models.Stock;

import java.util.List;

/**
 * Stock service interface
 */
public interface StockService {

    /**
     * Get stock of all products
     *
     * @return All stock of all products
     */
    List<Stock> getAllStock();

    /**
     * Get stock for one product
     *
     * @param productId The id of product
     * @return The stock of product
     */
    Stock findStockByProductId(Long productId);

    /**
     * Check if stock is sufficient for a product
     *
     * @param product  The product
     * @param quantity The wanted quantity
     * @return true if stock is sufficient, else false
     */
    boolean isProductAvailable(Product product, int quantity);

    /**
     * Add stock for one product
     *
     * @param product  The product to add stock
     * @param quantity The quantity of product to add into stock
     */
    void addProduct(Product product, int quantity);

    /**
     * Remove stock for one product
     *
     * @param product  The product to remove stock
     * @param quantity The quantity of product to remove
     * @throws StockException Thrown if product is negative
     */
    void removeProduct(Product product, int quantity) throws StockException;

}
