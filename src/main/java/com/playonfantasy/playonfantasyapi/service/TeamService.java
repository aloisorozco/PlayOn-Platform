package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;
import com.playonfantasy.playonfantasyapi.model.League;
import com.playonfantasy.playonfantasyapi.model.Team;

import java.util.List;

public interface TeamService {

    public Team createTeam(Account account, League league);

    public void deleteTeam(int teamId);

    public Team updateTeam(Team team);

    public List<Team> getTeamsFromAccount(int accountId);

    public Team getTeam(int teamId);

    public Team getTeam(int accountId, int leagueId);

    public boolean verifyTeamAndAccountAccess(int accountId, int teamId);

    public void setPlayersForTeams(List<Team> teams);

    public int getLeagueId(int teamId);
}
