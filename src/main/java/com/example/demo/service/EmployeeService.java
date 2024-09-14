package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository repo;


    @Autowired
    EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    public EmployeeDTO getData(String name){

        EmployeeModel model;
        model = repo.findByName(name);
        EmployeeDTO employee = new EmployeeDTO();

        if(model!=null){
            employee.setName(model.getName());
            employee.setEmail(model.getEmail());
            employee.setiD(model.getiD());
        } else{
            model = new EmployeeModel();
        }


        return employee;
    }

    public EmployeeDTO getData(int ID){
        Optional<EmployeeModel> model;
        model = repo.findById(Integer.valueOf(ID));

        EmployeeDTO employee = new EmployeeDTO();

        if(model.isPresent()){
            employee.setName(model.get().getName());
            employee.setEmail(model.get().getEmail());
            employee.setiD(model.get().getiD());
        }

        return employee;
    }

    public EmployeeDTO postData(EmployeeDTO employee){
        EmployeeModel model = new EmployeeModel();
        model.setName(employee.getName());
        model.setEmail(employee.getEmail());
        repo.save(model);

        employee.setiD(model.getiD());
        return employee;
    }
}
