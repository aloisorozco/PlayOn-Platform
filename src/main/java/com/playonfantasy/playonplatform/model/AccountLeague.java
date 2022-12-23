package com.playonfantasy.playonplatform.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Entity;

public class AccountLeague {

    private String username;

    private String leagueCode;

    private int leagueId;

    public AccountLeague() {
    }

    @Getter
    public String getUsername() {
        return username;
    }

    @Setter
    public void setUsername(String username) {
        this.username = username;
    }

    @Getter
    public String getLeagueCode() {
        return leagueCode;
    }

    @Setter
    public void setLeagueCode(String leagueCode) {
        this.leagueCode = leagueCode;
    }

    @Getter
    public int getLeagueId() {
        return leagueId;
    }

    @Setter
    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
}
