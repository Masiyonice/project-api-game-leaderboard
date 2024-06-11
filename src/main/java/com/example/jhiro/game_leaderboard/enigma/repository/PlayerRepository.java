package com.example.jhiro.game_leaderboard.enigma.repository;

import com.example.jhiro.game_leaderboard.enigma.entity.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Query(value = "SELECT * FROM player",nativeQuery = true)
	List<Player> findAllPlayer();

	@Query(value = "SELECT * FROM player AS p WHERE p.id = ?1", nativeQuery = true)
	Optional<Player> findByIdPlayer(Integer id);

	@Query(value = "SELECT * FROM player AS p WHERE p.username = ?1", nativeQuery = true)
	Optional<Player> findByName(String input);


}
