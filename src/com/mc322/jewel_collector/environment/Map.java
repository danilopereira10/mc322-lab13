package com.mc322.jewel_collector.environment;

import java.util.List;

import com.mc322.jewel_collector.Robot;
import com.mc322.jewel_collector.exceptions.PositionAlreadyInUseException;
import com.mc322.jewel_collector.items.Item;
import com.mc322.jewel_collector.jewel.Jewel;
import com.mc322.jewel_collector.obstacle.Obstacle;

public class Map {
	public static final Item EMPTY_SQUARE = null;
	private Item[][] matrix;
	
	public Map(int width, int height) {
		this.matrix = new Item[height][width];
		initialize();
	}
	
	public int getHeight() {
		return matrix.length;
	}
	
	public int getWidth() {
		return matrix[0].length;
	}
	
	public Item[][] getMatrix() {
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
		matrix[y][x] = jewel;
	}
	
	public void addObstacles(List<Obstacle> obstacles) {
		for (Obstacle obstacle : obstacles) {
			addObstacle(obstacle);
		}
	}
	
	public void addObstacle(Obstacle obstacle) {
		int x = obstacle.getX();
		int y = obstacle.getY();
		matrix[y][x] = obstacle;
	}
	
	public void updateRobotPosition(Robot robot) throws ArrayIndexOutOfBoundsException, PositionAlreadyInUseException {
		int x = robot.getX();
		int y = robot.getY();
		if (matrix[y][x] != null) {
			throw new PositionAlreadyInUseException();
		}
		matrix[y][x] = robot;
	}
	
	public void clearPosition(Point p) {
		matrix[p.getY()][p.getX()] = EMPTY_SQUARE; 
	}
}
