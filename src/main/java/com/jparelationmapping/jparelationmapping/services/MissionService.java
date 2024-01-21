package com.jparelationmapping.jparelationmapping.services;

import com.jparelationmapping.jparelationmapping.controller.EmployeeController;
import com.jparelationmapping.jparelationmapping.entities.Employee;
import com.jparelationmapping.jparelationmapping.entities.Mission;
import com.jparelationmapping.jparelationmapping.enums.TypeEmployee;
import com.jparelationmapping.jparelationmapping.repositories.EmployeeRepo;
import com.jparelationmapping.jparelationmapping.repositories.MissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MissionService {

    @Autowired
    private MissionRepo missionRepo;
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private EmployeeRepo employeeRepo;


    public Mission addMission(Mission mission,Long imEmp) {

     Optional<Employee>  manager= employeeRepo.findById(imEmp);
     if (manager.isPresent() && manager.get().getTypeEmployee().equals(TypeEmployee.Manager) ){

         return missionRepo.save(mission);}
    else {
        throw new IllegalArgumentException("Only managers can save missions.");
    }

    }

    public List<Mission> getAllMissions(){
        return  missionRepo.findAll();
    }

    public ResponseEntity<String>  assignMissionToEmployee(Long empId,List<Long> missIds){
        Optional<Employee> employee = employeeRepo.findById(empId);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            // Retrieve missions by their IDs
            List<Mission> missions = missionRepo.findAllById(missIds);

            // Assign missions to the employee
            emp.setMissions(missions);

            employeeRepo.save(emp);

            return ResponseEntity.ok("Missions assigned successfully");
        }
       else {
        return ResponseEntity.badRequest().body("Employee not found");
      }




    }


}
