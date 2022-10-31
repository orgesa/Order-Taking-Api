package com.melta.controller;

import com.melta.api.OderApi;
import com.melta.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OderApi {

    private final OrderService service;


    public OrderController(OrderService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<?> orderTaking() {
        return service.order();
    }
}
