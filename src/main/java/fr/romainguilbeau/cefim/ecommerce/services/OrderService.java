package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Order;

import java.util.List;

/**
 * Order services interface
 */
public interface OrderService {

    /**
     * Get all orders
     *
     * @return All orders
     */
    List<Order> getAllOrders();

    /**
     * Get one order
     *
     * @param id The id of order
     * @return The order
     */
    Order findOrderById(Long id);

    /**
     * Add new order with status "in_progress"
     *
     * @param order The order to add
     * @return The order added
     */
    Order create(Order order);

    /**
     * Update the order
     * Save the order and if order status is set to PAYED stocks will be updated
     *
     * @param order The order to update
     * @throws StockException Thrown if stock is not sufficient
     */
    void update(Order order) throws StockException;

}
