
package com.example.order.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private Long id;
    private OrderStatus status;
    private BigDecimal total;

    public Order() {
    }

    public Order(Long id, OrderStatus status, BigDecimal total) {
        this.id = id;
        this.status = status;
        this.total = total;
    }

    public Order(OrderStatus status, BigDecimal total) {
        this.status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                status == order.status &&
                Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, total);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
