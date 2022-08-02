package businessLogic;

import java.util.ArrayList;
import java.util.Scanner;

import models.Character;

public class GameLogic {
	
	private ArrayList<Character> smashCharList;// = new ArrayList<Character>();
	
	public GameLogic() {
		
		// Smash Characters Database
		this.smashCharList = new ArrayList<Character>();
		
		this.smashCharList.add(new Character("Bowser", 135));
		this.smashCharList.add(new Character("Terry", 108));
		this.smashCharList.add(new Character("Snake", 106));
		this.smashCharList.add(new Character("Mega Man", 102));
		this.smashCharList.add(new Character("Pac-Man", 95));
	}
	
	public int getSmashCharListSize() {
		return this.smashCharList.size();
	}
	
	public String getCharNameAtIndex(int index) {
		return this.smashCharList.get(index).getName();
	}

	public int userSelectionNumOfPlayers(Scanner sc) {
		
		String playersString = sc.nextLine();
		
		try {
			int numPlayers = Integer.parseInt(playersString);
			
			if(numPlayers > 1 && numPlayers < 9) {
				return numPlayers;
				
			} else {
				System.out.println("Invalid #, try again please.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}

}
