package jewel_collector.jewel;

import com.mc322.jewel_collector.items.Item;

import jewel_collector.environment.Point;

public class Jewel implements Item {
	Point position;
	JewelType type;
	
	public Jewel(Point position, JewelType type) {
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
	
	public int getScore() {
		return type.getScore();
	}
	
	public static boolean isJewel(String square) {
		for (JewelType jewelType : JewelType.values()) {
			if (square.equals(jewelType.toString())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
}
