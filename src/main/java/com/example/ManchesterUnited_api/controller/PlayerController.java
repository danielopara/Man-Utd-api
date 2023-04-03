package com.example.ManchesterUnited_api.controller;
import com.example.ManchesterUnited_api.models.Player;
import com.example.ManchesterUnited_api.repository.GkRepo;
import com.example.ManchesterUnited_api.service.PlayerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/manchesterunited")
public class PlayerController {
    @Autowired
    private PlayerLogic playerLogic;
    @Autowired
    private GkRepo gkRepo;
    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;


    @GetMapping("version")
    private String appVersion(){
        return appName + " - " + appVersion;
    }
    @GetMapping("allplayers")
    public ResponseEntity<List<Player>> listAllPlayers(){
        return new ResponseEntity<List<Player>>(playerLogic.listAllPlayers(), HttpStatus.OK);
    }
    @GetMapping("allplayers/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id)
    {
        return new ResponseEntity<Player>(playerLogic.getPlayerById(id), HttpStatus.FOUND);
    }
    @GetMapping("player")
    public ResponseEntity<List<Player>> getPlayerByName(@RequestParam String name){
        return new ResponseEntity<List<Player>>(playerLogic.findByName(name), HttpStatus.FOUND);
    }
    @GetMapping("name")
    public ResponseEntity<List<Player>> getPlayerByNameKeyword(@RequestParam String name){
        return new ResponseEntity<List<Player>>(playerLogic.findByNameContaining(name), HttpStatus.FOUND);
    }
    @GetMapping("playerposition")
    public ResponseEntity<List<Player>> getPlayByPosition(@RequestParam String position){
        return new ResponseEntity<List<Player>>(playerLogic.findByPosition(position), HttpStatus.FOUND);
    }
    @GetMapping("{name}/{position}")
    public ResponseEntity<List<Player>> getPlayerByNameOrPosition(@PathVariable String name, @PathVariable String position){
        return new ResponseEntity<List<Player>>(playerLogic.getPlayerByNameOrPosition(name, position), HttpStatus.OK);
    }
    @PostMapping("addplayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){

        return new ResponseEntity<Player>(playerLogic.addPlayer(player), HttpStatus.OK);
    }
    @DeleteMapping("deleteplayer/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable Long id){

        return new ResponseEntity<String>(playerLogic.deletePlayerById(id), HttpStatus.OK);
    }
    @PutMapping("updateplayer")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player)
    {
        return new ResponseEntity<Player>(playerLogic.updatePlayer(player), HttpStatus.OK );
    }
}
