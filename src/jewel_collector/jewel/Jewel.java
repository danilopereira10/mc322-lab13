package jewel_collector.jewel;

import jewel_collector.environment.Point;

public class Jewel {
	Point position;
	JewelType type;
	
	public Jewel(Point position, JewelType type) {
		this.position = position;
		this.type = type;
	}
	
	public int getX() {
		return position.getX();
	}
	
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
