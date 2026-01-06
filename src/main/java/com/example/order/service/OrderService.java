package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.model.OrderStatus;
import com.example.order.repository.InMemoryOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final InMemoryOrderRepository repository;

    public OrderService(InMemoryOrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order order) {
        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.NEW);
        }
        return repository.save(order);
    }

    public Order getOrder(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Order> listOrders() {
        return repository.findAll();
    }

    public Order cancelOrder(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        if (order.getStatus() == OrderStatus.SHIPPED) {
            throw new IllegalStateException("Não é possível cancelar pedido já enviado");
        }
        order.setStatus(OrderStatus.CANCELLED);
        return repository.save(order);
    }
}

