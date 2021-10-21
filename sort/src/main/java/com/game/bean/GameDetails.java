package com.game.bean;

/**
 * 
 * Service bean Model for input data
 *
 */
public class GameDetails {
	
	private String name;
	private String type;
	private String start;
	
	public GameDetails(String name,String type,String start) {
		this.name = name;
		this.type = type;
		this.start = start;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
	@Override
    public String toString() {
        return "Games [name=" + name 
                + ", type=" + type 
                + ", start=" + start
                + "]";
    }

}
