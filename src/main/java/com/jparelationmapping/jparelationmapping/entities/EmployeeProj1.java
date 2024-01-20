package com.jparelationmapping.jparelationmapping.entities;

import com.jparelationmapping.jparelationmapping.entities.Employee;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = Employee.class)
public interface EmployeeProj1 {


    public String getEmp_firstName();

}
