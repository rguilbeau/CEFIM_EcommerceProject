package fr.romainguilbeau.cefim.ecommerce.models;

/**
 * Represents a line of an order
 */
public class OrderProduct {

    /**
     * The number of ordered product
     */
    private int quantity;
    /**
     * The global order
     */
    private Order order;
    /**
     * The ordered product
     */
    private Product product;

    /**
     * Get the number of ordered product
     * @return The number ordered product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the global order
     * @return The global order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Get the ordered product
     * @return The ordered product
     */
    public Product getProduct() {
        return product;
    }
}
