package com.jparelationmapping.jparelationmapping.repositories;

import com.jparelationmapping.jparelationmapping.entities.Employee;
import com.jparelationmapping.jparelationmapping.enums.TypeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    List<Employee> findByTypeEmployee(TypeEmployee typeEmployee);
}
