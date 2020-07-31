package fr.romainguilbeau.cefim.ecommerce.repositories;

import fr.romainguilbeau.cefim.ecommerce.models.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, Long> {

    Optional<Stock> findByProductId(Long productId);

}
