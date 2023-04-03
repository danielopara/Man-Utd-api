package com.example.ManchesterUnited_api.controller;
import com.example.ManchesterUnited_api.models.*;
import com.example.ManchesterUnited_api.repository.DefenderRepo;
import com.example.ManchesterUnited_api.repository.ForwardRepo;
import com.example.ManchesterUnited_api.repository.GkRepo;
import com.example.ManchesterUnited_api.repository.MidRepo;
import com.example.ManchesterUnited_api.service.PlayerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("table/man-utd-players")
public class PlayerUiController {
    @Autowired
    private PlayerLogic playerLogic;
    @Autowired
    private GkRepo gkRepo;
    @Autowired
    private DefenderRepo defenderRepo;
    @Autowired
    private ForwardRepo forwardRepo;
    @Autowired
    private MidRepo midRepo;

    @GetMapping
    private String viewHomePage(Model model, @ModelAttribute String position){
        List<Player> listOfPlayers = playerLogic.listAllPlayers();
        List<GoalKeeper> goalKeepers= gkRepo.findAll();
        List<Defender> defenders= defenderRepo.findAll();
        List<Midfielder> midfielders= midRepo.findAll();
        List<Forward> forwards= forwardRepo.findAll();
        model.addAttribute("gKeepers", goalKeepers);
        model.addAttribute("defenders", defenders);
        model.addAttribute("midfielders", midfielders);
        model.addAttribute("forwards", forwards);
        model.addAttribute("listPlayers", listOfPlayers);

        return "index";
    }
    @GetMapping("search")
    public String position(Model model) {
        List<Player> searchPlayer = playerLogic.listAllPlayers();

        model.addAttribute("searchPlayer", searchPlayer);

        return "search";
    }
    @RequestMapping(path = {"main"})
    public String home(Player player, Model model,  String keyword) {
        if(keyword!=null) {
            List<Player> list = playerLogic.findByNameContaining(keyword);
            model.addAttribute("list", list);
        }else {
            List<Player> list = playerLogic.listAllPlayers();
            model.addAttribute("list", list);}
        return "main";
    }

}
