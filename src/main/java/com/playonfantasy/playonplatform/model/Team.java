package com.playonfantasy.playonplatform.model;

import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    @OneToMany(mappedBy="team")
    private List<BasketballPlayer> players;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BasketballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<BasketballPlayer> players) {
        this.players = players;
    }
}
