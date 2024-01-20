package com.jparelationmapping.jparelationmapping.controller;

import com.jparelationmapping.jparelationmapping.entities.Mission;
import com.jparelationmapping.jparelationmapping.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MissionController {

    @Autowired
    private MissionService missionService;

    @PostMapping("/saveMission/{idemp}")
    public Mission saveMission(@RequestBody Mission mission, @PathVariable Long idemp){
        return this.missionService.addMission(mission,idemp);
    }


}
