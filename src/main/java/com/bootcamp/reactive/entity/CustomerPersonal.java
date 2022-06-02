package com.bootcamp.reactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "personal_customers")
public class CustomerPersonal {

	@Id
    private String id;
    private String firstName;
    private String lastName;
    private long dni;
    private long phoneNumber;
    private String bankAccountCorriente;
    private String bankAccountAhorro;
    private String bankAccountPlazoFijo;
    
}
