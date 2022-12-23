package com.playonfantasy.playonplatform.model;

import org.springframework.context.annotation.Bean;

public class LeagueTeam {

    private int leagueId;

    private int teamId;

    public LeagueTeam() {
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
