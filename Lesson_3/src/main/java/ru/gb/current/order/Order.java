package ru.gb.current.order;

import ru.gb.prev.product.Product;
import ru.gb.prev.product.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private ProductRepository pR;
    private int id;
    private final Date date = new Date();
    private float cost = 0;
    private List<Product> productList = new ArrayList<>();

    public Order() {
    }


    public void setProductRepository(ProductRepository productRepository) {
        this.pR = productRepository;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProduct(int id) {
        pR.findById(id).ifPresent(p -> productList.add(p));
    }

    public void removeProduct(int id) {
        productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(p -> productList.remove(p));
    }

    public float getCost() {
        if (productList.size() ==  0) {
           return cost;
        }
        for (Product product : productList) {
            cost += product.getPrice();
        }
        return cost;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", productList=" + productList +
                '}';
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String stringProductList() {
        if (getProductList().size() == 0) {
            return "null";
        }
        return getProductList().toString();
    }
}
