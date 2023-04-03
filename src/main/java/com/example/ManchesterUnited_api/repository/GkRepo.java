package com.example.ManchesterUnited_api.repository;

import com.example.ManchesterUnited_api.models.GoalKeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GkRepo extends JpaRepository<GoalKeeper, Long> {

}
