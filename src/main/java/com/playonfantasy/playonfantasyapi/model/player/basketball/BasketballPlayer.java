package com.playonfantasy.playonfantasyapi.model.player.basketball;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.playonfantasy.playonfantasyapi.model.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketballPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //optional and nullable true since not every player is gna have a fantasy team
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonBackReference(value = "team-player")
    private Team fantasyTeam;

    private String team;
    private String position;

    //season averages
    private double avgPoints;
    private double avgRebounds;
    private double avgAssists;
    private double avgBlocks;
    private double avgSteals;
    private double avgTurnovers;

    //playoff totals
    private double totalPoints;
    private double totalRebounds;
    private double totalAssists;
    private double totalBlocks;
    private double totalSteals;
    private double totalTurnovers;

    private double fPoints;

    private InjuryStatus injuryStatus;
    private TeamStatus teamStatus;

}
