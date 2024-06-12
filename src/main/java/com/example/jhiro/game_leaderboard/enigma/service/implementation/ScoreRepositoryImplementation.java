package com.example.jhiro.game_leaderboard.enigma.service.implementation;

import com.example.jhiro.game_leaderboard.enigma.dto.request.ScoreRequest;
import com.example.jhiro.game_leaderboard.enigma.dto.response.ScoreResponse;
import com.example.jhiro.game_leaderboard.enigma.entity.Player;
import com.example.jhiro.game_leaderboard.enigma.entity.Score;
import com.example.jhiro.game_leaderboard.enigma.entity.Stage;
import com.example.jhiro.game_leaderboard.enigma.repository.ScoreRepository;
import com.example.jhiro.game_leaderboard.enigma.service.PlayerService;
import com.example.jhiro.game_leaderboard.enigma.service.ScoreService;
import com.example.jhiro.game_leaderboard.enigma.service.StageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ScoreRepositoryImplementation implements ScoreService {

	private final ScoreRepository scoreRepository;
	private final PlayerService playerService;
	private final StageService stageService;

	@Override
	public ScoreResponse createScore(ScoreRequest scoreRequest) {

		Player playerById = playerService.findPlayerById(scoreRequest.getPlayerId());
		Stage stageById = stageService.getById(scoreRequest.getStageId());

		Score score = scoreRepository.saveAndFlush(
				Score.builder()
						.playerId(playerById)
						.stageId(stageById)
						.score(scoreRequest.getScore())
						.date(new Date())
						.build()
		);
		return ScoreResponse.builder()
				.namePlayer(score.getPlayerId().getUsername())
				.stageOption(score.getStageId().getStageOption())
				.score(score.getScore())
				.date(score.getDate())
				.build();
	}

	@Override
	public List<ScoreResponse> getAllData() {
		return scoreRepository.findAll().stream().map(
				detail -> ScoreResponse.builder()
						.namePlayer(detail.getPlayerId().getUsername())
						.stageOption(detail.getStageId().getStageOption())
						.score(detail.getScore())
						.date(detail.getDate())
						.build()
		).toList();
	}

	@Override
	public List<ScoreResponse> getScoreByName(String name) {
		List<Score> byName = scoreRepository.findByName(name);
		return byName.stream().map(
				detail -> ScoreResponse.builder()
						.namePlayer(detail.getPlayerId().getUsername())
						.stageOption(detail.getStageId().getStageOption())
						.score(detail.getScore())
						.date(detail.getDate())
						.build()
		).toList();
	}
}
