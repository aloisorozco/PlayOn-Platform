package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;
import com.playonfantasy.playonplatform.repository.BasketballPlayerRepository;
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
    public List<BasketballPlayer> findByName(String name) {
        return bballPlayerRepo.findByName(name);
    }
}
