package com.tarka.tarka.config;

import com.tarka.tarka.model.Category;
import com.tarka.tarka.model.Order;
import com.tarka.tarka.model.Product;
import com.tarka.tarka.model.User;
import com.tarka.tarka.model.enums.OrderStatus;
import com.tarka.tarka.repositories.CategoryRepository;
import com.tarka.tarka.repositories.OrderRepository;
import com.tarka.tarka.repositories.ProductRepository;
import com.tarka.tarka.repositories.UserRepository;
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

        Category category1 = new Category(null, "eletronico");
        Category category2 = new Category(null, "jogo");
        Category category3 = new Category(null, "livro");
        Category category4 = new Category(null, "musica");


        Product p1 = new Product("222", 120.0, "jogo","mario", null);
        Product p2 = new Product("111", 140.0, "video game","ps4", null);
        Product p3 = new Product("333", 160.0, "musica","alice sohee", null);
        Product p4 = new Product("4444", 170.0, "eletronico","pc gamer", null);



        categoryRepository.saveAll(Arrays.asList(category1,category2,category3,category4));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        p1.getCategories().add(category2);
        p1.getCategories().add(category1);

        p2.getCategories().add(category1);
        p2.getCategories().add(category2);

        p3.getCategories().add(category4);

        p4.getCategories().add(category1);
        p4.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        User user1 = new User(null, "Adam Sandler" , "adamsandler@gmail.com", "48 999586199" , "pwd123");
        User user2 = new User(null, "Kim Sohee" , "kimsohee@gmail.com", "48 999586198" , "pwd123");

        Order order1 = new Order(null, Instant.parse("2019-08-07T19:53:07Z"), user1 , OrderStatus.DELIVERED);
        Order order2 = new Order(null, Instant.parse("2020-08-07T19:53:07Z"), user2 , OrderStatus.CANCELED);
        Order order3 = new Order(null, Instant.parse("2019-10-22T19:53:07Z"), user1 , OrderStatus.PAID);
        Order order4 = new Order(null, Instant.parse("2020-10-22T19:53:07Z"), user2 , OrderStatus.WAITING_PAYMENT);




        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));
    }
}