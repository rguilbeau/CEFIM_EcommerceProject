package fr.romainguilbeau.cefim.ecommerce.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a line of an order
 */
@Entity
@Table(name = "orderproduct")
public class OrderProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Order order;
    /**
     * The number of ordered product
     */
    private int quantity;
    /**
     * The ordered product
     */
    @ManyToOne
    private Product product;

    /**
     * No args constructor for orm
     */
    protected OrderProduct() {

    }

    /**
     * Create new line of an order
     *
     * @param product  product
     * @param quantity quantity
     */
    public OrderProduct(Order order, Product product, int quantity) {
        this.order = order;
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
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
