package com.example.jhiro.game_leaderboard.enigma.entity;

import com.example.jhiro.game_leaderboard.enigma.constant.Dbname;
import com.example.jhiro.game_leaderboard.enigma.constant.StageOption;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Dbname.STAGE)
@Builder
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stage_generator")
	@SequenceGenerator(name = "stage_generator", sequenceName = "stg_sequence", allocationSize = 1)
	private Integer id;

	@Column(name = "stage")
	@Enumerated(value = EnumType.STRING)
	private StageOption stageOption;
}
