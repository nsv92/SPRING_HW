package ru.gb.lesson_7_security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.lesson_7_security.customer.Customer;
import ru.gb.lesson_7_security.customer.CustomerRepository;
import ru.gb.lesson_7_security.product.Product;
import ru.gb.lesson_7_security.product.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ProductController(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
// REQUEST EXAMPLE: http://localhost:8081/products/price/max?max=350
    @RequestMapping(value = "/products/price/max", method = RequestMethod.GET)
    public String findMaxProducts(@RequestParam int max, Model model){
        model.addAttribute("products", productRepository.findAllByPriceLessThanEqualOrderByPriceDesc(max));
        return "products-price-max";
    }

    // REQUEST EXAMPLE: http://localhost:8081/products/price/min?min=350
    @RequestMapping(value = "/products/price/min", method = RequestMethod.GET)
    public String findMinProducts(@RequestParam int min, Model model){
        model.addAttribute("products", productRepository.findAllByPriceGreaterThanEqualOrderByPrice(min));
        return "products-price-min";
    }

    // REQUEST EXAMPLE: http://localhost:8081/products/price/between?min=50&max=700
    @RequestMapping(value = "/products/price/between", method = RequestMethod.GET)
    public String findMinProducts(@RequestParam int min, @RequestParam int max, Model model){
        model.addAttribute("products", productRepository.findAllByPriceBetweenOrderByPrice(min, max));
        return "products-price-between";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(Product product) {
        productRepository.save(product);
        return "redirect:http://localhost:8081/products";
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String productDetails(@PathVariable Long productId, Model model) {
        model.addAttribute("product", productRepository.findById(productId).get());
        model.addAttribute("customer", new Customer());
        return "product";
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.POST)
    public String productDetails(@PathVariable Long productId, Customer customer) {
        Product product = productRepository.findById(productId).get();
        product.addCustomer(customerRepository.findById(customer.getId()).get());
        productRepository.save(product);
        return "redirect:http://localhost:8081/products";
    }
}

