package com.playonfantasy.playonplatform.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="league")
    @JsonManagedReference(value="league-team")
    private List<Team> teams;

    private String name;

    private String code;

    public League() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
