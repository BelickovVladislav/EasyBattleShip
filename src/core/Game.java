package core;

import java.awt.Graphics;
import java.util.Random;

import constants.IntegerConstants;

public class Game {
	private static Game game;

	public static Game getInstance() {
		return game == null ? game = new Game() : game;
	}

	private Cell[][] friendlyField;
	private Cell[][] enemyField;

	private Game() {
		friendlyField = new Cell[IntegerConstants.FIELD_SIZE][IntegerConstants.FIELD_SIZE];
		enemyField = new Cell[IntegerConstants.FIELD_SIZE][IntegerConstants.FIELD_SIZE];
	}

	public void start() {
		generate(friendlyField, true);
		generate(enemyField, false);
	}

	private void generate(Cell[][] field, boolean friendly) {
		for (int i = 0; i < IntegerConstants.FIELD_SIZE; i++) {
			for (int j = 0; j < IntegerConstants.FIELD_SIZE; j++) {
				field[i][j] = new Cell(i, j);
				if (friendly)
					field[i][j].setfFriendly();
			}
		}
		generateShips(field);
	}

	private void generateShips(Cell[][] field) {
		Random rand = new Random();
		int currentCountShips = 0;
		while (currentCountShips < IntegerConstants.COUNT_SHIPS) {
			int x = rand.nextInt(IntegerConstants.FIELD_SIZE);
			int y = rand.nextInt(IntegerConstants.FIELD_SIZE);
			if (!checkAroundCell(field, x, y))
				continue;
			field[x][y].setShip();
			currentCountShips++;
		}
	}

	private boolean checkAroundCell(Cell[][] field, int x, int y) {
		for (int i = x - 1; i <= x + 1; i++)
			for (int j = y - 1; j <= y + 1; j++)
				try {
					if (field[i][j].isShip())
						return false;
				} catch (Exception ex) {
				}
		return true;
	}

	private void paintField(Cell[][] field, Graphics g) {
		for (int i = 0; i < IntegerConstants.FIELD_SIZE; i++)
			for (int j = 0; j < IntegerConstants.FIELD_SIZE; j++)
				field[i][j].paint(g);
	}

	public void paintFriendlyField(Graphics g) {
		paintField(friendlyField, g);
	}

	public void paintEnemyField(Graphics g) {
		paintField(enemyField, g);
	}
}
