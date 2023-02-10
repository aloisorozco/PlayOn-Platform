package com.playonfantasy.playonfantasyapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "teams", uniqueConstraints={
        @UniqueConstraint(columnNames = {"account_id", "league_id"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    @OneToMany(mappedBy="team")
    @JsonManagedReference(value = "team-player")
    private List<BasketballPlayer> players;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonBackReference(value="account-team")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "league_id", nullable = false)
    @JsonBackReference(value="league-team")
    private League league;

    private double fPoints;
}
