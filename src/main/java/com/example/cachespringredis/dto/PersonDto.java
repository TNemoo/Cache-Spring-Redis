package com.example.cachespringredis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDto implements Serializable {
    @NotBlank(message = "the field can't be empty")
    private String firstname;
    @NotBlank(message = "the field can't be empty")
    private String surname;
    @NotBlank(message = "the field can't be empty")
    @NotBlank
    @Pattern(regexp = "^\\+\\d{2}-\\d{3}-\\d{3}-\\d{2}-\\d{2}$",
            message = "Format phone number: +XX-XXX-XXX-XX-XX")
    private String phoneNumber;
}
