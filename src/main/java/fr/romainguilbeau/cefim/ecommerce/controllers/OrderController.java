package fr.romainguilbeau.cefim.ecommerce.controllers;

import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Order;
import fr.romainguilbeau.cefim.ecommerce.models.OrderStatus;
import fr.romainguilbeau.cefim.ecommerce.models.Product;
import fr.romainguilbeau.cefim.ecommerce.services.OrderService;
import fr.romainguilbeau.cefim.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/Orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/Order/{order_id}")
    public String order(Model model, @PathVariable("order_id") Long id) {
        model.addAttribute("order", orderService.findOrderById(id));
        return "order";
    }

    @PostMapping(path = "/AddCart")
    @ResponseBody
    public void addCart(Model model, @RequestParam Map<String, String> body) throws StockException {
        Product product = productService.findProductById(Long.parseLong(body.get("id")));
        List<Order> orders = orderService.getAllOrders();
        Order currentOrder = null;
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.IN_PROGRESS) {
                currentOrder = order;
                break;
            }
        }

        if (currentOrder == null) {
            currentOrder = new Order();
            currentOrder = orderService.create(currentOrder);
        }

        currentOrder.addProduct(product, Integer.parseInt(body.get("quantity")));
        orderService.update(currentOrder);
    }

    @PostMapping(path = "/ValidateCart")
    @ResponseBody
    public void validateCart(Model model, @RequestParam Map<String, String> body) throws StockException {
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.IN_PROGRESS) {
                order.setStatus(OrderStatus.PAYED);
                orderService.update(order);
                break;
            }
        }
    }
}