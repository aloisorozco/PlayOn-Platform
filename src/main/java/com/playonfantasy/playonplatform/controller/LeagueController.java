package com.playonfantasy.playonplatform.controller;

import com.playonfantasy.playonplatform.model.*;
import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;
import com.playonfantasy.playonplatform.service.AccountService;
import com.playonfantasy.playonplatform.service.LeagueService;
import com.playonfantasy.playonplatform.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private AccountService accountService;

    //should prolly be post mapping
    @PostMapping("/createLeague")
    public ResponseEntity<LeagueTeam> createLeague(@RequestBody AccountLeague accountLeague) {
        Account account = accountService.getAccount(accountLeague.getUsername());
        League league = leagueService.createLeague();
        Team team = teamService.createTeam(account, league);

        LeagueTeam leagueTeam = new LeagueTeam();
        leagueTeam.setLeagueId(league.getId());
        leagueTeam.setTeamId(team.getId());

        return new ResponseEntity<>(leagueTeam, HttpStatus.OK);
    }

    @PutMapping("/updateName")
    public ResponseEntity<League> updateName(@RequestBody League league) {
        league = leagueService.updateLeague(league);

        return new ResponseEntity<>(league, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLeague")
    public String deleteLeague(@RequestParam int leagueId) {
        leagueService.deleteLeague(leagueId);
        return "League has been deleted";
    }

    @GetMapping("/getLeagues")
    public ResponseEntity<List<League>> getLeagues(@RequestParam String username) {
        List<League> leagueList = leagueService.getLeagues(accountService.getIdFromUsername(username));
        if (leagueList != null) {
            return new ResponseEntity<>(leagueList ,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
