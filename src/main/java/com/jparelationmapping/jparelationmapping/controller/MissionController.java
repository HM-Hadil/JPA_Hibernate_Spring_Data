package com.jparelationmapping.jparelationmapping.controller;

import com.jparelationmapping.jparelationmapping.entities.Mission;
import com.jparelationmapping.jparelationmapping.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MissionController {

    @Autowired
    private MissionService missionService;

    @PostMapping("/saveMission/{idemp}")
    public Mission saveMission(@RequestBody Mission mission, @PathVariable Long idemp){
        return this.missionService.addMission(mission,idemp);
    }

    @GetMapping("/getAllMissions")
    public List<Mission>  getAllMissions(){
        return missionService.getAllMissions();
    }

    @PostMapping("/assignMissionsToEmployee/{idEmp}/{MissIds}")
    public ResponseEntity<String > assignMissionsToEmployee(@PathVariable Long idEmp , @PathVariable List<Long> MissIds){
        return missionService.assignMissionToEmployee(idEmp, MissIds);
    }

}
