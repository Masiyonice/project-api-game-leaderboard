package com.example.jhiro.game_leaderboard.enigma.repository;

import com.example.jhiro.game_leaderboard.enigma.constant.StageOption;
import com.example.jhiro.game_leaderboard.enigma.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StageRepository extends JpaRepository<Stage, Integer> {


	Optional<Stage> findByStageOption(StageOption stageOption);

	@Query(value= "SELECT * FROM stage", nativeQuery = true)
	List<Stage> findAllStage();
}
