package com.starlight.restclientservice.controller;

import com.starlight.restclientservice.dto.OrderDto;
import com.starlight.restclientservice.model.Order;
import com.starlight.restclientservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping("/order")
    public Order addClient(@RequestBody @Validated OrderDto orderDto) {
        return orderService.create(orderDto);
    }

}



