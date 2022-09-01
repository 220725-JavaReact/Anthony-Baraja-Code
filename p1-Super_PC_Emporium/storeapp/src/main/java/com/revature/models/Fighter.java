package com.revature.models;

public class Fighter {
	
	private String name;
	private int weight;
	
	public Fighter(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Fighter [name=" + name + ", weight=" + weight + "]";
	}

}