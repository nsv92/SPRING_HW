package ru.gb.lesson_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.lesson_4.order.Order;
import ru.gb.lesson_4.order.OrderRepository;
import ru.gb.lesson_4.product.Product;
import ru.gb.lesson_4.product.ProductRepository;

@Controller
public class MainController {

    private final ProductRepository productRepository;
    private OrderRepository orderRepository;

    public MainController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String findAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(Product product, Model model) {
        productRepository.add(product);
        return (findAllProducts(model));
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        return "orders-add";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String addOrder(Order order, Model model) {
        order.setProductRepository(productRepository);
        orderRepository.add(order);
        return findAllOrders(model);
    }

}
