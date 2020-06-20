package jewel_collector.environment;

import java.util.List;

import jewel_collector.Robot;
import jewel_collector.jewel.Jewel;
import jewel_collector.obstacle.Obstacle;

public class Map {
	private static final String EMPTY_SQUARE = "--";
	private String[][] matrix;
	
	public Map(int width, int height) {
		this.matrix = new String[height][width];
		initialize();
	}
	
	public int getHeight() {
		return matrix.length;
	}
	
	public int getWidth() {
		return matrix[0].length;
	}
	
	public String[][] getMatrix() {
		return matrix.clone();
	}
	
	public void initialize() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = EMPTY_SQUARE; 
			}
		}
	}
	
	public void addJewels(List<Jewel> jewels) {
		for (Jewel jewel : jewels) {
			addJewel(jewel);
		}
	}
	
	public void addJewel(Jewel jewel) {
		int x = jewel.getX();
		int y = jewel.getY();
		matrix[y][x] = jewel.toString();
	}
	
	public void addObstacles(List<Obstacle> obstacles) {
		for (Obstacle obstacle : obstacles) {
			addObstacle(obstacle);
		}
	}
	
	public void addObstacle(Obstacle obstacle) {
		int x = obstacle.getX();
		int y = obstacle.getY();
		matrix[y][x] = obstacle.toString();
	}
	
	public void updateRobotPosition(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();
		matrix[y][x] = robot.toString();
	}
	
	public void clearPosition(Point p) {
		matrix[p.getY()][p.getX()] = EMPTY_SQUARE; 
	}
}
