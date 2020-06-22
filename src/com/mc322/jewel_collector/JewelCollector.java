package com.mc322.jewel_collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mc322.jewel_collector.environment.Map;
import com.mc322.jewel_collector.environment.Point;
import com.mc322.jewel_collector.exceptions.PositionAlreadyInUseException;
import com.mc322.jewel_collector.items.Item;
import com.mc322.jewel_collector.jewel.Jewel;
import com.mc322.jewel_collector.jewel.JewelType;
import com.mc322.jewel_collector.obstacle.Obstacle;
import com.mc322.jewel_collector.obstacle.ObstacleType;
import com.mc322.jewel_collector.rechargable.BlueJewel;
import com.mc322.jewel_collector.rechargable.Tree;
import com.mc322.printer.Printer;

public class JewelCollector {

	public static void main(String[] args) {
		Map map = new Map(10, 10);
		
		List<Jewel> jewels = new ArrayList<>();
		jewels.add(new Jewel(new Point(1,9), JewelType.RED));
		jewels.add(new Jewel(new Point(8,8), JewelType.RED));
		jewels.add(new Jewel(new Point(9,1), JewelType.GREEN));
		jewels.add(new Jewel(new Point(7,6), JewelType.GREEN));
		jewels.add(new BlueJewel(new Point(3,4)));
		jewels.add(new BlueJewel(new Point(2,1)));
		map.addJewels(jewels);
		
		List<Obstacle> obstacles = new ArrayList<>();
		obstacles.add(new Obstacle(new Point(5,0), ObstacleType.WATER));
		obstacles.add(new Obstacle(new Point(5,1), ObstacleType.WATER));
		obstacles.add(new Obstacle(new Point(5,2), ObstacleType.WATER));
		obstacles.add(new Obstacle(new Point(5,3), ObstacleType.WATER));
		obstacles.add(new Obstacle(new Point(5,4), ObstacleType.WATER));
		obstacles.add(new Obstacle(new Point(5,5), ObstacleType.WATER));
		obstacles.add(new Obstacle(new Point(5,6), ObstacleType.WATER));
		obstacles.add(new Tree(new Point(5,9)));
		obstacles.add(new Tree(new Point(3,9)));
		obstacles.add(new Tree(new Point(8,3)));
		obstacles.add(new Tree(new Point(2,5)));
		obstacles.add(new Tree(new Point(1,4)));
		map.addObstacles(obstacles);
		
		Point initialPosition = new Point(0, 0);
		Robot robot = new Robot(initialPosition);
		robot.setMap(map);
		try {
			map.updateRobotPosition(robot);
		} catch (ArrayIndexOutOfBoundsException | PositionAlreadyInUseException e) {
			System.exit(1);
		}
		
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			Printer.getInstance().printLine(" Enter the command : ");
			String command = keyboard.nextLine() ;
			
			Item[][] matrix = map.getMatrix();
			int x = robot.getX();
			int y = robot.getY();
			
			if (command.compareTo("quit") == 0) {
				running = false;	
			} else if (command.compareTo("w") == 0) {
				if (robot.getY() > 0 && !Obstacle.isObstacle(matrix[y-1][x]) && !Jewel.isJewel(matrix[y-1][x])) {
					robot.goUp();
				}	
			} else if (command.compareTo("a") == 0) {
				if (robot.getX() > 0 && !Obstacle.isObstacle(matrix[y][x-1]) && !Jewel.isJewel(matrix[y][x-1])) {
					robot.goLeft();
				}
			} else if (command.compareTo("s") == 0) {
				if (robot.getY() <= map.getHeight() - 2 && !Obstacle.isObstacle(matrix[y+1][x]) && 
						!Jewel.isJewel(matrix[y+1][x])) {
					robot.goDown();
				}
			} else if (command.compareTo("d") == 0) {
				if (robot.getX() <= map.getWidth() - 2 && !Obstacle.isObstacle(matrix[y][x+1]) && 
						!Jewel.isJewel(matrix[y][x+1])) {
					robot.goRight();
				}
			} else if (command.compareTo("g") == 0) {
				boolean condition = robot.getY() > 0;
				x = robot.getX();
				y = robot.getY() - 1;
				robot.collectJewelUnderCondition(condition, x, y);
				
				condition = robot.getY() <= map.getHeight() - 2;
				x = robot.getX();
				y = robot.getY() + 1;
				robot.collectJewelUnderCondition(condition, x, y);
				
				condition = robot.getX() > 0;
				x = robot.getX() - 1;
				y = robot.getY();
				robot.collectJewelUnderCondition(condition, x, y);
				
				condition = robot.getX() <= map.getWidth() - 2;
				x = robot.getX() + 1;
				y = robot.getY();
				robot.collectJewelUnderCondition(condition, x, y);
			} else if (command.compareTo("u") == 0) {
				robot.useItem();
			}
			
			Printer.getInstance().printMap(map.getMatrix());
			Printer.getInstance().printLine("Robot hp: " + robot.getHp());
			robot.showTotalOfJewels();
		}
		
		keyboard.close();
	}
}
