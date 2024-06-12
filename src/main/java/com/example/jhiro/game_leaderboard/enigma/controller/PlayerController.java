package com.example.jhiro.game_leaderboard.enigma.controller;

import com.example.jhiro.game_leaderboard.enigma.constant.ApiUrl;
import com.example.jhiro.game_leaderboard.enigma.dto.request.PlayerRequest;
import com.example.jhiro.game_leaderboard.enigma.dto.response.PlayerResponse;
import com.example.jhiro.game_leaderboard.enigma.entity.Player;
import com.example.jhiro.game_leaderboard.enigma.service.PlayerService;
import com.example.jhiro.game_leaderboard.enigma.utils.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ApiUrl.PLAYER_CONTROLLER)
public class PlayerController {
	private final PlayerService playerService;

	@PostMapping
	public ResponseEntity<CommonResponse<PlayerResponse>> createData(@RequestBody PlayerRequest playerRequest){
		PlayerResponse player = playerService.createPlayer(playerRequest);
		CommonResponse<PlayerResponse> createdData = CommonResponse.<PlayerResponse>builder()
				.statusCode(HttpStatus.CREATED.value())
				.message("CREATED DATA")
				.data(player)
				.build();
		return ResponseEntity.ok(createdData);
	}

	@GetMapping
	public ResponseEntity<CommonResponse<List<PlayerResponse>>> getAllData(
			@RequestParam(name = "username", required = false) String name
	){
		List<PlayerResponse> allData = playerService.getAllData(name);
		CommonResponse<List<PlayerResponse>> successGetData = CommonResponse.<List<PlayerResponse>>builder()
				.statusCode(HttpStatus.ACCEPTED.value())
				.message("Success Get data")
				.data(allData)
				.build();
		return ResponseEntity.ok(successGetData);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<CommonResponse<Player>> getById(@PathVariable Integer id){
		Player playerById = playerService.findPlayerById(id);
		CommonResponse<Player> data = CommonResponse.<Player>builder()
				.statusCode(HttpStatus.ACCEPTED.value())
				.message("Success get data")
				.data(playerById)
				.build();
		return ResponseEntity.ok(data);
	}

	@PutMapping
	public ResponseEntity<CommonResponse<PlayerResponse>> updateData(@RequestBody Player player){
		PlayerResponse playerResponse = playerService.updatePlayer(player);
		CommonResponse<PlayerResponse> data = CommonResponse.<PlayerResponse>builder()
				.statusCode(HttpStatus.CREATED.value())
				.message("Updated data")
				.data(playerResponse)
				.build();
		return ResponseEntity.ok(data);
	}
}
