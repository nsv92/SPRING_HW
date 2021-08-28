package Main;

import Carts.Cart;
import Products.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfig {

//    @Bean(name = "product")
//    public Product product() {return new Product();}

    @Bean(name = "productRepository")
    public ProductRepository productRepository() {return new ProductRepository();}

    @Bean(name = "cart")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cart cart() {return new Cart(productRepository());}

}
