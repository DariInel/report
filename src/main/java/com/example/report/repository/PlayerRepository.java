package com.example.report.repository;

import com.example.report.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);
}
