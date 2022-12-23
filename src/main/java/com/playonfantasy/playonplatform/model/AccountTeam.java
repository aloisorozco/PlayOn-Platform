package com.playonfantasy.playonplatform.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class AccountTeam {

    private String username;
    private int teamId;

    @Getter
    public String getUsername() {
        return username;
    }

    @Setter
    public void setUsername(String username) {
        this.username = username;
    }

    @Getter
    public int getTeamId() {
        return teamId;
    }

    @Setter
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
