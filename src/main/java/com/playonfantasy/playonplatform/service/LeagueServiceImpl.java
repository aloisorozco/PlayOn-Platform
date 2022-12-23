package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueRepository leagueRepo;

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
}
