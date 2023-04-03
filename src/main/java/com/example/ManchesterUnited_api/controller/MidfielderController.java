package com.example.ManchesterUnited_api.controller;
import com.example.ManchesterUnited_api.models.Midfielder;
import com.example.ManchesterUnited_api.repository.MidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/midfielder")
public class MidfielderController {
    @Autowired
    private MidRepo midRepo;

    @GetMapping
    private ResponseEntity<List<Midfielder>> listMidfielders(){
        return new ResponseEntity<List<Midfielder>>(midRepo.findAll(), HttpStatus.FOUND);
    }
    @PostMapping("add")
    private ResponseEntity<Midfielder> addMidfielder(@RequestBody Midfielder midfielder){
        return new ResponseEntity<Midfielder>(midRepo.save(midfielder), HttpStatus.CREATED);
    }
}
