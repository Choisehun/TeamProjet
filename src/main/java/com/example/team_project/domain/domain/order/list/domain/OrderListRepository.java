package com.example.team_project.domain.domain.order.list.domain;

import com.example.team_project.exception.OrderNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {

    default OrderList validateOrderListId(Long orderListId){
        Optional<OrderList> orderListOptional = findById(orderListId);
        if (orderListOptional.isPresent()){
            return orderListOptional.get();
        }
        throw new OrderNotFoundException();
    }



}