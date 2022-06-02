package com.bootcamp.reactive.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bootcamp.reactive.entity.CustomerBusiness;
import com.bootcamp.reactive.entity.CustomerPersonal;
import com.bootcamp.reactive.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@RunWith(SpringRunner.class)
@WebFluxTest(CustomerController.class)
public class CustomerControllerTest {

		@MockBean
		CustomerService service;
		
		@Autowired
		WebTestClient webClient;
		
		@Test
		public void when_saveCustomerPersonal_ok() {
			
			Mono<CustomerPersonal> customPerson = Mono.just(new CustomerPersonal(null, null, null, 0, 0, null, null, null));
			
			when(service.saveCustomerPersonal(customPerson)).thenReturn(customPerson);
			webClient.post().uri("/customer/personal")
			.body(Mono.just(customPerson), CustomerPersonal.class)
			.exchange()
			.expectStatus().isOk();
			

		}
		
		@Test
		public void when_saveCustomerBusiness_ok() {

			Mono<CustomerBusiness> customer =Mono.just(new CustomerBusiness(null, null, null, 0, 0, null));

			when(service.saveCustomerBusiness(customer)).thenReturn(customer);
			webClient.post().uri("/customer/business")
			.body(Mono.just(customer), CustomerBusiness.class)
			.exchange()
			.expectStatus().isOk();
			
		}
		
		@Test
	    public void when_getCustomerPersonalBydni(){
			Mono<CustomerPersonal> customer = Mono.just(new CustomerPersonal(null, null, null, 456, 0, null, null, null));

			when(service.getCustomerByDni(456)).thenReturn(customer);
			
			Flux<CustomerPersonal> responseBody = webClient.get().uri("/customer/personal/456")
			.exchange()
			.expectStatus().isOk()
			.returnResult(CustomerPersonal.class)
			.getResponseBody();
			
			StepVerifier.create(responseBody)
			.expectSubscription()
			.expectNext(new CustomerPersonal(null, null, null, 456, 0, null, null, null))
			.verifyComplete();
			
			
	    }
	

}
