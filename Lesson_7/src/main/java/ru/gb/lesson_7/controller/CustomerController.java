package ru.gb.lesson_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.lesson_7.customer.Customer;
import ru.gb.lesson_7.customer.CustomerRepository;
import ru.gb.lesson_7.product.Product;
import ru.gb.lesson_7.product.ProductRepository;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CustomerController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String findAllCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers-add";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "redirect:http://localhost:8081/customers";
    }

        @RequestMapping(value = "/customer/{customer_id}", method = RequestMethod.GET)
    public String customerDetails(@PathVariable Long customer_id, Model model) {
        model.addAttribute("customer", customerRepository.findById(customer_id).get());
        model.addAttribute("product", new Product());
        return "customer";
    }

    @RequestMapping(value = "/customer/{customer_id}", method = RequestMethod.POST)
    public String customerDetails(@PathVariable Long customer_id, Product product) {
        Customer customer = customerRepository.findById(customer_id).get();
        customer.addProduct(productRepository.findById(product.getId()).get());
        customerRepository.save(customer);
        return "redirect:http://localhost:8081/customers";
    }


}
