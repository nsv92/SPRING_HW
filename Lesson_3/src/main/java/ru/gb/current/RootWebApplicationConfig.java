package ru.gb.current;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.gb.current.order.OrderConfiguration;
import ru.gb.prev.product.ProductConfiguration;

@Configuration

@Import({ProductConfiguration.class, OrderConfiguration.class})
public class RootWebApplicationConfig{
}
