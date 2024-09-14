package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeModel,Integer> {

    EmployeeModel findByName(String name);
}
