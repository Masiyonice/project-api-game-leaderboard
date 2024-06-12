package com.example.jhiro.game_leaderboard.enigma.service.implementation;

import com.example.jhiro.game_leaderboard.enigma.constant.StageOption;
import com.example.jhiro.game_leaderboard.enigma.dto.request.StageRequest;
import com.example.jhiro.game_leaderboard.enigma.entity.Stage;
import com.example.jhiro.game_leaderboard.enigma.repository.StageRepository;
import com.example.jhiro.game_leaderboard.enigma.service.StageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StageServiceImplementation implements StageService {

	private final StageRepository stageRepository;

	@Override
	public Stage getOrSave(StageRequest stageRequest) {
		return stageRepository.findByStageOption(stageRequest.getStageOption()).orElseGet(
				() -> stageRepository.saveAndFlush(
						  Stage.builder().stageOption(stageRequest.getStageOption()).build()
				)
		);
	}

	@Override
	public List<Stage> getAllStage() {
		return stageRepository.findAllStage();
	}

	@Override
	public Stage getById(Integer id) {
		return stageRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
	}

	@Override
	public Stage getByStage(StageOption stageOption) {
		return stageRepository.findByStageOption(stageOption).orElseThrow(() -> new RuntimeException("not"));
	}
}
