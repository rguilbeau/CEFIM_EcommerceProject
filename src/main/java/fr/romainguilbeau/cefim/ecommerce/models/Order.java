package fr.romainguilbeau.cefim.ecommerce.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order
 */
public class Order {

    /**
     * Id of order
     */
    private Long id;
    /**
     * The date the order was created
     */
    private LocalDate dateCreated;
    /**
     * The order status
     */
    private OrderStatus status;
    /**
     * The all lines of the order
     */
    private List<OrderProduct> orderProducts;

    /**
     * Create new Order
     */
    public Order(Long id) {
        this.id = id;
        orderProducts = new ArrayList<>();
    }

    /**
     * Get the order ID
     *
     * @return The order ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the date the order was created
     *
     * @return The date the order was created
     */
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    /**
     * Get the order status
     *
     * @return The order status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Get the total price of the whole order
     *
     * @return The total price of the whole order
     */
    public double getTotalOrderPrice() {
        return orderProducts.stream().mapToDouble(OrderProduct::getTotalPrice).sum();
    }

    /**
     * Get the number of type product
     *
     * @return the number of type product
     */
    public int getNumberOfProducts() {
        return orderProducts.size();
    }

    /**
     * Get the number total of product with quantity
     *
     * @return the number total of product with quantity
     */
    public int getTotalNumberOfProduct() {
        return orderProducts.stream().mapToInt(OrderProduct::getQuantity).sum();
    }

    /**
     * Get all order products of this order
     *
     * @return all order products of this order
     */
    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    /**
     * Add product to the order
     *
     * @param product  The product to add
     * @param quantity The quantity to add
     */
    public void addProduct(Product product, int quantity) {
        orderProducts.add(new OrderProduct(product, quantity));
    }

    /**
     * Change the status of this order
     *
     * @param status The new status of this order
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Set the order create date to now
     */
    public void updateCreatedDate() {
        this.dateCreated = LocalDate.now();
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public String toString() {

        ArrayList<String> productOrdersStr = new ArrayList<>();
        for (OrderProduct orderProduct : orderProducts) {
            productOrdersStr.add(orderProduct.toString());
        }

        return "Order{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", getNumberOfProducts=" + getNumberOfProducts() +
                ", getTotalOrderPrice=" + getTotalOrderPrice() +
                ", getTotalNumberOfProduct=" + getTotalNumberOfProduct() +
                ", orderProducts=[" + String.join(", ", productOrdersStr) + "]" +
                '}';
    }

}
