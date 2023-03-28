package com.example.team_project.domain.domain.order.item.domain;

import com.example.team_project.exception.OrderNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    default Order validateOrderId(Long orderId){
        Optional<Order> orderOptional = findById(orderId);
        if (orderOptional.isPresent()){
            return orderOptional.get();
        }
        throw new OrderNotFoundException();
    }

    boolean existsById(Long orderId);
}