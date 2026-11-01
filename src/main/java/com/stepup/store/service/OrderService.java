package com.stepup.store.service;

import com.stepup.store.model.Order;
import com.stepup.store.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order place(Order order) {
        return repo.save(order);
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Optional<Order> getById(Long id) {
        return repo.findById(id);
    }
}
