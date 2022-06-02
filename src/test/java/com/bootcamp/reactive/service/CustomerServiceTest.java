package com.bootcamp.reactive.service;

import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.reactive.entity.CustomerBusiness;
import com.bootcamp.reactive.entity.CustomerPersonal;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
 	
@RunWith(SpringRunner.class)
@WebFluxTest(CustomerService.class)
public class CustomerServiceTest {

	@MockBean
	CustomerService service;
		
	@Test
	public void when_saveCustomerPersonal_ok() {
		
		Mono<CustomerPersonal> customPerson = Mono.just(new CustomerPersonal(null, null, null, 0, 0, null, null, null));
		
		when(service.saveCustomerPersonal(customPerson)).thenReturn(customPerson);
		
		StepVerifier.create(customPerson)
		.expectSubscription()
		.expectNext(new CustomerPersonal(null, null, null, 0, 0, null, null, null))
		.verifyComplete();
		

	}
	
	@Test
	public void when_saveCustomerBusiness_ok() {

		Mono<CustomerBusiness> customer =Mono.just(new CustomerBusiness(null, null, null, 0, 0, null));

		when(service.saveCustomerBusiness(customer)).thenReturn(customer);
		

		StepVerifier.create(customer)
		.expectSubscription()
		.expectNext(new CustomerBusiness(null, null, null, 0, 0, null))
		.verifyComplete();
	
	}
	
	@Test
    public void when_getCustomerPersonalBydni(){
		Mono<CustomerPersonal> customer = Mono.just(new CustomerPersonal(null, null, null, 456, 0, null, null, null));

		when(service.getCustomerByDni(456)).thenReturn(customer);
		
		StepVerifier.create(customer)
		.expectSubscription()
		.expectNext(new CustomerPersonal(null, null, null, 456, 0, null, null, null))
		.verifyComplete();
		
    }
}
