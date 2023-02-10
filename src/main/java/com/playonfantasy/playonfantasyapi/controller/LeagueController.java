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
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private AccountService accountService;

    //just need league info for now
    @PostMapping("/")
    public ResponseEntity<League> create(@RequestBody Account account) {

        League league = leagueService.create(account);

        if (league != null) {
            return new ResponseEntity<>(league, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/")
    public ResponseEntity<League> get(@RequestParam int leagueId) {
        League l = leagueService.getLeagueById(leagueId);

        if (l != null) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<League> update(@RequestBody League league) {
        League l = leagueService.updateLeague(league);

        if (l != null) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/")
    public String delete(@RequestParam int leagueId) {
        leagueService.deleteLeague(leagueId);
        return "League has been deleted";
    }

    @GetMapping("/account")
    public ResponseEntity<List<League>> getByUsername(@RequestParam String username) {
        List<League> leagueList = leagueService.getLeagues(accountService.getIdFromUsername(username));
        if (leagueList != null) {
            return new ResponseEntity<>(leagueList ,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //TODO: getLeaguesByAccount
}
