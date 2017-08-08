package core;

import javax.swing.JOptionPane;

import forms.HomeForm;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final HomeForm form = new HomeForm();
		Game.getInstance().start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					// TODO Auto-generated method stub
					Game.getInstance().paintFriendlyField(
							form.getFriendlyGraphic());
					Game.getInstance().paintEnemyField(form.getEnemyGraphic());
					String winner = Game.getInstance().getWinner();
					if (winner != null) {
						JOptionPane.showMessageDialog(null, "Win " + winner);
						Game.getInstance().start();
					}

				}
			}
		}).start();
	}

}
