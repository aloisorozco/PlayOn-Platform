package com.playonfantasy.playonplatform.model.bballplayer;

import com.playonfantasy.playonplatform.model.League;
import com.playonfantasy.playonplatform.model.Team;

import javax.persistence.*;

@Entity
@Table(name="players")
public class BasketballPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //optional and nullable true since not every player is gna have a fantasy team
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
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

    private InjuryStatus injuryStatus;
    private TeamStatus teamStatus;

    public BasketballPlayer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(Team fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getAvgPoints() {
        return avgPoints;
    }

    public void setAvgPoints(double avgPoints) {
        this.avgPoints = avgPoints;
    }

    public double getAvgRebounds() {
        return avgRebounds;
    }

    public void setAvgRebounds(double avgRebounds) {
        this.avgRebounds = avgRebounds;
    }

    public double getAvgAssists() {
        return avgAssists;
    }

    public void setAvgAssists(double avgAssists) {
        this.avgAssists = avgAssists;
    }

    public double getAvgBlocks() {
        return avgBlocks;
    }

    public void setAvgBlocks(double avgBlocks) {
        this.avgBlocks = avgBlocks;
    }

    public double getAvgSteals() {
        return avgSteals;
    }

    public void setAvgSteals(double avgSteals) {
        this.avgSteals = avgSteals;
    }

    public double getAvgTurnovers() {
        return avgTurnovers;
    }

    public void setAvgTurnovers(double avgTurnovers) {
        this.avgTurnovers = avgTurnovers;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public double getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(double totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public double getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(double totalAssists) {
        this.totalAssists = totalAssists;
    }

    public double getTotalBlocks() {
        return totalBlocks;
    }

    public void setTotalBlocks(double totalBlocks) {
        this.totalBlocks = totalBlocks;
    }

    public double getTotalSteals() {
        return totalSteals;
    }

    public void setTotalSteals(double totalSteals) {
        this.totalSteals = totalSteals;
    }

    public double getTotalTurnovers() {
        return totalTurnovers;
    }

    public void setTotalTurnovers(double totalTurnovers) {
        this.totalTurnovers = totalTurnovers;
    }

    public InjuryStatus getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(InjuryStatus injuryStatus) {
        this.injuryStatus = injuryStatus;
    }

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
