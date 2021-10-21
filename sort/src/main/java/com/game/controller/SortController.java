package com.game.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.bean.GameDetails;
import com.game.config.ConfigProperties;
import com.game.service.SortGames;



@RestController
public class SortController {
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	SortGames sortGames;
	
	@Autowired
	ConfigProperties configProperties;

	/**
	 * This method gets the json file sorts the records.
	 * For testing purpose the Json input is read from file path. 
	 * In Real time it can be accessed from different APIs and the Entity response 
	 * will be further used for processing.
	 * @return
	 */
	@GetMapping("/sortgames")
    public List<GameDetails> sortGames() {
      File file = Paths.get(configProperties.getFilepath()).toFile();
      List<GameDetails> gameList = new ArrayList<GameDetails>();
      List<GameDetails> sortedList = new ArrayList<GameDetails>();
	try {
		gameList = mapper.readValue(file, 
					new TypeReference<List<GameDetails>>() {} );
		sortedList = sortGames.getSortedList(gameList);
	} catch (JsonParseException e) {
		e.getMessage();
	} catch (JsonMappingException e) {
		e.getMessage();
	} catch (IOException e) {
		e.getMessage();
	} catch (ParseException e) {
		e.getMessage();
	} catch (Exception e) {
		e.getMessage();
	}
      return sortedList;
    }
	
	/**
	 * This method displays the input Json file
	 * @return
	 */
	@GetMapping("/displayinput")
    public List<GameDetails> displayInputFile() {
		List<GameDetails> gameList = new ArrayList<GameDetails>();
		File file = Paths.get(configProperties.getFilepath()).toFile();
		try {
			gameList = mapper.readValue(file, 
						new TypeReference<List<GameDetails>>() {} );
		} catch (Exception e) {
			e.getMessage();
		}
		return gameList;
	}
}
