package com.gleidev.orders.adapters.inbound.controller;

import com.gleidev.orders.adapters.inbound.controller.mapper.OrderMapper;
import com.gleidev.orders.adapters.inbound.controller.request.CustomerRequest;
import com.gleidev.orders.adapters.inbound.controller.request.OrderRequest;
import com.gleidev.orders.adapters.inbound.controller.response.OrderResponse;
import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.in.FindOrderByIdUseCasePort;
import com.gleidev.orders.application.ports.in.SaveOrderUseCasePort;
import com.gleidev.orders.application.ports.in.UpdateOrderUseCasePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private SaveOrderUseCasePort saveOrderUseCasePort;

    @Autowired
    private FindOrderByIdUseCasePort findOrderByIdUseCasePort;

    @Autowired
    private UpdateOrderUseCasePort updateOrderUseCasePort;
    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody OrderRequest orderRequest) {
        var order = orderMapper.toOrder(orderRequest);
        saveOrderUseCasePort.save(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable final String id) {
        var order = findOrderByIdUseCasePort.find(id);
        var orderResponse = orderMapper.toOrderResponse(order);
        return ResponseEntity.ok().body(orderResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody OrderRequest orderRequest) {
        var order = orderMapper.toOrder(orderRequest);
        order.setId(id);
        updateOrderUseCasePort.update(order);
        return ResponseEntity.noContent().build();
    }
}
