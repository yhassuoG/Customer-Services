package com.bootcamp.reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private String id;
    private String firstName;
    private String lastName;
    private long dni;
    private long phoneNumber;
    private String type;
    
}
