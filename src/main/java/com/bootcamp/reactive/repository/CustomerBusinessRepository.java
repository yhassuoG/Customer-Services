package com.bootcamp.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.reactive.entity.CustomerBusiness;

@Repository
public interface CustomerBusinessRepository extends ReactiveMongoRepository<CustomerBusiness,String>{

}
