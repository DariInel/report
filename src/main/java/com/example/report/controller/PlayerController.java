package com.example.report.controller;

import com.example.report.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.StringWriter;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    /**
     * Функция для обработки запроса на вывод 20 самых продолжительных карьер в порядке убывания
     * @return JSON с результатом 'id записи : продолжительность карьеры' и статус
     */
    @GetMapping("/careers")
    public  ResponseEntity<String> getTopCareers() throws Exception {
        Map<Long, Integer> result = playerService.getIdLongCareers(playerService.getAllPlayers());
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, result);
        return new ResponseEntity<>(writer.toString(), HttpStatus.OK);
    }

    /**
     * Функция для обработки запроса на вывод кол-ва игроков в каждой команде
     * @return JSON с результатом 'название команды: кол-во игроков' и статус
     */
    @GetMapping("/teams")
    public  ResponseEntity<String> getCountPlayersInTeams() throws Exception {
        Map<String, Integer> result = playerService.getCountPlayersInTeams(playerService.getAllPlayers());
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, result);
        return new ResponseEntity<>(writer.toString(), HttpStatus.OK);
    }
}
