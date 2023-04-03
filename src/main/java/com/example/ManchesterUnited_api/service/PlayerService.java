package com.example.ManchesterUnited_api.service;

import com.example.ManchesterUnited_api.models.Player;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PlayerService {
    List<Player> listAllPlayers();
    List<Player> findByName(String name);
    List<Player> findByPosition(String position);
    List<Player> findByNameContaining(String name);
    List<Player> getPlayerByNameOrPosition(String name, String position);
    Player addPlayer(Player player);
    String deletePlayerById(Long id);
    Player getPlayerById(Long id);
    Player updatePlayer(Player player);
}
