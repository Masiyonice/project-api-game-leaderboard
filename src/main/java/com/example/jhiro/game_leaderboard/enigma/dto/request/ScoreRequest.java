package com.example.jhiro.game_leaderboard.enigma.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreRequest {

	private Integer playerId;
	private Integer stageId;
	private Integer score;
}
