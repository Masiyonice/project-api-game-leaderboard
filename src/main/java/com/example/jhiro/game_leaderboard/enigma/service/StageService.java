package com.example.jhiro.game_leaderboard.enigma.service;

import com.example.jhiro.game_leaderboard.enigma.constant.StageOption;
import com.example.jhiro.game_leaderboard.enigma.dto.request.StageRequest;
import com.example.jhiro.game_leaderboard.enigma.entity.Stage;

import java.util.List;

public interface StageService {
	public Stage getOrSave(StageRequest stageRequest);
	public List<Stage> getAllStage();
	public Stage getById(Integer id);
	public Stage getByStage(StageOption stageOption);
}
