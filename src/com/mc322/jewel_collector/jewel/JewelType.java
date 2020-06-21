package com.mc322.jewel_collector.jewel;

public enum JewelType {
	RED(100, "JR"),
	GREEN(50, "JG"),
	BLUE(10, "JB");
	
	private int score;

	private String text;
	
	private JewelType(int score, String text) {
		this.score = score;
		this.text = text;
	}

	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
	public static JewelType getJewelTypeOf(String square) {
		for (JewelType jewelType : JewelType.values()) {
			if (jewelType.toString().equals(square)) {
				return jewelType;
			}
		}
		throw new IllegalArgumentException();
	}
}
