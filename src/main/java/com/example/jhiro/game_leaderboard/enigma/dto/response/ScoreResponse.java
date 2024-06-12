package com.example.jhiro.game_leaderboard.enigma.dto.response;

import com.example.jhiro.game_leaderboard.enigma.constant.StageOption;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreResponse {

	private String namePlayer;
	private StageOption stageOption;
	private Integer score;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

}
