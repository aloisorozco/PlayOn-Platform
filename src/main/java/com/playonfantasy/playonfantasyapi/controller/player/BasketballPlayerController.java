package com.playonfantasy.playonfantasyapi.controller.player;

import com.playonfantasy.playonfantasyapi.model.League;
import com.playonfantasy.playonfantasyapi.model.Team;
import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;
import com.playonfantasy.playonfantasyapi.service.TeamService;
import com.playonfantasy.playonfantasyapi.service.player.BasketballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: refactor
@RestController
@RequestMapping("/basketballplayer")
public class BasketballPlayerController {

    @Autowired
    private BasketballPlayerService bballPlayerService;

    @Autowired
    private TeamService teamService;

    /**
     * Gets ONE bball player by name
     * @param name
     * @return BasketballPlayer
     */
    @GetMapping("/")
    public ResponseEntity<BasketballPlayer> get(@RequestParam(name = "name") String name) {
        return new ResponseEntity(bballPlayerService.findByName(name), HttpStatus.OK);
    }

    /**
     * Get the league by teamId
     * @param teamId
     * @return BasketballPlayerList
     */
    @GetMapping("/team")
    public ResponseEntity<List<BasketballPlayer>> getByTeamId(@RequestParam int teamId) {
        Team team = teamService.getTeam(teamId);
        if (team != null) {
            return new ResponseEntity<>(team.getPlayers(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //TODO: refactor
    //should not be here should be in team controller
    /*@PostMapping("/league")
    public ResponseEntity<List<BasketballPlayer>> postSearch(@RequestBody League league) {
        Team team = teamService.getTeam(accountService.getIdFromUsername(accountLeague.getUsername()), accountLeague.getLeagueId());
        if (team != null) {
            return new ResponseEntity<>(bballPlayerService.getPlayers(team.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }*/

    public void updateTeamId(){

    }

    public void getOrderedPlayers() {

    }

    public void getPlayerInTeam() {

    }

}
