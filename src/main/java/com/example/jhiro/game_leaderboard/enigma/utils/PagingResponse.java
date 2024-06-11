package com.example.jhiro.game_leaderboard.enigma.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagingResponse {
	private Integer totalPages;
	private Long totalElements;
	private Integer page;
	private Integer size;
	private Boolean hasNext;
	private Boolean hasPrevious;
}
