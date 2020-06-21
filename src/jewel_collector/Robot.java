package jewel_collector;

import java.util.ArrayList;

import com.mc322.jewel_collector.items.Item;
import com.mc322.jewel_collector.items.ItemType;

import jewel_collector.environment.Map;
import jewel_collector.environment.Point;
import jewel_collector.jewel.Bag;
import jewel_collector.jewel.Jewel;
import printer.Printer;

public class Robot implements Item {
	private static final String ROBOT_TEXT = "ME";	
	private Point position;
	private Bag bag;
	private int hp;
	
	public Robot(Point position) {
		this.position = position;
		bag = new Bag(new ArrayList<>());
		hp = 5;
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
		return ItemType.ROBOT;
	}
	
	public void goLeft() {
		if (hp > 0) {
			hp--;
			position.setX(position.getX() - 1);
		}
	}
	
	public void goRight() {
		if (hp > 0) {
			hp--;
			position.setX(position.getX() + 1);
		}
	}
	
	public void goUp() {
		if (hp > 0) {
			hp--;
			position.setY(position.getY() - 1);
		}
	}
	
	public void goDown() {
		if (hp > 0) {
			hp--;
			position.setY(position.getY() + 1);
		}
	}
	
	public void collectJewelUnderCondition(boolean condition, int x, int y, Map map) {
		Item[][] matrix = map.getMatrix();
		if (condition && Jewel.isJewel(matrix[y][x])) {
			Jewel jewel = (Jewel)matrix[y][x];
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
