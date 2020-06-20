package jewel_collector.obstacle;

import jewel_collector.environment.Point;

public class Obstacle {
	Point position;
	ObstacleType type;
	
	public Obstacle(Point position, ObstacleType type) {
		this.position = position;
		this.type = type;
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}
	
	public static boolean isObstacle(String square) {
		for (ObstacleType obstacleType : ObstacleType.values()) {
			if (square.equals(obstacleType.toString())) {
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
