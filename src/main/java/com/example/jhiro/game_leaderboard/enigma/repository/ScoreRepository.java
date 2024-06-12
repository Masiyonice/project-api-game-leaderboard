package com.example.jhiro.game_leaderboard.enigma.repository;

import com.example.jhiro.game_leaderboard.enigma.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, String>{

	@Query(value = "SELECT s.* FROM score AS s JOIN player AS p ON s.player_id = p.id WHERE p.username = ?1", nativeQuery = true)
	List<Score> findByName(String name);
}
