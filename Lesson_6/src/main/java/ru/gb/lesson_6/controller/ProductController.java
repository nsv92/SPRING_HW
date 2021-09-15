package ru.gb.lesson_6.controller;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.lesson_6.customer.Customer;
import ru.gb.lesson_6.customer.CustomerDAO;
import ru.gb.lesson_6.product.Product;
import ru.gb.lesson_6.product.ProductDAO;

import javax.persistence.EntityManager;

@Controller
public class ProductController {

    private final EntityManager entityManager = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory().createEntityManager();
    private final ProductDAO productDAO = new ProductDAO(entityManager);
    private final CustomerDAO customerDAO = new CustomerDAO(entityManager);

    public ProductController() {
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAllProducts(Model model) {
        model.addAttribute("products", productDAO.findAll());
        return "products";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        productDAO.deleteById(id);
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(Product product, Model model) {
        productDAO.saveOrUpdate(product);
        return (findAllProducts(model));
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String productDetails(@PathVariable Long productId, Model model) {
        model.addAttribute("product", productDAO.findById(productId));
        model.addAttribute("customer", new Customer());
        return "product";
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.POST)
    public String productDetails(@PathVariable Long productId, Customer customer) {
        Product product = productDAO.findById(productId);
        product.addCustomer(customerDAO.findById(customer.getId()));
        productDAO.saveOrUpdate(product);
        return "index";
    }
}

