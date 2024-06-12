package com.example.jhiro.game_leaderboard.enigma.service;

import com.example.jhiro.game_leaderboard.enigma.dto.request.PlayerRequest;
import com.example.jhiro.game_leaderboard.enigma.dto.response.PlayerResponse;
import com.example.jhiro.game_leaderboard.enigma.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
	public List<PlayerResponse> getAllData(String name);
	public PlayerResponse createPlayer(PlayerRequest playerRequest);
	public Player findPlayerById(Integer id);
	public PlayerResponse updatePlayer(Player player);
	public Player findPlayerByName(String name);
}
