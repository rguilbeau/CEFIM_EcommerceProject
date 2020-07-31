package fr.romainguilbeau.cefim.ecommerce.models;

import javax.persistence.*;

/**
 * Represents the stock of a product
 */
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * The product in the stock
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    /**
     * The quantity of the product in the stock
     */
    private int quantity;

    /**
     * No args constructor for orm
     */
    protected Stock() {
        super();
    }

    /**
     * Create new stock
     *
     * @param product  The product in the stock
     * @param quantity The quantity to set
     */
    public Stock(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Get the product of this stock
     *
     * @return The product of this stock
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Get the quantity of the product in the stock
     *
     * @return the quantity of the product in the stock
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Adjust stock by adding (or remove if negative) quantity
     *
     * @param quantityToAddOrRemove The quantity to add (or remove if negative)
     */
    public void adjustStock(int quantityToAddOrRemove) {
        quantity += quantityToAddOrRemove;
    }

    /**
     * Checks if the stock is in sufficient quantity
     *
     * @param requestQuantity The wanted quantity
     * @return true if stock is in sufficient quantity, else false
     */
    public boolean isProductAvailable(int requestQuantity) {
        return requestQuantity <= quantity;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public String toString() {
        return "Stock{" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
