package com.example.ManchesterUnited_api.service;

import com.example.ManchesterUnited_api.models.Player;
import com.example.ManchesterUnited_api.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerLogic implements PlayerService {
    private Player player;
    @Autowired
    private PlayerRepo playerRepo;
    @Override
    public List<Player> listAllPlayers() {
        Sort sort = Sort.by(Sort.Direction.ASC, "playerKey");
        return playerRepo.findAll(sort);
    }

    @Override
    public List<Player> findByName(String name) {
        return playerRepo.findByName(name);
    }

    @Override
    public List<Player> findByPosition(String position) {
        return playerRepo.findByPosition(position);
    }

    @Override
    public List<Player> findByNameContaining(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        String newName = String.valueOf(name.startsWith(String.valueOf(player)));
        return playerRepo.findByNameContaining(name, sort);
    }

    @Override
    public List<Player> getPlayerByNameOrPosition(String name, String position) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "position");
        return playerRepo.getPlayerByNameOrPosition(name, position, sort);
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public String deletePlayerById(Long id) {
        Optional<Player> deleteById = playerRepo.findById(id);
        if(deleteById.isPresent()){
            playerRepo.delete(deleteById.get());
            return "Player with ID: " + id + " has been deleted";
        } else {
            throw new RuntimeException("Player with ID: "+ id + " does not exist");
        }
    }

    @Override
    public Player getPlayerById(Long id) {
        Optional<Player> findById = playerRepo.findById(id);
        if(findById.isPresent()){
            return findById.get();
        } else {
            throw new RuntimeException("Player with ID: "+ id + " does not exist");
        }
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepo.save(player);
    }
}
