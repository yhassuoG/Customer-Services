package com.bootcamp.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.reactive.entity.CustomerBusiness;
import com.bootcamp.reactive.entity.CustomerPersonal;
import com.bootcamp.reactive.repository.CustomerBusinessRepository;
import com.bootcamp.reactive.repository.CustomerPersonalRepository;

import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	@Autowired
	private CustomerPersonalRepository customerRepository;

	@Autowired
	private CustomerBusinessRepository customerBusinessRepository;

	public Mono<CustomerPersonal> saveCustomerPersonal(Mono<CustomerPersonal> customer) {

		return customer.flatMap(c -> {
			
			return customerRepository.insert(c);
		});

	}

	public Mono<CustomerBusiness> saveCustomerBusiness(Mono<CustomerBusiness> customer) {
		return customer.flatMap(customerBusinessRepository::insert);
	}
	
	public Mono<CustomerPersonal> getCustomerByDni(long dni){
		
		return customerRepository.findByDni(dni);
	}
}
