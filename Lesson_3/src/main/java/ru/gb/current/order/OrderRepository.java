package ru.gb.current.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public Optional<Order> findById(int id)   {
        return orders.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    public List<Order> findAll() {
        return orders;
    }


    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
