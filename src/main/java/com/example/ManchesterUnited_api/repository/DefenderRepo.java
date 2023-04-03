package com.example.ManchesterUnited_api.repository;

import com.example.ManchesterUnited_api.models.Defender;
import com.example.ManchesterUnited_api.models.Forward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenderRepo extends JpaRepository<Defender, Long> {
}
