package com.example.ManchesterUnited_api.repository;

import com.example.ManchesterUnited_api.models.Forward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForwardRepo extends JpaRepository<Forward , Long> {
}
