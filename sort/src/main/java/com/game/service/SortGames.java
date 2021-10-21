package com.game.service;

import java.text.ParseException;
import java.util.List;

import com.game.bean.GameDetails;

public interface SortGames {
	
	public List<GameDetails> getSortedList(List<GameDetails> gameList ) 
				throws ParseException;

}
