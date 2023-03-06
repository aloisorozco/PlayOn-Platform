package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;
import com.playonfantasy.playonfantasyapi.model.League;
import com.playonfantasy.playonfantasyapi.model.Team;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface LeagueService {

    public League createLeague();

    public League updateLeague(League league);

    public void deleteLeague(int leagueId);

    public League getLeagueById(int leagueId);

    public League getLeagueByCode(String leagueCode);

    public List<League> getLeagues(int accountId);

    public League create(Account account) throws ChangeSetPersister.NotFoundException;

    public void addTeam(Account account, League league, boolean isManager);

}
