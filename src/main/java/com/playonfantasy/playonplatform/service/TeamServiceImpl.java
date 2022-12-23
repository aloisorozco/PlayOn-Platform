package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.model.Team;
import com.playonfantasy.playonplatform.repository.LeagueRepository;
import com.playonfantasy.playonplatform.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepo;

    @Override
    public Team createTeam(Account account, League league) {
        Team team = new Team();
        team.setName(account.getUsername() + "'s team");
        team.setAccount(account);
        team.setLeague(league);

        team = teamRepo.save(team);

        return team;
    }

    @Override
    public void deleteTeam(int teamId) {
        teamRepo.deleteById(teamId);
    }

    @Override
    public Team updateTeam(Team team) {
        Team t = teamRepo.findById(team.getId()).get();

        t.setName(team.getName());

        return teamRepo.save(t);
    }

    @Override
    public List<Team> getTeamsFromAccount(int accountId) {
        return teamRepo.findByAccountId(accountId);
    }

    @Override
    public Team getTeam(int teamId) {
        return teamRepo.findById(teamId).get();
    }

    @Override
    public Team getTeam(int accountId, int leagueId) {
        return teamRepo.findByAccountIdAndLeagueId(accountId, leagueId);
    }

    @Override
    public boolean verifyTeamAndAccountAccess(int id, int accountId) {
        if (teamRepo.findByIdAndAccountId(id, accountId) != null) {
            return true;
        }
        return false;
    }


}
