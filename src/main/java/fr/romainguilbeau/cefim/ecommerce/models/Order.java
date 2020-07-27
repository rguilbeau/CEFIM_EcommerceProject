package fr.romainguilbeau.cefim.ecommerce.models;

import java.time.LocalDate;

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
    private String status;

    /**
     * Get the order ID
     * @return The order ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the date the order was created
     * @return The date the order was created
     */
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    /**
     * Get the order status
     * @return The order status
     */
    public String getStatus() {
        return status;
    }
}
