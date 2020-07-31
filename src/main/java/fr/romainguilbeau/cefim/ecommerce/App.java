package fr.romainguilbeau.cefim.ecommerce;

import fr.romainguilbeau.cefim.ecommerce.services.OrderService;
import fr.romainguilbeau.cefim.ecommerce.services.ProductService;
import fr.romainguilbeau.cefim.ecommerce.services.StockService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fr.*")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

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
        stockService.getAllStock().forEach(System.out::println);*/
    }

    @Bean
    CommandLineRunner runner(ProductService productService, StockService stockService, OrderService orderService) {
        return args -> {
            /*Product product0 = new Product("Converteur temporel", "Ce convecteur temporel dernière génération vous permettra de voyager à toutes les époques que vous voulez. Pour fonctionner il a besoin d'une puissance de 2.21 gigawatts (il faudra peut-être demander à Thomas Edison pour produire une puissance pareil).\nNoubliez par vos réserve de plutonium !", 10000D, "images/temporel.jpg");
            product0 = productService.save(product0);
            stockService.addProduct(product0, 2);

            Product product1 = new Product("Blouson du future", "Ce blouson venue tout droit de l'an 2015 vous tiendra chaud et au sec grâce à sa fonction d'auto-séchage. Il s'adapte à toutes les tailles, pour cela appuyer sur le bouton de retouche et le blouson ajustera la longueur de ses manches.\nPour parfaire votre look, retourner les poches de votre pantalon !", 80D, "images/blouson.jpg");
            product1 = productService.save(product1);
            stockService.addProduct(product1, 2);

            Product product2 = new Product("Almanac des sports", "Rerouvez tous les résultats sportifs des années 1950 à 2000 dans ce magazine. Ce produit est vendu dans une boutique rétro des années 2015. Vous pourrez faire un loto sportif ça met un peu de beurre dans les épinards !\nNous précisons toutefois qu'il ne possède pas de jaquette auto-dépoussirante.", 5.95D, "images/almanac.jpg");
            product2 = productService.save(product2);
            stockService.addProduct(product2, 2);

            Product product3 = new Product("Don pour l'horlage", "Faite ce don de 10€ pour sauver l'horloge de l'hôtel de ville d'Hill Valley. En effet, le 12 novembre 1955 fut le jour exact où la foudre s’est abattue sur l’horloge, ce qui l’a fait passer du rang de simple clocher à celui de Monument Historique.\nCes dons serviront pour sauver cette horloge afin que celle-ci ne soit pas remplacée.", 10D, "images/clock.jpg");
            product3 = productService.save(product3);
            stockService.addProduct(product3, 10000);

            Product product4 = new Product("Plutonium", " Avec cette caisse de plutonium, vous pouvez voyager dans 12 époques différentes. Ajouter une pastille pour chaque voyage dans votre machine qui doit être entièrement gainé de plomb.\nCe produit est officiel et non un joli boitier de bombe rempli de vieilles pièces de flipper.", 750D, "images/plutonium.jpg");
            product4 = productService.save(product4);
            stockService.addProduct(product4, 2);

            Product product5 = new Product("Féérie dansante des Sirènes", "Achetez ce billet et venez vous amuser et danser dans ce bal qui aura lieu en 1955. Vous y trouverez de superbe musique comme Earth angel, Johny B. Goode.\nVenez avec votre cavalier ou votre cavalière et vous poserez peut-être pour la première fois vos lèvres sur les siennes !", 15D, "images/sirènes.jpg");
            product5 = productService.save(product5);
            stockService.addProduct(product5, 2);

            Product product6 = new Product("Hoverboard", "N'avez vous jamais rêvé de faire du skate volant ? Votre rêve est désomrai possible grâce à cette hoverboard dernière génération!\nAttention, cet overboard ne fonctionne pas sur l'eau, ce n'est pas pour le surf ! Pour aller sur l'eau prenez plutôt un pitbull.", 70D, "images/hoverboard.jpg");
            product6 = productService.save(product6);
            stockService.addProduct(product6, 2);

            Product product7 = new Product("Caméscope JVC", " Ce caméscope vous permettra de filmer toutes vos aventures quelle que soit l'époque où vous vous trouvez. Il est livré avec une cassette prête à l'emploi.\nRonald Reagan n'a qu'à bien se tenir !", 150D, "images/camescope.jpg");
            product7 = productService.save(product7);
            stockService.addProduct(product7, 2);

            Product product8 = new Product("Télécommande voiture", "Pilotez votre voiture à distance grâce à cette télécommande portative.\nAtteignez facilement les 88 miles à l'heure avec son option de frein à main et ses joysticks précis.", 150D, "images/remote_control.jpg");
            product8 = productService.save(product8);
            stockService.addProduct(product8, 2);

            Product product9 = new Product("Amplificateur", "Jouez votre musique préférée avec cet amplificateur. Il se compose de 4 enceintes un subwoofer d'un diamètre de plus d'un mètre.\nAvant de l'utiliser, veillez à contacter le doc pour être sûre qu'il n'y est pas un léger risque de court-circuit.", 150D, "images/ampli.jpg");
            product9 = productService.save(product9);
            stockService.addProduct(product9, 2);

            Product product10 = new Product("Oh là là", "Trouvez les plus belles photos de lingerie érotique française dans ce nouveau numéro 29 d'\"Oh là là\". Ce magazine possède une jaquette amovible qui vous permettra de rester discret en l'intervertissant avec une autre jaquette.", 4.5D, "images/ohohlala.jpg");
            product10 = productService.save(product10);
            stockService.addProduct(product10, 2);

            Product product11 = new Product("Mr fusion", "Vous en avez mare d'acheter du plutonium . Convertissez votre machine à voyager dans le temps avec cette caftère Mr Fusion, simple et écologique, il vous suffit d'y placer n'importe quels de vos déchets pour produire une puissance de 2.21 gigawatts d'électricité nécessaire aux converteur temporelles.", 650D, "images/mrfusion.jpg");
            product11 = productService.save(product11);
            stockService.addProduct(product11, 2);


            Order order = new Order();
            order = orderService.create(order);

            order.addProduct(product0, 12);
            order.addProduct(product1, 12);
            order.addProduct(product2, 12);
            orderService.update(order);

            List<Order> resume = orderService.getAllOrders();
            int i = 0;*/
        };
    }
}
