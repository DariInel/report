package com.example.report.service.impl;

import com.example.report.entity.Player;
import com.example.report.repository.PlayerRepository;
import com.example.report.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Функция для вывода 20 самых продолжительных карьер в виде словаря 'id записи игрока: продолжительность карьеры'
     * @param players - лист записей всех игроков
     * @return словарь 'id записи игрока: продолжительность карьеры'
     */
    public Map<Long, Integer> getIdLongCareers(List<Player> players){
        Map<Long, Integer> careers = new LinkedHashMap<>();

        // Формируем словарь 'id игрока: продолжительность карьеры'
        for(Player player : players){
            careers.put(player.getId(), player.getToYear() - player.getFromYear());
        }
        List<Map.Entry<Long, Integer>> list = new ArrayList<>(careers.entrySet());

        //Сортируем словарь
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        LinkedHashMap<Long, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Long, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        careers.clear();

        //Берем 20 первых карьер по убыванию
        int count = 20;
        for(var pair : sortedMap.entrySet()){
            if(count == 0)
                break;
            careers.put(pair.getKey(), pair.getValue());
            count--;
        }
        return careers;
    }

    @Override
    public Player findPlayerById(Long id) {
        return playerRepository.findPlayerById(id);
    }

    /**
     * Функция для вывода количества игроков в командах в виде словаря 'название команды: кол-во игроков'
     * @param players - лист записей всех игроков
     * @return словарь 'название команды: кол-во игроков'
     */
    public Map<String, Integer> getCountPlayersInTeams(List<Player> players){
        Map<String, Integer> countPlayers = new HashMap<>();
        for(Player player : players){
            if(player.getTeamName() != null) {
                if (countPlayers.containsKey(player.getTeamName())){
                    countPlayers.put(player.getTeamName(), countPlayers.get(player.getTeamName())+ 1);
                }
                else{
                    countPlayers.put(player.getTeamName(), 1);
                }
            }
        }
        return countPlayers;
    }
}
