package com.example.jhiro.game_leaderboard.enigma.controller;

import com.example.jhiro.game_leaderboard.enigma.constant.ApiUrl;
import com.example.jhiro.game_leaderboard.enigma.dto.request.ScoreRequest;
import com.example.jhiro.game_leaderboard.enigma.dto.response.ScoreResponse;
import com.example.jhiro.game_leaderboard.enigma.service.ScoreService;
import com.example.jhiro.game_leaderboard.enigma.utils.CommonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = ApiUrl.SCORE_CONTROLLER)
public class ScoreController {

	private final ScoreService scoreService;

	@GetMapping
	public ResponseEntity<CommonResponse<List<ScoreResponse>>> getAll(){
		List<ScoreResponse> allData = scoreService.getAllData();
		CommonResponse<List<ScoreResponse>> build = CommonResponse.<List<ScoreResponse>>builder()
				.statusCode(HttpStatus.OK.value())
				.message(HttpStatus.OK.toString())
				.data(allData)
				.build();
		return ResponseEntity.ok(build);
	}

	@PostMapping
	public ResponseEntity<CommonResponse<ScoreResponse>> createData(@RequestBody ScoreRequest scoreRequest){
		ScoreResponse score = scoreService.createScore(scoreRequest);
		CommonResponse<ScoreResponse> createScore = CommonResponse.<ScoreResponse>builder()
				.statusCode(HttpStatus.CREATED.value())
				.message("CREATE SCORE")
				.data(score)
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(createScore);
	}

	@GetMapping("/{name}")
	public ResponseEntity<CommonResponse<List<ScoreResponse>>> getByName(@PathVariable String name){
		List<ScoreResponse> scoreByName = scoreService.getScoreByName(name);
		CommonResponse<List<ScoreResponse>> getData = CommonResponse.<List<ScoreResponse>>builder()
				.statusCode(HttpStatus.FOUND.value())
				.message("Get Data")
				.data(scoreByName)
				.build();
		return ResponseEntity.ok(getData);
	}
}
