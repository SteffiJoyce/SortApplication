package com.game.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bean.GameDetails;
import com.game.config.ConfigProperties;
import com.game.service.SortGames;
import com.game.util.DateUtil;

@Service
public class SortGamesImpl implements SortGames {
	
	@Autowired
	ConfigProperties configProperties;

	/**
	 * This method sorts input records based on the conditions
	 * First are current days game
	 * Second is big Games (V86 and start time is Wednesday , 
	 * 			V75 and start time is Saturday, GS75 and start time is Sunday)
	 * Then the rest of the games
	 * Special condition for Winter Burst Games based on configurable dates
	 */
	@Override
	public List<GameDetails> getSortedList(List<GameDetails> gameList) 
				throws ParseException {
		List<GameDetails> currentDayList = new ArrayList<GameDetails>();
		List<GameDetails> bigDayList = new ArrayList<GameDetails>();
		List<GameDetails> otherGameList = new ArrayList<GameDetails>();
		List<GameDetails> completeList = new ArrayList<GameDetails>();
		int weekNumber = 0;
		int weekNumberTemp = 0;
		for(GameDetails gameDetails : gameList) {
			weekNumber = DateUtil.getWeekNumber(gameDetails.getStart())	;
			if(weekNumberTemp != 0 && weekNumber != weekNumberTemp) {
				completeList = Stream
						.concat(Stream.concat(Stream.concat(
								completeList.stream(), currentDayList.stream()),
								bigDayList.stream()), otherGameList.stream())
						.collect(Collectors.toList());
				weekNumberTemp = weekNumber;
				currentDayList.clear();
				bigDayList.clear();
				otherGameList.clear();
			}

			if (weekNumberTemp == 0 || weekNumber == weekNumberTemp) {
				if (DateUtil.formatDate(gameDetails.getStart())
						.equals(DateUtil.getCurrentDate())) {
					currentDayList.add(gameDetails);
				} else if (checkBigGame(gameDetails.getType(), 
							DateUtil.getDay(gameDetails.getStart()))
						|| checkWinterBurst(gameDetails.getType(), 
								gameDetails.getStart())) {
					bigDayList.add(gameDetails);
				} else {
					otherGameList.add(gameDetails);
				}
			}
			weekNumberTemp = weekNumber;
		}

		completeList = Stream.concat(
				Stream.concat(Stream.concat(completeList.stream(), 
							currentDayList.stream()), bigDayList.stream()),
							otherGameList.stream()).collect(Collectors.toList());
		return completeList;
	}
	
	/**
	 * Method to read the Big Game criteria from properties and validate 
	 * them against input
	 * @param type
	 * @param day
	 * @return
	 */
	private boolean checkBigGame(String type, String day) {
		return configProperties.getBigGame().containsKey(type) 
					&& configProperties.getBigGame().get(type).contains(day); 
	}
	
	/**
	 * Method to read the Winter Burst criteria from properties 
	 * and validate them against input
	 * @param type
	 * @param day
	 * @return
	 */
	private boolean checkWinterBurst(String type, String inputDate) 
				throws ParseException{
		List<String> winterBurstValues = configProperties.getWinterBurst()
										.get(type); 
		return configProperties.getWinterBurst().containsKey(type) 
				&& (checkIfWinterBurstDate(inputDate, winterBurstValues));
		
	}

	/**
	 * Method to format input date in correspondence with WinterBurst date 
	 * and checks for matching dates.
	 * @param type
	 * @param day
	 * @return
	 */
	private boolean checkIfWinterBurstDate(String inputDate, 
					List<String> winterBurstValues) throws ParseException {
		try {
			Date dt = DateUtil.zoneDateFormat.parse(inputDate);
			String inputDatedFormatted = DateUtil.dateFormat_dd_MM_yyyy.format(dt);
			for(String winterBurstDate:winterBurstValues) {
				if( DateUtil.addYear(winterBurstDate)
						.equalsIgnoreCase(inputDatedFormatted) ) return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ParseException(e.getMessage(),e.hashCode());
		}
		return false;
	}
	
}
