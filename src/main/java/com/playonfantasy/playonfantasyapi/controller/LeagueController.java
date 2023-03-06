package com.playonfantasy.playonfantasyapi.controller;

import com.playonfantasy.playonfantasyapi.model.*;
import com.playonfantasy.playonfantasyapi.service.AccountService;
import com.playonfantasy.playonfantasyapi.service.LeagueService;
import com.playonfantasy.playonfantasyapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//TODO: refactor
@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TeamService teamService;

    @PostMapping("")
    public ResponseEntity<League> create(@RequestBody Account account) {

        try {
            League league = leagueService.create(account);

            if (league != null) {
                return new ResponseEntity<>(league, HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestHeader(value="id") int accountId, @RequestBody League league) {
        try {
            League l = leagueService.getLeagueByCode(league.getCode());

            if (!teamService.verifyAccountInLeague(accountId, l.getId())) {
                leagueService.addTeam(accountService.getAccount(accountId), l, false);

                return new ResponseEntity<>(null, HttpStatus.OK);
            }

            return new ResponseEntity<>("account already has a team in league", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>("invalid code", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<League> get(@RequestParam int leagueId) {
        League l = leagueService.getLeagueById(leagueId);

        if (l != null) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("")
    public ResponseEntity<League> updateName(@RequestHeader(value="id") int accountId, @RequestBody League league) {

        if (teamService.verifyAccountAndLeagueAccess(accountId, league.getId())) {

            League l = leagueService.updateLeague(league);

            if (l != null) {
                return new ResponseEntity<>(l, HttpStatus.OK);
            }
        }


        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("")
    public String delete(@RequestParam int leagueId) {
        leagueService.deleteLeague(leagueId);
        return "League has been deleted";
    }

    @GetMapping("/account")
    public ResponseEntity<List<League>> getLeaguesByAccountId(@RequestParam int id) {
        List<League> leagueList = leagueService.getLeagues(id);
        if (leagueList != null) {
            return new ResponseEntity<>(leagueList ,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
