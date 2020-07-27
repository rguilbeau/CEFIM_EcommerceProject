package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Order;
import fr.romainguilbeau.cefim.ecommerce.models.OrderProduct;
import fr.romainguilbeau.cefim.ecommerce.models.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Order services
 */
public class OrderServiceImpl implements OrderService {

    /**
     * List of all orders
     */
    private final List<Order> allOrders = new ArrayList<>();
    /**
     * Stock services
     */
    private StockService stockService;

    /**
     * Ser the stock services
     *
     * @param stockService The stock services
     */
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Order create(Order order) {
        order.updateCreatedDate();
        order.setStatus(OrderStatus.IN_PROGRESS);
        allOrders.add(order);
        return order;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public void update(Order order) throws StockException {
        int sizeOrders = allOrders.size();
        boolean found = false;

        for (int i = 0; i < sizeOrders; i++) {
            if (allOrders.get(i).getId().equals(order.getId())) {
                allOrders.set(i, order);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new ResourceNotFoundException();
        }

        if (order.getStatus() == OrderStatus.PAYED) {
            for (OrderProduct orderProduct : order.getOrderProducts()) {
                stockService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
            }
        }
    }
}
