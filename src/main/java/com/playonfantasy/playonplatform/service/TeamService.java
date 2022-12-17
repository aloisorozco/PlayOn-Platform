package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.model.Team;

import java.util.List;

public interface TeamService {

    public Team createTeam(Account account, League league);

    public void deleteTeam(int teamId);

    public Team updateTeam(Team team);

    public List<Team> getTeamsFromAccount(int accountId);
}
