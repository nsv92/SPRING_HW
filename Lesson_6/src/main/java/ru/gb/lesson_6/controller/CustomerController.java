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
public class CustomerController {
    private final EntityManager entityManager = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory().createEntityManager();
    private final CustomerDAO customerDAO = new CustomerDAO(entityManager);
    private final ProductDAO productDAO = new ProductDAO(entityManager);

    public CustomerController() {
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String findAllCustomers(Model model) {
        model.addAttribute("customers", customerDAO.findAll());
        return "customers";
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        customerDAO.deleteById(id);
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers-add";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addCustomer(Customer customer, Model model) {
        customerDAO.saveOrUpdate(customer);
        return (findAllCustomers(model));
    }

    @RequestMapping(value = "/customer/{customer_id}", method = RequestMethod.GET)
    public String customerDetails(@PathVariable Long customer_id, Model model) {
        model.addAttribute("customer", customerDAO.findById(customer_id));
        model.addAttribute("product", new Product());
        return "customer";
    }

    @RequestMapping(value = "/customer/{customer_id}", method = RequestMethod.POST)
    public String customerDetails(@PathVariable Long customer_id, Product product) {
        Customer customer = customerDAO.findById(customer_id);
        customer.addProduct(productDAO.findById(product.getId()));
        customerDAO.saveOrUpdate(customer);
        return "index";
    }



}
