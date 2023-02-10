package com.playonfantasy.playonfantasyapi.service.player;

import com.playonfantasy.playonfantasyapi.model.Team;
import com.playonfantasy.playonfantasyapi.model.player.basketball.BasketballPlayer;

import java.util.List;

public interface BasketballPlayerService {

    public BasketballPlayer savePlayer(BasketballPlayer player);

    public List<BasketballPlayer> saveAllPlayers(List<BasketballPlayer> playerList);

    public void updatePlayer(BasketballPlayer basketballPlayer);

    public BasketballPlayer findByName(String name);

    public List<BasketballPlayer> getPlayers(int teamId);
}
