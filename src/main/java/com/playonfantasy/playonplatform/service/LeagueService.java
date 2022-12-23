package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.League;

import java.util.List;

public interface LeagueService {

    public League createLeague();

    public League updateLeague(League league);

    public void deleteLeague(int leagueId);

    public League getLeagueById(int leagueId);

    public League getLeagueByCode(String leagueCode);

    public List<League> getLeagues(int accountId);
}
