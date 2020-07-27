package fr.romainguilbeau.cefim.ecommerce.models;

/**
 * All order status
 */
public enum OrderStatus {

    /**
     * The order is in progress
     */
    IN_PROGRESS("in_progress"),
    /**
     * The order is payed
     */
    PAYED("payed");

    /**
     * Value of status
     */
    private final String value;

    /**
     * Create status
     *
     * @param value value of status
     */
    OrderStatus(String value) {
        this.value = value;
    }

    /**
     * Get the value of status
     *
     * @return The value of status
     */
    @Override
    public String toString() {
        return value;
    }
}
