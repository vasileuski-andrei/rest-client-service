package com.starlight.restclientservice.service;

import com.starlight.restclientservice.dto.OrderDto;
import com.starlight.restclientservice.model.Order;
import com.starlight.restclientservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService implements CommonService<Order, OrderDto> {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public Order create(OrderDto orderDto) {
        orderDto.setCreationDate(LocalDateTime.now());
        Order order = convertToOrder(orderDto);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(OrderDto orderDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    private Order convertToOrder(OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }

}
