package fr.romainguilbeau.cefim.ecommerce.repositories;

import fr.romainguilbeau.cefim.ecommerce.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
