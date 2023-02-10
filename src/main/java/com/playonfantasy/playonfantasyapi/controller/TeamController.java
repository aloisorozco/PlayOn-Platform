/*
package com.playonfantasy.playonfantasyapi.controller;

import com.playonfantasy.playonfantasyapi.model.*;
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
    private TeamService teamService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private LeagueService leagueService;

    @GetMapping("/")
    public ResponseEntity<Team> get(@RequestParam int teamId) {

        try {
            Team team = teamService.getTeam(teamId);

            if (team != null) {
                return new ResponseEntity<>(team, HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //TODO: should not be here
    @GetMapping("/getLeagueId")
    public ResponseEntity<Integer> getLeagueId(@RequestParam int teamId) {

        try {
            int leagueId = teamService.getLeagueId(teamId);

            return new ResponseEntity<>(leagueId, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //TODO: refactor to service layer
    @GetMapping("/league")
    public ResponseEntity<List<Team>> getTeamsByLeague(@RequestParam int leagueId) {
        League league = leagueService.getLeagueById(leagueId);
        if (league != null) {
            teamService.setPlayersForTeams(league.getTeams());
            return new ResponseEntity<>(league.getTeams(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

*/
/*
    //NOT NECESSARY RN I DONT THINK, INSTEAD WE SHOULD GET LEAGUES FOR ACCOUNT
    @GetMapping("/getTeamsFromAccount")
    public ResponseEntity<List<Team>> getTeamsFromAccount(@RequestParam int accountId) {

        return new ResponseEntity<>(teamService.getTeamsFromAccount(accountId), HttpStatus.OK);
    }*//*


    @PostMapping("/searchTeamFromAccountLeague")
    public ResponseEntity<Team> searchTeamFromAccountLeague(@RequestBody AccountLeague accountLeague) {
        Team t = teamService.getTeam(accountService.getIdFromUsername(accountLeague.getUsername()), accountLeague.getLeagueId());

        if (t != null) {
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(@RequestBody Account account) {
        try {
            Team team = teamService.createTeam(accountService.getAccount(account.getUsername()),
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

    */
/*//*
/NOT NECESSARY with spring security
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
    }*//*


    //TODO: test
    @PutMapping("/")
    public ResponseEntity<Team> update(@RequestBody Team team) {
        team = teamService.updateTeam(team);

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    //TODO: return MsgModel class
    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam int teamId) {
        try {
            teamService.deleteTeam(teamId);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error while deleting team", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("League has been deleted", HttpStatus.OK);
    }
}
*/
