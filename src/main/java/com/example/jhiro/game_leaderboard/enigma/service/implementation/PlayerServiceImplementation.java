package com.example.jhiro.game_leaderboard.enigma.service.implementation;

import com.example.jhiro.game_leaderboard.enigma.dto.request.PlayerRequest;
import com.example.jhiro.game_leaderboard.enigma.dto.response.PlayerResponse;
import com.example.jhiro.game_leaderboard.enigma.entity.Player;
import com.example.jhiro.game_leaderboard.enigma.repository.PlayerRepository;
import com.example.jhiro.game_leaderboard.enigma.service.PlayerService;
import com.example.jhiro.game_leaderboard.enigma.utils.CommonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerServiceImplementation implements PlayerService {

	private final PlayerRepository playerRepository;

	@Override
	public List<PlayerResponse> getAllData(String name) {
		if(name != null){
			Player playerByName = findPlayerByName(name);
			List<Player> players = new ArrayList<>();
			players.add(playerByName);
			return players.stream().map(
					detail -> PlayerResponse.builder()
							.username(detail.getUsername())
							.date(detail.getDate())
							.build()
			).toList();
		}
		List<Player> allPlayer = playerRepository.findAllPlayer();
		return allPlayer.stream().map(
				detail -> PlayerResponse.builder()
						.username(detail.getUsername())
						.date(detail.getDate())
						.build()
		).toList();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public PlayerResponse createPlayer(PlayerRequest playerRequest) {
		Date date = new Date();
		Player byName = playerRepository.saveAndFlush(Player.builder()
				.username(playerRequest.getUsername())
				.date(new Date())
				.build());
		return PlayerResponse.builder()
				.username(byName.getUsername())
				.date(byName.getDate())
				.build();
	}

	@Override
	public Player findPlayerById(Integer id) {
		return playerRepository.findByIdPlayer(id).orElseThrow(() -> new RuntimeException("not found"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public PlayerResponse updatePlayer(Player player) {
		Player playerById = findPlayerById(player.getId());
		playerById.setUsername(player.getUsername());
		playerRepository.saveAndFlush(playerById);
		return PlayerResponse.builder()
				.username(playerById.getUsername())
				.date(new Date())
				.build();
	}

	@Override
	public Player findPlayerByName(String name) {
		return playerRepository.findByName(name).orElseThrow(() -> new RuntimeException("not found"));
	}
}
