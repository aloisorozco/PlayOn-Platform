package com.playonfantasy.playonfantasyapi.repository;

import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BasketballPlayerRepository extends JpaRepository<BasketballPlayer, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update players p set p.position = :position where p.name = :name", nativeQuery = true)
    public void updatePosition(@Param("name") String name, @Param("position") String position);

    public BasketballPlayer findByName(@RequestParam(name = "name") String name);

    @Query(value = "SELECT * FROM players WHERE team_id=:teamId", nativeQuery = true)
    public List<BasketballPlayer> getPlayers(@Param("teamId") int teamId);

}
