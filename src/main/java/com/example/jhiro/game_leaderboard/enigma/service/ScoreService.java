package com.example.jhiro.game_leaderboard.enigma.service;

import com.example.jhiro.game_leaderboard.enigma.dto.request.ScoreRequest;
import com.example.jhiro.game_leaderboard.enigma.dto.response.ScoreResponse;

import java.util.List;

public interface ScoreService {
	ScoreResponse createScore(ScoreRequest scoreRequest);
	List<ScoreResponse> getAllData();
	List<ScoreResponse> getScoreByName(String name);
}
