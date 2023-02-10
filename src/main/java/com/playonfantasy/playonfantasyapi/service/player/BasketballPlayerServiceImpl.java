package com.playonfantasy.playonfantasyapi.service.player;

import com.playonfantasy.playonfantasyapi.model.Team;
import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;
import com.playonfantasy.playonfantasyapi.repository.BasketballPlayerRepository;
import com.playonfantasy.playonfantasyapi.service.TeamService;
import com.playonfantasy.playonfantasyapi.service.player.BasketballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketballPlayerServiceImpl implements BasketballPlayerService {

    @Autowired
    BasketballPlayerRepository bballPlayerRepo;

    @Override
    public BasketballPlayer savePlayer(BasketballPlayer player) {
        return bballPlayerRepo.save(player);
    }
    @Override
    public List<BasketballPlayer> saveAllPlayers(List<BasketballPlayer> playerList) {
        return bballPlayerRepo.saveAll(playerList);
    }

    @Override
    public void updatePlayer(BasketballPlayer basketballPlayer) {
        bballPlayerRepo.updatePosition(basketballPlayer.getName(), basketballPlayer.getPosition());
    }

    @Override
    public BasketballPlayer findByName(String name) {
        return bballPlayerRepo.findByName(name);
    }

    @Override
    public List<BasketballPlayer> getPlayers(int teamId) {
        return bballPlayerRepo.getPlayers(teamId);
    }
}
