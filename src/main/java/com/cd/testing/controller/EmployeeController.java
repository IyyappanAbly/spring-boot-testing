package com.cd.testing.controller;

import com.cd.testing.request.EmployeeRequest;
import com.cd.testing.response.EmployeeResponse;
import com.cd.testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/addEmployee" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest){

        EmployeeResponse response = employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    @GetMapping(value = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> getEmployee(@RequestParam("id") Integer id){
        EmployeeResponse response = employeeService.getEmployee(id);

        MultiValueMap<String, String> map = new HttpHeaders();
        map.add("name","app-server");
        return new ResponseEntity<>(response,map,HttpStatus.OK);
    }


}
