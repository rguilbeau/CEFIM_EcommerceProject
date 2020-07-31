package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Product;
import fr.romainguilbeau.cefim.ecommerce.models.Stock;
import fr.romainguilbeau.cefim.ecommerce.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stock services
 */
@Service("stocks")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    /**
     * {{@inheritDoc}}
     */
    @Override
    public List<Stock> getAllStock() {
        List<Stock> stocks = new ArrayList<>();
        stockRepository.findAll().forEach(stocks::add);
        return stocks;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Stock findStockByProductId(Long productId) throws ResourceNotFoundException {
        Optional<Stock> stockOptional = stockRepository.findByProductId(productId);
        if (stockOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        } else {
            return stockOptional.get();
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
            stockRepository.save(stock);
        } catch (ResourceNotFoundException e) {
            stockRepository.save(new Stock(product.getId(), product, quantity));
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
            stockRepository.save(stock);
        }
    }
}
