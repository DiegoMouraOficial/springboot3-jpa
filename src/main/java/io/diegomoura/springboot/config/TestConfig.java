package io.diegomoura.springboot.config;

import io.diegomoura.springboot.entities.Order;
import io.diegomoura.springboot.entities.User;
import io.diegomoura.springboot.entities.enums.OrderStatus;
import io.diegomoura.springboot.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Lupi", "lupi@bol.com.br", "11945875287", "xxx");
        User user2 = new User(null, "Rebeca", "rebeca@outlook.com", "11978562541", "xxx");
        User user3 = new User(null, "Meg", "meg@gmail.com", "11987562341", "xxx");

        Order order1 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), OrderStatus.AGUARDANDO_PAGAMENTO, user1 );
        Order order2 = new Order(null, Instant.parse("2024-02-22T04:23:15Z"), OrderStatus.PAGO, user2 );
        Order order3 = new Order(null, Instant.parse("2024-05-30T15:20:27Z"), OrderStatus.CANCELADO, user3 );

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
