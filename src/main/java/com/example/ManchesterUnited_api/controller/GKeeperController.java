package com.example.ManchesterUnited_api.controller;
import com.example.ManchesterUnited_api.models.GoalKeeper;
import com.example.ManchesterUnited_api.repository.GkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/goalkeepers")
public class GKeeperController {
    @Autowired
    private GkRepo gkRepo;

    @GetMapping
    private ResponseEntity<List<GoalKeeper>> listGoalkeepers(){
        return new ResponseEntity<List<GoalKeeper>>(gkRepo.findAll(), HttpStatus.FOUND);
    }
    @PostMapping("add")
    private ResponseEntity<GoalKeeper> addGoalKeepers(@RequestBody GoalKeeper goalKeeper){
        return new ResponseEntity<GoalKeeper>(gkRepo.save(goalKeeper), HttpStatus.CREATED);
    }

}
