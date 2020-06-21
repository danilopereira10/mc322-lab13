package com.mc322.jewel_collector.obstacle;

import com.mc322.jewel_collector.environment.Point;
import com.mc322.jewel_collector.items.Item;
import com.mc322.jewel_collector.items.ItemType;

public class Obstacle implements Item {
	Point position;
	ObstacleType type;
	
	public Obstacle(Point position, ObstacleType type) {
		this.position = position;
		this.type = type;
	}
	
	@Override
	public int getX() {
		return position.getX();
	}
	
	@Override
	public int getY() {
		return position.getY();
	}
	
	@Override
	public ItemType getItemType() {
		return ItemType.OBSTACLE;
	}
	
	public static boolean isObstacle(Item item) {
		return item != null && item.getItemType().equals(ItemType.OBSTACLE);
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
}
