package com.mc322.jewel_collector;

import java.util.ArrayList;

import com.mc322.jewel_collector.environment.Map;
import com.mc322.jewel_collector.environment.Point;
import com.mc322.jewel_collector.exceptions.PositionAlreadyInUseException;
import com.mc322.jewel_collector.items.Item;
import com.mc322.jewel_collector.items.ItemType;
import com.mc322.jewel_collector.jewel.Bag;
import com.mc322.jewel_collector.jewel.Jewel;
import com.mc322.jewel_collector.rechargable.BlueJewel;
import com.mc322.jewel_collector.rechargable.Rechargable;
import com.mc322.jewel_collector.rechargable.Tree;
import com.mc322.printer.Printer;

public class Robot implements Item {
	private static final String ROBOT_TEXT = "ME";	
	private Point position;
	private Bag bag;
	private int hp;
	private Map map;
	
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
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void goLeft() {
		int x = position.getX();
		if (hp > 0) {
			position.setX(x - 1);
			try {
				move();
				hp--;
				map.clearPosition(new Point(x, position.getY()));
			} catch (ArrayIndexOutOfBoundsException | PositionAlreadyInUseException e) {
				position.setX(x);
			}
		}
	}
	
	public void goRight() {
		int x = position.getX();
		if (hp > 0) {
			position.setX(x + 1);
			try {
				move();
				hp--;
				map.clearPosition(new Point(x, position.getY()));
			} catch (ArrayIndexOutOfBoundsException | PositionAlreadyInUseException e) {
				position.setX(x);
			}
		}
	}
	
	public void goUp() {
		int y = position.getY();
		if (hp > 0) {
			position.setY(y - 1);
			try {
				move();
				hp--;
				map.clearPosition(new Point(position.getX(), y));
			} catch (ArrayIndexOutOfBoundsException | PositionAlreadyInUseException e) {
				position.setY(y);
			}
		}
	}
	
	public void goDown() {
		int y = position.getY();
		if (hp > 0) {
			position.setY(y + 1);
			try {
				move();
				hp--;
				map.clearPosition(new Point(position.getX(), y));
			} catch (ArrayIndexOutOfBoundsException | PositionAlreadyInUseException e) {
				position.setY(y);
			}
		}
	}
	
	private void move() throws ArrayIndexOutOfBoundsException, PositionAlreadyInUseException {
		map.updateRobotPosition(this);
	}
	
	public void collectJewelUnderCondition(boolean condition, int x, int y) {
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
	
	public void useItem() {
		int x = position.getX();
		int y = position.getY();
		Item item = null;
		Item[][] matrix = map.getMatrix();
		if (y - 1 >= 0 && matrix[y - 1][x] instanceof Rechargable) {
			item = matrix[y - 1][x];
		} else if (x - 1 >= 0 && matrix[y][x - 1] instanceof Rechargable) {
			item = matrix[y][x - 1];
		} else if (x + 1 < matrix[0].length && matrix[y][x + 1] instanceof Rechargable) {
			item = matrix[y][x + 1];
		} else if (y + 1 < matrix.length && matrix[y + 1][x] instanceof Rechargable) {
			item = matrix[y + 1][x];
		}
		if (item != null) {
			if (item instanceof BlueJewel) {
				hp += 5;
				Jewel jewel = (Jewel) item;
				collectJewelUnderCondition(true, jewel.getX(), jewel.getY());
			} else if (item instanceof Tree) {
				hp += 3;
			}
		}
	}
	
	@Override
	public String toString() {
		return ROBOT_TEXT;
	}
}
