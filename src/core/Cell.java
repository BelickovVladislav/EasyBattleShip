package core;

import interfaces.Drawable;

import java.awt.Color;
import java.awt.Graphics;

import constants.IntegerConstants;

public class Cell implements Drawable {
	private boolean ship;
	private boolean friendly;
	private boolean statusKill;
	private boolean statusShot;
	private int x, y;

	public Cell(int x, int y) {
		ship = false;
		friendly = false;
		statusKill = false;
		statusShot = false;
		this.x = x;
		this.y = y;
	}

	public void shot() {
		statusShot = true;
		if (this.isShip()) {
			statusKill = true;
		}
	}

	public void setFriendly() {
		this.friendly = true;
	}

	public void setShip() {
		this.ship = true;
	}

	public boolean isShip() {
		return this.ship;
	}

	public boolean isFriendly() {
		return friendly;
	}

	public boolean getStatusShot() {
		return statusShot;
	}

	public boolean isKilling() {
		return statusKill;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if (this.isFriendly()) {
			g.setColor(this.isShip() ? Color.GREEN : Color.DARK_GRAY);
			g.fill3DRect(x * IntegerConstants.CELL_SIZE, y
					* IntegerConstants.CELL_SIZE, IntegerConstants.CELL_SIZE,
					IntegerConstants.CELL_SIZE, !this.getStatusShot());
			return;
		}
		g.setColor(this.isKilling() ? Color.GREEN : Color.DARK_GRAY);
		g.fill3DRect(x * IntegerConstants.CELL_SIZE, y
				* IntegerConstants.CELL_SIZE, IntegerConstants.CELL_SIZE,
				IntegerConstants.CELL_SIZE, !this.getStatusShot());

	}

}
