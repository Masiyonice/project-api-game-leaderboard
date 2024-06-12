package com.example.jhiro.game_leaderboard.enigma.dto.request;

import com.example.jhiro.game_leaderboard.enigma.constant.StageOption;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StageRequest {
	private StageOption stageOption;
}
