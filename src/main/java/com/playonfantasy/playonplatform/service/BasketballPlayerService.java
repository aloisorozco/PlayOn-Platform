package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.bballplayer.BasketballPlayer;

import java.util.List;

public interface BasketballPlayerService {

    public BasketballPlayer savePlayer(BasketballPlayer player);

    public List<BasketballPlayer> saveAllPlayers(List<BasketballPlayer> playerList);

    public void updatePlayer(BasketballPlayer basketballPlayer);

    public List<BasketballPlayer> findByName(String name);
}
