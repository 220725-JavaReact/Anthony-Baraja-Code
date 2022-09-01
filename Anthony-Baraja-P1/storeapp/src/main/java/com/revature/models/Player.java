package com.revature.models;

public class Player {
	
	int id;
	String name;
	String favColor;
	
	public Player(int id, String name, String favColor) {
		super();
		this.id = id;
		this.name = name;
		this.favColor = favColor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavColor() {
		return favColor;
	}

	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}

	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", favColor=" + favColor + "]";
	}

}
