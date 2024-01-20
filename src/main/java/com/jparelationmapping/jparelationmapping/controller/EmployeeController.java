package com.jparelationmapping.jparelationmapping.controller;

import com.jparelationmapping.jparelationmapping.entities.Employee;
import com.jparelationmapping.jparelationmapping.entities.Experience;
import com.jparelationmapping.jparelationmapping.enums.TypeEmployee;
import com.jparelationmapping.jparelationmapping.repositories.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("api/")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("saveEmployee")
    public Employee addEmployee(@RequestBody Employee employee){

        log.info("employee created '...' (POST) finished");

        /**
         *  Experience experience = new Experience();
         * experience.setEmployee(employee);
         List<Experience> experienceList = new ArrayList<>();
         experienceList.add(experience);
                 experience.setCompagnie(experience.getCompagnie());
                 experience.setProfession(experience.getProfess(employee);
         **/

        employee.setExperiences(createExperiences(employee, employee.getExperiences()));

        return this.employeeRepo.save(employee);
    }

    private List<Experience> createExperiences(Employee employee, List<Experience> experienceRequests) {
        return experienceRequests.stream()
                .map(request -> newExperience(request, employee))
                .toList();
    }

    private Experience newExperience(Experience request, Employee employee) {
        return Experience.builder()
                .withId(request.getId())
                .withCompagnie(request.getCompagnie())
                .withProfession(request.getProfession())
                .withEmployee(employee)
                .build();
    }

    @GetMapping("getEmployeeId/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){

        Employee employee = employeeRepo.findById(id).orElse(null);

        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @GetMapping("getEmpByType/{type}")
    public List<Employee> getEmpByType(@PathVariable TypeEmployee type){
        return employeeRepo.findByTypeEmployee(type);
    }


    @PutMapping("updateEmp/{id}")
    public Employee updateEmp(@PathVariable Long id, @RequestBody Employee employee){
        employee.setEmployeeId(id);
        return employeeRepo.save(employee);
    }

    @DeleteMapping("deleteEmp/{id}")
    public void deleteEmp(@PathVariable Long id){
        employeeRepo.deleteById(id);
    }
}
