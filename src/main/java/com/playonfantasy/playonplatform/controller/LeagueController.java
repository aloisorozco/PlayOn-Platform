package com.playonfantasy.playonplatform.controller;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;
import com.playonfantasy.playonplatform.service.AccountService;
import com.playonfantasy.playonplatform.service.LeagueService;
import com.playonfantasy.playonplatform.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
    @GetMapping("/createLeague")
    public ResponseEntity<League> createLeague(@RequestParam String username) {
        Account account = accountService.getAccountByUsername(username);
        League league = leagueService.createLeague();
        teamService.createTeam(account, league);
        return new ResponseEntity<>(league, HttpStatus.OK);
    }

    //called after createLeague and on its own too
    @PutMapping("/modifyLeague")
    public ResponseEntity<League> modifyLeague(@RequestBody League league) {
        league = leagueService.updateLeague(league);

        return new ResponseEntity<>(league, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLeague")
    public String deleteLeague(@RequestParam int leagueId) {
        leagueService.deleteLeague(leagueId);
        return "League has been deleted";
    }

    //have to do another way; maybe through team idk
    /*@GetMapping("/getLeagues")
    public ResponseEntity<List<League>> getLeagues(@RequestParam String username) {
        Account accountFromDB = accountService.getAccountByUsername(username);
        List<League> leagueList = leagueService.getLeaguesFromAccount(accountFromDB);
        if (leagueList != null) {
            return new ResponseEntity<>(leagueList ,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }*/
}
