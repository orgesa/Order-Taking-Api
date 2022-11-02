package com.melita.model;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerDetails {

    @NotNull(message  ="name must not be null")
    private String name;
    @NotNull(message  ="address must not be null")
    private String address;
    @NotNull(message  ="city must not be null")
    private String city;
    @NotNull(message  ="zip must not be null")
    private String zip;
    @NotNull(message  ="installationDate must not be null")
    private String installationDate;

}
