package io.diegomoura.springboot.config;

import io.diegomoura.springboot.entities.*;
import io.diegomoura.springboot.entities.enums.OrderStatus;
import io.diegomoura.springboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

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
    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Livros");
        Category category3 = new Category(null, "Escritorio");

        Product produto1 = new Product(null, "Código Limpo","Este livro...", 99.00, "");
        Product produto2 = new Product(null, "Macbook Pro","Este Macbook pro...", 19999.00, "");
        Product produto3 = new Product(null, "PC Gamer","Este PC Gamer...", 3499.98, "");
        Product produto4 = new Product(null, "Cadeira para Escritório","Está cadeira...", 999.00, "");

        categoryRepository.saveAll((Arrays.asList(category1, category2, category3)));
        productRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4));

        //Associacao entre objetos
        produto1.getCategories().add(category2);
        produto2.getCategories().add(category1);
        produto3.getCategories().add(category1);
        produto4.getCategories().add(category3);

        productRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4));

        User user1 = new User(null, "Lupi", "lupi@bol.com.br", "11945875287", "xxx");
        User user2 = new User(null, "Rebeca", "rebeca@outlook.com", "11978562541", "xxx");
        User user3 = new User(null, "Meg", "meg@gmail.com", "11987562341", "xxx");

        Order order1 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), OrderStatus.AGUARDANDO_PAGAMENTO, user1 );
        Order order2 = new Order(null, Instant.parse("2024-02-22T04:23:15Z"), OrderStatus.PAGO, user2 );
        Order order3 = new Order(null, Instant.parse("2024-05-30T15:20:27Z"), OrderStatus.CANCELADO, user3 );

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItem orderItem1 = new OrderItem(order1,produto1, 2, produto1.getPreco());
        OrderItem orderItem2 = new OrderItem(order1,produto2, 5, produto2.getPreco());
        OrderItem orderItem3 = new OrderItem(order3,produto3, 10, produto3.getPreco());
        OrderItem orderItem4 = new OrderItem(order3,produto4, 6, produto4.getPreco());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

        Payment payment1 = new Payment(null, Instant.parse("2024-02-22T05:23:15Z"), order2);
        order2.setPayment(payment1);

        orderRepository.saveAll(List.of(order2));

    }
}
