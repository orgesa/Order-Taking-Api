package com.melta.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


public interface OderApi {

    @PostMapping(value = "/rest/order_taking",
    produces = { "application/json" },
    consumes = { "application/json" })
    ResponseEntity<?> orderTaking();
}
