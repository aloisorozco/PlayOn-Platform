package com.playonfantasy.playonplatform.controller;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.AccountLeague;
import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.model.Team;
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
    private LeagueService leagueService;

    //check to make sure that int works and doesnt need to be string
    @GetMapping("/getTeamsInLeague")
    public List<Team> getTeamsInLeague(@RequestParam int leagueId) {
        League league = leagueService.getLeagueById(leagueId);
        if (league != null) {
            return league.getTeams();
        }
        return null;
    }

    @GetMapping("/getTeamsFromAccount")
    public List<Team> getTeamsFromAccount(@RequestParam int accountId) {

        return teamService.getTeamsFromAccount(accountId);
    }

    //need new model; TEST that AccountLeague works
    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(AccountLeague accountleague) {
        Team team = teamService.createTeam(accountleague.getAccount(),
                leagueService.getLeagueById(accountleague.getLeagueId()));
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Team> editTeam(@RequestBody Team team) {
        team = teamService.updateTeam(team);

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/removeTeam")
    public String removeTeam(@RequestParam int teamId) {
        teamService.deleteTeam(teamId);
        return "League has been deleted";
    }
}
