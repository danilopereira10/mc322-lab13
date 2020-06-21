package com.mc322.jewel_collector.obstacle;

public enum ObstacleType {
	WATER("##"),
	TREE("$$");
	
	private String text;
	
	ObstacleType(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
