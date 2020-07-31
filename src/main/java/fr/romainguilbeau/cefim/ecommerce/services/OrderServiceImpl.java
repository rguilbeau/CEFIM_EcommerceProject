package fr.romainguilbeau.cefim.ecommerce.services;

import fr.romainguilbeau.cefim.ecommerce.exceptions.ResourceNotFoundException;
import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Order;
import fr.romainguilbeau.cefim.ecommerce.models.OrderProduct;
import fr.romainguilbeau.cefim.ecommerce.models.OrderStatus;
import fr.romainguilbeau.cefim.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Order services
 */
@Service("orders")
public class OrderServiceImpl implements OrderService {
    /**
     * Stock services
     */
    @Autowired
    private OrderRepository orderRepository;
    /**
     * Stock services
     */
    @Autowired
    private StockService stockService;

    /**
     * {{@inheritDoc}}
     */
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Order findOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        } else {
            return orderOptional.get();
        }
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public Order create(Order order) {
        order.updateCreatedDate();
        order.setStatus(OrderStatus.IN_PROGRESS);
        return orderRepository.save(order);
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public void update(Order order) throws StockException {
        // check if order exists
        findOrderById(order.getId());

        // update stock if order payed
        if (order.getStatus() == OrderStatus.PAYED) {
            for (OrderProduct orderProduct : order.getOrderProducts()) {
                stockService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
            }
        }

        orderRepository.save(order);
    }
}
