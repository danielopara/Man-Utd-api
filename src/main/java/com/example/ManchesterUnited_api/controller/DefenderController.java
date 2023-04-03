package com.example.ManchesterUnited_api.controller;
import com.example.ManchesterUnited_api.models.Defender;
import com.example.ManchesterUnited_api.repository.DefenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/defenders")
public class DefenderController {
    @Autowired
    private DefenderRepo defenderRepo;

    @GetMapping
    private ResponseEntity<List<Defender>> listDefenders(){
        return new ResponseEntity<List<Defender>>(defenderRepo.findAll(), HttpStatus.FOUND);
    }
    @PostMapping("add")
    private ResponseEntity<Defender> addDefender(@RequestBody Defender defender){
        return new ResponseEntity<Defender>(defenderRepo.save(defender), HttpStatus.CREATED);
    }
}
