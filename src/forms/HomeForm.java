package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.IntegerConstants;
import constants.StringConstants;
import core.Game;

public class HomeForm extends JFrame {
	private JPanel friendlyPanel;
	private JPanel enemyPanel;
	private JButton startBattle;
	private JPanel gamePanel;
	public HomeForm() {
		super(StringConstants.PROGRAMM_NAME);
		this.setLayout(new BorderLayout());
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(1,1));
		
		friendlyPanel = new JPanel();
		friendlyPanel.setPreferredSize(new Dimension(IntegerConstants.CELL_SIZE * IntegerConstants.FIELD_SIZE, IntegerConstants.CELL_SIZE * IntegerConstants.FIELD_SIZE));
		
		enemyPanel = new JPanel();
		enemyPanel.setPreferredSize(new Dimension(IntegerConstants.CELL_SIZE * IntegerConstants.FIELD_SIZE, IntegerConstants.CELL_SIZE * IntegerConstants.FIELD_SIZE));
		
		friendlyPanel.setDoubleBuffered(true);
		enemyPanel.setDoubleBuffered(true);
		gamePanel.add(friendlyPanel);
		gamePanel.add(enemyPanel);
		
		startBattle = new JButton(StringConstants.START_BATTLE);
		startBattle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Game.getInstance().start();
				
			}
		});
		this.add(startBattle, BorderLayout.SOUTH);
		this.add(gamePanel, BorderLayout.CENTER);
		this.setSize(IntegerConstants.FORM_WIDTH, IntegerConstants.FORM_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.show();
	}

	public Graphics getFriedlyGraphic() {
		return friendlyPanel.getGraphics();
	}

	public Graphics getEnemyGraphic() {
		return enemyPanel.getGraphics();
	}
}
