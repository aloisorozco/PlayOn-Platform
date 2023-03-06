package com.playonfantasy.playonfantasyapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="leagues")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="league")
    @JsonManagedReference(value="league-team")
    private List<Team> teams;

    @OneToMany(mappedBy = "league")
    @JsonManagedReference(value = "league-player")
    private List<BasketballPlayer> players;

    private String name;

    private String code;

}
