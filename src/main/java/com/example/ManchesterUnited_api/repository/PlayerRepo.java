package com.example.ManchesterUnited_api.repository;

import com.example.ManchesterUnited_api.models.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
    List<Player> findByName(String name);

    List<Player> findByPosition(String position);

    List<Player> findByNameContaining(String keyword, Sort sort);

    @Query("FROM Player WHERE name = :name OR position = :position")
    List<Player> getPlayerByNameOrPosition(String name, String position, Sort sort);
}
