package fr.romainguilbeau.cefim.ecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents one product
 */
@Entity
public class Product {

    /**
     * The product ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * No args constructor for orm
     */
    protected Product() {
        super();
    }

    /**
     * Create new product
     *
     * @param id          id
     * @param name        name
     * @param description desc
     * @param price       price
     * @param picture     pict
     */
    public Product(String name, String description, double price, String picture) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }

    /**
     * Get the product ID
     *
     * @return The product ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the name of the product
     *
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the product
     *
     * @return The description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the price of the product
     *
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the path of the product picture
     *
     * @return The path of the product picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
