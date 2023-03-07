
package com.playonfantasy.playonfantasyapi.controller;

import com.playonfantasy.playonfantasyapi.model.*;
import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;
import com.playonfantasy.playonfantasyapi.service.AccountService;
import com.playonfantasy.playonfantasyapi.service.LeagueService;
import com.playonfantasy.playonfantasyapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: refactor
@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    //TODO: check accountId has access to league
    @GetMapping("/league")
    public ResponseEntity<List<Team>> getTeamsByLeagueId(@RequestParam int id) {
        League league = leagueService.getLeagueById(id);
        if (league != null) {
            return new ResponseEntity<>(league.getTeams(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("")
    public ResponseEntity<Team> updateName(@RequestHeader(value="id") int accountId, @RequestBody Team team) {

        if (teamService.verifyTeamAndAccountAccess(accountId, team.getId())) {
            Team t = teamService.updateTeam(team);

            if (t != null) {
                return new ResponseEntity<>(t, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("")
    public ResponseEntity<Team> get(@RequestParam int id) {
        Team team = teamService.getTeam(id);

        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/verifyManager")
    public ResponseEntity<String> verifyManager(@RequestHeader(value="id") int accountId, @RequestParam int id) {
        if (teamService.verifyTeamAndAccountAccess(id, accountId)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}