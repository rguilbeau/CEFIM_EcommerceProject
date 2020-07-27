package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Product;
import fr.romainguilbeau.cefim.ecommerce.models.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stock services
 */
public class StockServiceImpl implements StockService {

    /**
     * All stocks
     */
    private final List<Stock> allStock = new ArrayList<>();

    /**
     * {{@inheritDoc}}
     */
    @Override
    public List<Stock> getAllStock() {
        return allStock;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Stock findStockByProductId(Long productId) throws ResourceNotFoundException {
        Optional<Stock> optionalStock = allStock.stream()
                .filter(stock -> stock.getProduct().getId().equals(productId))
                .findAny();

        if (optionalStock.isEmpty()) {
            throw new ResourceNotFoundException();
        } else {
            return optionalStock.get();
        }
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public boolean isProductAvailable(Product product, int quantity) throws ResourceNotFoundException {
        Stock stock = findStockByProductId(product.getId());
        return stock.isProductAvailable(quantity);
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public void addProduct(Product product, int quantity) {
        try {
            Stock stock = findStockByProductId(product.getId());
            stock.adjustStock(quantity);
        } catch (ResourceNotFoundException e) {
            allStock.add(new Stock(product, quantity));
        }
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public void removeProduct(Product product, int quantity) throws StockException {
        Stock stock = findStockByProductId(product.getId());

        if (stock.getQuantity() < quantity) {
            throw new StockException();
        } else {
            stock.adjustStock(-quantity);
        }
    }
}
