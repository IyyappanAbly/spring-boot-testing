package com.cd.testing.mapper;

import com.cd.testing.entity.Employee;
import com.cd.testing.response.EmployeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    EmployeeResponse getResponse(Employee employee);
}
