package com.example.report.service;

import com.example.report.entity.Player;

import java.util.List;
import java.util.Map;

public interface PlayerService {
    List<Player> getAllPlayers();

    Map<Long, Integer> getIdLongCareers(List<Player> players);

    Player findPlayerById(Long id);

    Map<String, Integer> getCountPlayersInTeams(List<Player> players);
}
