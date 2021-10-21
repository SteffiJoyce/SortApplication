package com.game.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.game.bean.GameDetails;

@SpringBootTest
public class SortGamesTest {
	
@Autowired
SortGames sortGames;

@Test
public void testGetSortedList() throws Exception {
	List<GameDetails> sortedList = sortGames.getSortedList(getGameList());
	Assertions.assertEquals(sortedList.size(), getGameList().size());
	
}

@Test
public void testGetSortedList_Winter() throws Exception {
	List<GameDetails> sortedList = sortGames.getSortedList(getWinterGameList());
	Assertions.assertEquals(sortedList.size(), getGameList().size());
	
}

private List<GameDetails> getGameList(){
	List<GameDetails> games = new ArrayList<GameDetails>();
	games.add(new GameDetails("Example Game","V64","2021-10-18T16:30:00"));
	games.add(new GameDetails("Example Game","V64","2021-10-19T16:30:00"));
	games.add(new GameDetails("Example Game","V86","2021-10-20T16:30:00"));
	games.add(new GameDetails("Example Game","V64","2021-10-21T16:30:00"));
	games.add(new GameDetails("Example Game","V86","2021-10-22T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-10-23T16:30:00"));
	games.add(new GameDetails("Example Game","GS75","2021-10-24T16:30:00"));
	
	games.add(new GameDetails("Example Game","V64","2021-10-25T16:30:00"));
	games.add(new GameDetails("Example Game","V64","2021-10-26T16:30:00"));
	games.add(new GameDetails("Example Game","V86","2021-10-27T16:30:00"));
	games.add(new GameDetails("Example Game","V64","2021-10-28T16:30:00"));
	games.add(new GameDetails("Example Game","GS75","2021-10-29T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-10-30T16:30:00"));
	games.add(new GameDetails("Example Game","GS75","2021-10-31T16:30:00"));
	return games;
}

private List<GameDetails> getWinterGameList(){
	List<GameDetails> games = new ArrayList<GameDetails>();
	games.add(new GameDetails("Example Game","V64","2021-12-20T16:30:00"));
	games.add(new GameDetails("Example Game","V64","2021-12-21T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-22T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-23T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-24T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-25T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-26T16:30:00"));
	
	games.add(new GameDetails("Example Game","V75","2021-12-27T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-28T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-29T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-30T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-31T16:30:00"));
	games.add(new GameDetails("Example Game","V75","2021-12-01T16:30:00"));
	games.add(new GameDetails("Example Game","GS75","2021-12-02T16:30:00"));
	return games;
}

}
