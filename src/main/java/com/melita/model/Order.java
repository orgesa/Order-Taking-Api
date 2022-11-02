package com.melita.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Order {

    @Valid
    @NotNull(message  ="customerDetails must not be null")
    private CustomerDetails customerDetails;

    @Valid
    @NotNull(message  ="product must not be null")
    private Product product;
}