package com.mc322.jewel_collector.rechargable;

import com.mc322.jewel_collector.environment.Point;
import com.mc322.jewel_collector.obstacle.Obstacle;
import com.mc322.jewel_collector.obstacle.ObstacleType;

public class Tree extends Obstacle implements Rechargable {
	public Tree(Point position) {
		super(position, ObstacleType.TREE);
	}
}
