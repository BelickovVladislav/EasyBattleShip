package core;

import forms.HomeForm;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final HomeForm form = new HomeForm();
		Game.getInstance().start();
//		Game.getInstance().paintFriendlyField(form.getFriedlyGraphic());
//		Game.getInstance().paintEnemyField(form.getEnemyGraphic());
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					// TODO Auto-generated method stub
					Game.getInstance().paintFriendlyField(
							form.getFriedlyGraphic());
					Game.getInstance().paintEnemyField(form.getEnemyGraphic());
				}
			}
		}).start();
	}

}
