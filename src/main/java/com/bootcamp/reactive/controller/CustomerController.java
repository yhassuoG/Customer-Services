package com.bootcamp.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.reactive.entity.CustomerBusiness;
import com.bootcamp.reactive.entity.CustomerPersonal;
import com.bootcamp.reactive.service.CustomerService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/personal/{dni}")
    public Mono<CustomerPersonal> getCustomerByDni(@PathVariable long dni){
        return service.getCustomerByDni(dni);
	}
        
	@PostMapping("/personal")
    public Mono<CustomerPersonal> saveCustomerPersonal(@RequestBody Mono<CustomerPersonal> customer){
        return service.saveCustomerPersonal(customer);
    }
	
	@PostMapping("/business")
    public Mono<CustomerBusiness> saveCustomerBusiness(@RequestBody Mono<CustomerBusiness> customer){
        return service.saveCustomerBusiness(customer);
    }
}
