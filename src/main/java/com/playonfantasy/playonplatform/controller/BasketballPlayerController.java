package com.playonfantasy.playonplatform.controller;

import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.model.Team;
import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;
import com.playonfantasy.playonplatform.repository.BasketballPlayerRepository;
import com.playonfantasy.playonplatform.service.BasketballPlayerService;
import com.playonfantasy.playonplatform.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basketballplayer")
public class BasketballPlayerController {

    @Autowired
    private BasketballPlayerService bballPlayerService;

    @Autowired
    private TeamService teamService;

    //not necessary here but will keep for testing purposes
    @PostMapping("/add")
    public String add(@RequestBody BasketballPlayer player) {
        bballPlayerService.savePlayer(player);
        return player.getName() + " has been added";
    }

    //not necessary
    @PatchMapping("/update")
    public String update(@RequestBody BasketballPlayer player) {
        try{
            //not working
            bballPlayerService.updatePlayer(player);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return player.getName() + " has been updated";
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<BasketballPlayer>> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity(bballPlayerService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<BasketballPlayer>> get(@RequestParam int teamId) {
        Team team = teamService.getTeam(teamId);
        if (team != null) {
            return new ResponseEntity<>(team.getPlayers(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    public void updateTeamId(){

    }

    public void getOrderedPlayers() {

    }

    public void getPlayerInTeam() {

    }

}
