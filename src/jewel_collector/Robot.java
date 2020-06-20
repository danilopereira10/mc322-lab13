package jewel_collector;

import java.util.ArrayList;

import jewel_collector.environment.Map;
import jewel_collector.environment.Point;
import jewel_collector.jewel.Bag;
import jewel_collector.jewel.Jewel;
import jewel_collector.jewel.JewelType;
import printer.Printer;

public class Robot {
	private static final String ROBOT_TEXT = "ME";	
	private Point position;
	private Bag bag;
	
	public Robot(Point position) {
		this.position = position;
		bag = new Bag(new ArrayList<>());
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}
	
	public void goLeft() {
		position.setX(position.getX() - 1); 
	}
	
	public void goRight() {
		position.setX(position.getX() + 1);
	}
	
	public void goUp() {
		position.setY(position.getY() - 1);
	}
	
	public void goDown() {
		position.setY(position.getY() + 1);
	}
	
	public void collectJewelUnderCondition(boolean condition, int x, int y, Map map) {
		String[][] matrix = map.getMatrix();
		if (condition && Jewel.isJewel(matrix[y][x])) {
			Point jewelPosition = new Point(x, y);
			JewelType jewelType = JewelType.getJewelTypeOf(matrix[y][x]);
			Jewel jewel = new Jewel(jewelPosition, jewelType);
			collectJewel(jewel);
			map.clearPosition(new Point(jewel.getX(), jewel.getY()));
		}
	}
	
	public void collectJewel(Jewel jewel) {
		bag.addJewel(jewel);
	}
	
	
	public void showTotalOfJewels() {
		Printer.getInstance().printBagInfo(bag.getAmountOfJewels(), bag.getTotalScore());
	}
	
	@Override
	public String toString() {
		return ROBOT_TEXT;
	}
}
