package com.example.jhiro.game_leaderboard.enigma.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponse<T> {
	private Integer statusCode;
	private String message;
	private T data;
	private PagingResponse paging;
}
