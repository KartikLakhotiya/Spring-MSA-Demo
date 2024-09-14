package com.example.demo.endpoint;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {

    EmployeeService svc1;

    @GetMapping(path="/demo/data")
    EmployeeDTO getData(@RequestParam("name") String name, @RequestParam("ID") int ID){
        return svc1.getData(name);
    }

    @GetMapping(path="/demo/data/ID")
    EmployeeDTO getData(@RequestParam("ID") int ID){
        return svc1.getData(ID);
    }

    @PostMapping(path="/demo/data",produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDTO postData(@RequestBody EmployeeDTO employee){
        return svc1.postData(employee);
    }

    @Autowired
    TestController(EmployeeService svc){
        svc1 = svc;
    }

//    @GetMapping(path="/demo/data")
//    String getData1(){
//        return new ResponseEntity<String>("gg", HttpStatus.OK);
//    }
}
