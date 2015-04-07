package loderunner;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Main 
{
	public static void main(String[] args) 
	{
		Main menu = new Main();
		menu.make();

	}
	
	public void make()
	{
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		final JPanel panel2 = new JPanel();
		JLabel display = new JLabel("Lode Runner");
		JButton newGame = new JButton("New Game");
		JButton highScore = new JButton("High Scores");
		newGame.setBackground(Color.black);
		highScore.setBackground(Color.black);
		newGame.setForeground(Color.CYAN);
		highScore.setBackground(Color.black);
		highScore.setForeground(Color.GREEN);
		display.setForeground(Color.yellow);

		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				World.main(null);
				frame.dispose();
				
			}
		});

		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				
			}
		});
		
		panel.add(display);
		panel2.add(newGame, BorderLayout.WEST);
		panel2.add(highScore, BorderLayout.EAST);
		panel.setBackground(Color.black);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	

}
