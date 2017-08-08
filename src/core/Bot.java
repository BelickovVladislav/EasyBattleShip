package core;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import constants.IntegerConstants;

public class Bot {
	private ArrayList<Point> steps;
	private Cell[][] field;
	private Random random;

	public Bot(Cell[][] field) {
		random = new Random();
		steps = new ArrayList<Point>();
		this.field = field;

		for (int i = 0; i < IntegerConstants.FIELD_SIZE; i++)
			for (int j = 0; j < IntegerConstants.FIELD_SIZE; j++)
				steps.add(new Point(i, j));
	}

	public void step() {
		int index = random.nextInt(steps.size());
		field[steps.get(index).x][steps.get(index).y].shot();
		remove(index);
	}

	private void remove(int index) {
		int x = steps.get(index).x;
		int y = steps.get(index).y;
		if (!field[x][y].isKilling()) {
			steps.remove(index);
			return;
		}
		for (int i = x - 1; i <= x + 1; i++)
			for (int j = y - 1; j <= y + 1; j++) {
				for (Point point : steps) {
					if (point.x == i && point.y == j) {
						steps.remove(point);
						break;
					}
				}
			}
	}
}
