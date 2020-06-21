package jewel_collector.jewel;

import com.mc322.jewel_collector.items.Item;
import com.mc322.jewel_collector.items.ItemType;

import jewel_collector.environment.Point;

public class Jewel implements Item {
	Point position;
	JewelType jewelType;
	
	public Jewel(Point position, JewelType type) {
		this.position = position;
		this.jewelType = type;
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
		return jewelType.getScore();
	}
	
	public JewelType getJewelType() {
		return jewelType;
	}
	
	public static boolean isJewel(Item item) {
		return item != null && item.getItemType().equals(ItemType.JEWEL);
	}
	
	@Override
	public String toString() {
		return jewelType.toString();
	}

	@Override
	public ItemType getItemType() {
		return ItemType.JEWEL;
	}
}
