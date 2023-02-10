package com.playonfantasy.playonfantasyapi.repository;

import com.playonfantasy.playonfantasyapi.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

    public League findByCode(String code);

    @Query(value = "SELECT * FROM leagues WHERE id=(SELECT league_id FROM teams WHERE account_id=:accountId)", nativeQuery = true)
    public List<League> getLeagues(@Param("accountId") int accountId);
}
