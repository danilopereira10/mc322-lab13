package com.mc322.jewel_collector.jewel;

import java.util.List;

public class Bag {
	List<Jewel> jewels;
	
	public Bag (List<Jewel> jewels) {
		this.jewels = jewels;
	}
	
	public void addJewel(Jewel jewel) {
		jewels.add(jewel);
	}
	
	public int getAmountOfJewels() {
		return jewels.size();
	}
	
	public int getTotalScore() {
		int totalScore = 0;
		for (Jewel jewel : jewels) {
			totalScore += jewel.getScore();
		}
		return totalScore;
	}
}
