package com.melita.controller;

import com.melita.model.Order;
import com.melita.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping(value = "/order_taking",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> orderTaking(@RequestHeader Map<String, Object> headers, @Valid @RequestBody Order request){
        return service.order(request);
    }

}


