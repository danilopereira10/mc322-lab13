package com.mc322.jewel_collector.rechargable;

import com.mc322.jewel_collector.environment.Point;
import com.mc322.jewel_collector.jewel.Jewel;
import com.mc322.jewel_collector.jewel.JewelType;

public class BlueJewel extends Jewel implements Rechargable {
	public BlueJewel(Point position) {
		super(position, JewelType.BLUE);
	}
}
