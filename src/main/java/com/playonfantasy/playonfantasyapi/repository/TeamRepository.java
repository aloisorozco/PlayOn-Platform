package com.playonfantasy.playonfantasyapi.repository;

import com.playonfantasy.playonfantasyapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    //gets teams by leagueId
    public List<Team> findByLeagueId(int leagueId);

    public List<Team> findByAccountId(int accountId);

    //gets team by accountId and leagueId
    //have to ensure that there is only one account for a league!!!
    public Team findByAccountIdAndLeagueId(int accountId, int leagueId);

    public Team findByIdAndAccountId(int id, int accountId);

    @Query(value = "SELECT league_id FROM teams WHERE id=:id", nativeQuery = true)
    public int getLeagueId(@Param("id")  int id);
}
