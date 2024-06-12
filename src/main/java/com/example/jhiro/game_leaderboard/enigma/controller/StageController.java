package com.example.jhiro.game_leaderboard.enigma.controller;

import com.example.jhiro.game_leaderboard.enigma.constant.ApiUrl;
import com.example.jhiro.game_leaderboard.enigma.dto.request.StageRequest;
import com.example.jhiro.game_leaderboard.enigma.entity.Stage;
import com.example.jhiro.game_leaderboard.enigma.service.StageService;
import com.example.jhiro.game_leaderboard.enigma.utils.CommonResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ApiUrl.STAGE_CONTROLLER)
public class StageController {

	private final StageService stageService;

	@PostMapping
	public ResponseEntity<CommonResponse<Stage>> createStage(@RequestBody StageRequest stageRequest) {
		Stage orSave = stageService.getOrSave(stageRequest);
		CommonResponse<Stage> test = CommonResponse.<Stage>builder()
				.statusCode(HttpStatus.OK.value())
				.message("data create")
				.data(orSave)
				.build();
		return ResponseEntity.ok(test);
	}

	@GetMapping
	public ResponseEntity<CommonResponse<List<Stage>>> getAllData() {
		List<Stage> allStage = stageService.getAllStage();
		CommonResponse<List<Stage>> common = CommonResponse.<List<Stage>>builder()
				.statusCode(HttpStatus.OK.value())
				.message("Get data")
				.data(allStage)
				.build();
		return ResponseEntity.ok(common);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommonResponse<Stage>> getById(@PathVariable Integer id) {
		Stage byId = stageService.getById(id);
		CommonResponse<Stage> common = CommonResponse.<Stage>builder()
				.statusCode(HttpStatus.OK.value())
				.message("Get data")
				.data(byId)
				.build();
		return ResponseEntity.ok(common);
	}
}