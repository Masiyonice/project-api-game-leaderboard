package com.example.jhiro.game_leaderboard.enigma.entity;

import com.example.jhiro.game_leaderboard.enigma.constant.Dbname;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Dbname.SCORE)
@Builder
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player playerId;
	@ManyToOne
	@JoinColumn(name = "stage_id")
	private Stage stageId;
	@Column(name = "score")
	private Integer score;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private Date date;

}
