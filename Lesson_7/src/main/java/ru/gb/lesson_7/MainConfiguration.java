package ru.gb.lesson_7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.lesson_7.customer.CustomerDAO;
import ru.gb.lesson_7.product.ProductDAO;

@Configuration
public class MainConfiguration {

    @Bean
    public ProductDAO productDAO() {
        return new ProductDAO();
    }

    @Bean
    public CustomerDAO customerDAO() {
        return new CustomerDAO();
    }

}

