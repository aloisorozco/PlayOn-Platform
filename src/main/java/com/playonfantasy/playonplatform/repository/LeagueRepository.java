package com.playonfantasy.playonplatform.repository;

import com.playonfantasy.playonplatform.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {
}
