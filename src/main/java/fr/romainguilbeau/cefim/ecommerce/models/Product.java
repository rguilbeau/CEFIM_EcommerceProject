package fr.romainguilbeau.cefim.ecommerce.models;

/**
 * Represents one product
 */
public class Product {

    /**
     * The product ID
     */
    private Long id;
    /**
     * The name of the product
     */
    private String name;
    /**
     * The description of the product
     */
    private String description;
    /**
     * The price of the product
     */
    private double price;
    /**
     * The picture path of the product
     */
    private String picture;
    /**
     * The stock associated to this product
     */
    private Stock stock;

    /**
     * Get the product ID
     * @return The product ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the name of the product
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the product
     * @return The description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the price of the product
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the path of the product picture
     * @return The path of the product picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Get the stock associated to this product
     * @return The stock associated to this product
     */
    public Stock getStock() {
        return stock;
    }
}
