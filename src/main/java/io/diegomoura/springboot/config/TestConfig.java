package io.diegomoura.springboot.config;

import io.diegomoura.springboot.entities.Category;
import io.diegomoura.springboot.entities.Order;
import io.diegomoura.springboot.entities.Product;
import io.diegomoura.springboot.entities.User;
import io.diegomoura.springboot.entities.enums.OrderStatus;
import io.diegomoura.springboot.repositories.CategoryRepository;
import io.diegomoura.springboot.repositories.OrderRepository;
import io.diegomoura.springboot.repositories.ProductRepository;
import io.diegomoura.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Livros");
        Category category3 = new Category(null, "Vestuário");

        Product produto1 = new Product(null, "Código Limpo","Este livro...", 99.00, "");
        Product produto2 = new Product(null, "Macbook Pro","Este Macbook pro...", 19999.00, "");
        Product produto3 = new Product(null, "PC Gamer","Este PC Gamer...", 3499.98, "");
        Product produto4 = new Product(null, "Cadeira para Escritório","Está cadeira...", 999.00, "");

        User user1 = new User(null, "Lupi", "lupi@bol.com.br", "11945875287", "xxx");
        User user2 = new User(null, "Rebeca", "rebeca@outlook.com", "11978562541", "xxx");
        User user3 = new User(null, "Meg", "meg@gmail.com", "11987562341", "xxx");

        Order order1 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), OrderStatus.AGUARDANDO_PAGAMENTO, user1 );
        Order order2 = new Order(null, Instant.parse("2024-02-22T04:23:15Z"), OrderStatus.PAGO, user2 );
        Order order3 = new Order(null, Instant.parse("2024-05-30T15:20:27Z"), OrderStatus.CANCELADO, user3 );

        categoryRepository.saveAll((Arrays.asList(category1, category2, category3)));
        productRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4));
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
