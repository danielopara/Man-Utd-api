package com.example.ManchesterUnited_api.controller;
import com.example.ManchesterUnited_api.models.Forward;
import com.example.ManchesterUnited_api.repository.ForwardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/forwards")
public class ForwardController {
    @Autowired
    private ForwardRepo forwardRepo;

    @GetMapping
    private ResponseEntity<List<Forward>> listForwards(){
        return new ResponseEntity<List<Forward>>(forwardRepo.findAll(), HttpStatus.FOUND);
    }
    @PostMapping("add")
    private ResponseEntity<Forward> addForward(@RequestBody Forward forward){
        return new ResponseEntity<Forward>(forwardRepo.save(forward), HttpStatus.CREATED);
    }
}
