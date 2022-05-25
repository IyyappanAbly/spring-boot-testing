package com.cd.testing.service;

import com.cd.testing.entity.Employee;
import com.cd.testing.mapper.RequestMapper;
import com.cd.testing.mapper.ResponseMapper;
import com.cd.testing.repository.EmployeeRepository;
import com.cd.testing.request.EmployeeRequest;
import com.cd.testing.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ResponseMapper responseMapper;

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){

     Employee employee = requestMapper.getEmployee(employeeRequest);

     Employee generatedEmployee = employeeRepository.save(employee);

     EmployeeResponse response = responseMapper.getResponse(generatedEmployee);

     return response;


    }


    public EmployeeResponse getEmployee(Integer id){
        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse response = responseMapper.getResponse(employee);

        return response;
    }






}
