package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;
import com.playonfantasy.playonfantasyapi.model.League;
import com.playonfantasy.playonfantasyapi.model.Team;
import com.playonfantasy.playonfantasyapi.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueRepository leagueRepo;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TeamService teamService;

    @Override
    public League createLeague() {
        League league = new League();
        league.setName("New League");
        league.setCode(generateCode());

        return leagueRepo.save(league);
    }

    private String generateCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public League updateLeague(League league) {
        League l = leagueRepo.findById(league.getId()).get();

        l.setName(league.getName());

        return leagueRepo.save(l);
    }

    @Override
    public void deleteLeague(int leagueId) {
        leagueRepo.deleteById(leagueId);
    }

    @Override
    public League getLeagueById(int leagueId) {
        return leagueRepo.findById(leagueId).get();
    }

    @Override
    public League getLeagueByCode(String leagueCode) {
        return leagueRepo.findByCode(leagueCode);
    }

    @Override
    public List<League> getLeagues(int accountId) {
        return leagueRepo.getLeagues(accountId);
    }

    @Override
    public League create(Account account) throws ChangeSetPersister.NotFoundException {
        Account a = accountService.getAccount(account.getId());
        League league = createLeague();

        addTeam(a, league, true);

        return league;
    }

    @Override
    public void addTeam(Account account, League league, boolean isManager) {
        Team team = teamService.createTeam(account, league, isManager);

        league.setTeams(Arrays.asList(team));
        leagueRepo.save(league);
    }
}
