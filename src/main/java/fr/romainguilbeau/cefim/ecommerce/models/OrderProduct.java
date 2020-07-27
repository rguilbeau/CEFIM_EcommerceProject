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
     * The ordered product
     */
    private Product product;

    /**
     * Create new line of an order
     *
     * @param product  product
     * @param quantity quantity
     */
    public OrderProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Get the number of ordered product
     *
     * @return The number ordered product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the ordered product
     *
     * @return The ordered product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Get the total price of this line of the order
     *
     * @return the total price of this line of the order
     */
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
 
    /**
     * {{@inheritDoc}}
     */
    @Override
    public String toString() {
        return "OrderProduct{" +
                "quantity=" + quantity +
                ", product=" + product.getName() +
                '}';
    }
}
