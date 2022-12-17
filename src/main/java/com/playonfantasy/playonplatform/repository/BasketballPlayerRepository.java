package com.playonfantasy.playonplatform.repository;

import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;
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

    public List<BasketballPlayer> findByName(@RequestParam(name = "name") String name);

}
