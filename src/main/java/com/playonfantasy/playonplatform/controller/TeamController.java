package com.playonfantasy.playonplatform.controller;

import com.playonfantasy.playonplatform.model.*;
import com.playonfantasy.playonplatform.service.AccountService;
import com.playonfantasy.playonplatform.service.LeagueService;
import com.playonfantasy.playonplatform.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private LeagueService leagueService;

    @GetMapping("/getTeamsInLeague")
    public ResponseEntity<List<Team>> getTeamsInLeague(@RequestParam int leagueId) {
        League league = leagueService.getLeagueById(leagueId);
        if (league != null) {
            return new ResponseEntity<>(league.getTeams(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //NOT NECESSARY RN I DONT THINK, INSTEAD WE SHOULD GET LEAGUES FOR ACCOUNT
    @GetMapping("/getTeamsFromAccount")
    public ResponseEntity<List<Team>> getTeamsFromAccount(@RequestParam int accountId) {

        return new ResponseEntity<>(teamService.getTeamsFromAccount(accountId), HttpStatus.OK);
    }

    //!!! TEAM CANT HAVE SAME ACCOUNTID AND LEAGUEID
    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(@RequestBody AccountLeague accountleague) {
        try {
            Team team = teamService.createTeam(accountService.getAccount(accountleague.getUsername()),
                    leagueService.getLeagueByCode(accountleague.getLeagueCode()));
            //!!!!should be another model class that just had id
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //SHOULD BE IN LEAGUECONTROLLER but ill leave here for now
    @PostMapping("/verifyAccessToLeague")
    public ResponseEntity<String> verifyAccessToLeague(@RequestBody AccountLeague accountLeague) {
        try {
            if (teamService.getTeam(accountService.getIdFromUsername(accountLeague.getUsername()), accountLeague.getLeagueId()) != null) {
                return new ResponseEntity<>("valid", HttpStatus.OK);
            }
            return new ResponseEntity<>("invalid", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/verifyAccessToTeam")
    public ResponseEntity<String> verifyAccessToTeam(@RequestBody AccountTeam accountTeam) {
        try {
            if (teamService.verifyTeamAndAccountAccess(accountTeam.getTeamId(), accountService.getIdFromUsername(accountTeam.getUsername()))) {
                return new ResponseEntity<>("valid", HttpStatus.OK);
            }
            return new ResponseEntity<>("invalid", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateName")
    public ResponseEntity<Team> updateName(@RequestBody Team team) {
        team = teamService.updateTeam(team);

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/removeTeam")
    public String removeTeam(@RequestParam int teamId) {
        teamService.deleteTeam(teamId);
        return "League has been deleted";
    }
}
