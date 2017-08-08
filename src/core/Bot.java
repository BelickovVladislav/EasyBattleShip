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
		field[steps.get(index).x][ steps.get(index).y].shot();
		steps.remove(index);
	}
}
