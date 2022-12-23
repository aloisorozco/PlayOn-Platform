package com.playonfantasy.playonplatform.repository;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
