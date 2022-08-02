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
		this.smashCharList.add(new Character("King K. Rool", 133));
		this.smashCharList.add(new Character("Donkey Kong", 127));
		this.smashCharList.add(new Character("King Dedede", 127));
		this.smashCharList.add(new Character("Ganondorf", 118));
		this.smashCharList.add(new Character("Incineroar", 116));
		this.smashCharList.add(new Character("Charizard", 116));
		this.smashCharList.add(new Character("Kazuya", 113));
		this.smashCharList.add(new Character("Piranha Plant", 112));
		this.smashCharList.add(new Character("Bowser Jr.", 108));
		this.smashCharList.add(new Character("Dark Samus", 108));
		this.smashCharList.add(new Character("Terry", 108));
		this.smashCharList.add(new Character("Samus", 108));
		this.smashCharList.add(new Character("Ridley", 107));
		this.smashCharList.add(new Character("Simon", 107));
		this.smashCharList.add(new Character("Richter", 107));
		this.smashCharList.add(new Character("Wario", 107));
		this.smashCharList.add(new Character("Ike", 107));
		this.smashCharList.add(new Character("Banjo & Kazooie", 106));
		this.smashCharList.add(new Character("Snake", 106));
		this.smashCharList.add(new Character("R.O.B.", 106));
		this.smashCharList.add(new Character("Mii Gunner", 104));
		this.smashCharList.add(new Character("Min Min", 104));
		this.smashCharList.add(new Character("Link", 104));
		this.smashCharList.add(new Character("Yoshi", 104));
		this.smashCharList.add(new Character("Captain Falcon", 104));
		this.smashCharList.add(new Character("Ryu", 103));
		this.smashCharList.add(new Character("Ken", 103));
		this.smashCharList.add(new Character("MegaMan", 102));
		this.smashCharList.add(new Character("Hero", 101));
		this.smashCharList.add(new Character("Mii Swordfighter", 100));
		this.smashCharList.add(new Character("Cloude", 100));
		this.smashCharList.add(new Character("Corrin", 98));
		this.smashCharList.add(new Character("Pyra", 98));
		this.smashCharList.add(new Character("Mario", 98));
		this.smashCharList.add(new Character("Dr. Mario", 98));
		this.smashCharList.add(new Character("Shulk", 97));
		this.smashCharList.add(new Character("Byleth", 97));
		this.smashCharList.add(new Character("Luigi", 97));
		this.smashCharList.add(new Character("Pit", 96));
		this.smashCharList.add(new Character("Dark Pit", 96));
		this.smashCharList.add(new Character("Ivysaur", 96));
		this.smashCharList.add(new Character("Wii Fit Trainer", 96));
		this.smashCharList.add(new Character("Pac-Man", 95));
		this.smashCharList.add(new Character("Robin", 95));
		this.smashCharList.add(new Character("Chrom", 95));
		this.smashCharList.add(new Character("Roy", 95));
		this.smashCharList.add(new Character("Inkling", 94));
		this.smashCharList.add(new Character("Ness", 94));
		this.smashCharList.add(new Character("Lucas", 94));
		this.smashCharList.add(new Character("Joker", 93));
		this.smashCharList.add(new Character("Steve", 92));
		this.smashCharList.add(new Character("Mythra", 92));
		this.smashCharList.add(new Character("Ice Climbers", 92));
		this.smashCharList.add(new Character("Lucario", 92));
		this.smashCharList.add(new Character("Wolf", 92));
		this.smashCharList.add(new Character("Villager", 92));
		this.smashCharList.add(new Character("Palutena", 91));
		this.smashCharList.add(new Character("Toon Link", 91));
		this.smashCharList.add(new Character("Marth", 90));
		this.smashCharList.add(new Character("Lucina", 90));
		this.smashCharList.add(new Character("Diddy Kong", 90));
		this.smashCharList.add(new Character("Peach", 89));
		this.smashCharList.add(new Character("Daisy", 89));
		this.smashCharList.add(new Character("Greninja", 88));
		this.smashCharList.add(new Character("Isabelle", 88));
		this.smashCharList.add(new Character("Young Link", 88));
		this.smashCharList.add(new Character("Little Mac", 87));
		this.smashCharList.add(new Character("Duck Hunt", 86));
		this.smashCharList.add(new Character("Sonic", 86));
		this.smashCharList.add(new Character("Sora", 85));
		this.smashCharList.add(new Character("Zelda", 85));
		this.smashCharList.add(new Character("Rosalina & Luma", 82));
		this.smashCharList.add(new Character("Bayonetta", 81));
		this.smashCharList.add(new Character("Meta Knight", 80));
		this.smashCharList.add(new Character("Zero Suit Samus", 80));
		this.smashCharList.add(new Character("Sephiroth", 79));
		this.smashCharList.add(new Character("Kirby", 79));
		this.smashCharList.add(new Character("Pikachu", 79));
		this.smashCharList.add(new Character("Mewtwo", 79));
		this.smashCharList.add(new Character("Olimar", 79));
		this.smashCharList.add(new Character("Sheik", 78));
		this.smashCharList.add(new Character("Fox", 77));
		this.smashCharList.add(new Character("Squirtle", 75));
		this.smashCharList.add(new Character("Mr. Game & Watch", 75));
		this.smashCharList.add(new Character("Jigglypuff", 68));
		this.smashCharList.add(new Character("Pichu", 62));
	}
	
	public int getSmashCharListSize() {
		return this.smashCharList.size();
	}
	
	public String getCharNameAtIndex(int index) {
		return this.smashCharList.get(index).getName();
	}
	
	public int getCharWeigtAtIndex(int index) {
		return this.smashCharList.get(index).getWeight();
	}
	
	public String getCharWeightType(int weight) {
		// weight chart ref: https://preview.redd.it/kv6zo2073sy61.png?width=959&format=png&auto=webp&s=b826ec9e5f8b89d7dc91498869cc941a90ac0d4b
		if(weight >= 110) {
			return "Super HeavyWeight";
		} else if (weight >= 100 && weight <= 109) {
			return "HeavyWeight";
		} else if (weight >= 90 && weight <= 99) {
			return "MiddleWeight";
		} else if (weight >= 80 && weight <= 89) {
			return "LightWeight";
		} else if (weight <= 79) {
			return "Super LightWeight";
		} else {
			return "UNKNOWN";
		}
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
