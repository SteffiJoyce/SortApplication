package com.game.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:biggamerules.properties")
@ConfigurationProperties(prefix = "rule")
public class ConfigProperties {

	/**Map for Big Game Criteria **/
	private Map<String,List<String>> bigGame;
	
	/**Map for Winter Criteria **/
	private Map<String,List<String>> winterBurst;
	
	/**Input File Path variable **/
	private String filepath;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Map<String, List<String>> getBigGame() {
		return bigGame;
	}

	public void setBigGame(Map<String, List<String>> bigGame) {
		this.bigGame = bigGame;
	}

	public Map<String, List<String>> getWinterBurst() {
		return winterBurst;
	}

	public void setWinterBurst(Map<String, List<String>> winterBurst) {
		this.winterBurst = winterBurst;
	}


	
}
