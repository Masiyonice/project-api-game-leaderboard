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
@Builder
@Entity
@Table(name = Dbname.PLAYER)
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "player_gen")
	@SequenceGenerator(name = "player_gen",sequenceName = "player_seq", allocationSize = 1)
	Integer id;

	@Column(name = "username",nullable = false,unique = true)
	String username;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	Date date;
}
