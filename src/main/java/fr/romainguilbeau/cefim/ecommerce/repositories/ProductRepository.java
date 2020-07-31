package fr.romainguilbeau.cefim.ecommerce.repositories;

import fr.romainguilbeau.cefim.ecommerce.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
