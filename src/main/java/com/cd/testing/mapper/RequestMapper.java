package com.cd.testing.mapper;

import com.cd.testing.entity.Employee;
import com.cd.testing.request.EmployeeRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    Employee getEmployee(EmployeeRequest employeeRequest);

}
