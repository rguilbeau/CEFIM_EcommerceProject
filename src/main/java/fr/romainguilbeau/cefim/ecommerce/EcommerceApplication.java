package fr.romainguilbeau.cefim.ecommerce;

import fr.romainguilbeau.cefim.ecommerce.exceptions.StockException;
import fr.romainguilbeau.cefim.ecommerce.models.Order;
import fr.romainguilbeau.cefim.ecommerce.models.OrderStatus;
import fr.romainguilbeau.cefim.ecommerce.models.Product;
import fr.romainguilbeau.cefim.ecommerce.services.OrderService;
import fr.romainguilbeau.cefim.ecommerce.services.ProductService;
import fr.romainguilbeau.cefim.ecommerce.services.StockService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        // SpringApplication.run(EcommerceApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans/services.xml");

        ProductService productService = context.getBean("products", ProductService.class);

        Product product1 = new Product(0L, "Overboard", "Super overboard !", 799.99, "");
        Product product2 = new Product(1L, "Delorean DMC12", "Super Delorean DMC12 !", 30000, "");
        Product product3 = new Product(2L, "Sono-inducteur", "Sono-inducteur par projection d'ondes alpha", 68.99, "");

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        productService.getAllProducts().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");
        StockService stockService = context.getBean("stocks", StockService.class);
        stockService.addProduct(product1, 10);
        stockService.addProduct(product2, 10);
        stockService.addProduct(product3, 10);

        try {
            stockService.removeProduct(product1, 1);
            stockService.removeProduct(product2, 1);
            stockService.removeProduct(product3, 1);
        } catch (StockException e) {
            e.printStackTrace();
        }

        stockService.getAllStock().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");
        OrderService orderService = context.getBean("orders", OrderService.class);
        Order order = new Order(1L);
        order.addProduct(product1, 1);
        order.addProduct(product2, 2);


        System.out.println(order);
        System.out.println("------------------------------------------------------------------------------------");

        order = orderService.create(order);
        order.setStatus(OrderStatus.PAYED);
        try {
            orderService.update(order);
        } catch (StockException e) {
            e.printStackTrace();
        }

        stockService.getAllStock().forEach(System.out::println);
    }

}
