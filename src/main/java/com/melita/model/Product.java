package com.melita.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Product {

    @NotNull(message  ="name must not be null")
    private String name;
    @NotNull(message  ="description must not be null")
    private String description;
    @NotNull(message  ="packageType must not be null")
    private String packageType;

}
