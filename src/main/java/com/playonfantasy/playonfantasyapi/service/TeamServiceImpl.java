package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;
import com.playonfantasy.playonfantasyapi.model.League;
import com.playonfantasy.playonfantasyapi.model.Team;
import com.playonfantasy.playonfantasyapi.repository.TeamRepository;
import com.playonfantasy.playonfantasyapi.service.player.BasketballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private BasketballPlayerService bballPlayerService;

    @Override
    public Team createTeam(Account account, League league, boolean isManager) {
        Team team = new Team();
        team.setName(account.getEmail() + "'s team");
        team.setAccount(account);
        team.setLeague(league);
        team.setManager(isManager);

        team = teamRepo.save(team);

        return team;
    }

    @Override
    public void deleteTeam(int teamId) {
        teamRepo.deleteById(teamId);
    }

    //MIGHT NEED FIXING TOO TO NOT RETURN EMPTY LIST OF PLAYERS
    @Override
    public Team updateTeam(Team team) {
        Team t = teamRepo.findById(team.getId()).get();

        t.setName(team.getName());

        return teamRepo.save(t);
    }

    @Override
    public List<Team> getTeamsFromAccount(int accountId) {
        List<Team> teams = teamRepo.findByAccountId(accountId);
        setPlayersForTeams(teams);

        return teams;
    }

    @Override
    public Team getTeam(int teamId) {
        Team team = teamRepo.findById(teamId).get();
        if (team != null) {
            team.setPlayers(bballPlayerService.getPlayers(teamId));
        }

        return team;
    }

    @Override
    public Team getTeam(int accountId, int leagueId) {
        Team team = teamRepo.findByAccountIdAndLeagueId(accountId, leagueId);

        if (team != null) {
            team.setPlayers(bballPlayerService.getPlayers(team.getId()));
        }
        return team;
    }

    @Override
    public boolean verifyTeamAndAccountAccess(int id, int accountId) {
        if (teamRepo.findByIdAndAccountId(id, accountId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void setPlayersForTeams(List<Team> teams) {
        for (Team t: teams) {
            t.setPlayers(bballPlayerService.getPlayers(t.getId()));
        }
    }

    @Override
    public int getLeagueId(int teamId) {
        return teamRepo.getLeagueId(teamId);
    }

    @Override
    public boolean verifyAccountInLeague(int accountId, int id) {
        if (teamRepo.findByAccountIdAndLeagueId(id, accountId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyAccountAndLeagueAccess(int accountId, int id) {
        Team t = teamRepo.findByAccountIdAndLeagueId(id, accountId);
        if (t != null && t.isManager()){
            return true;
        }
        return false;
    }


}
