package ticTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements MouseListener {

	boolean x_turn = true;
	boolean gameFinished =  false;
	JButton[] numberButtons = new JButton[9];
	JLabel turn_lbl = new JLabel();
	JButton btn_restart = new JButton("Play again");
	
	public TicTacToe() {
		setTitle("TicTacToe");
		setSize(500, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton();
			numberButtons[i].addMouseListener(this);
		}
		JPanel btn_pnl = new JPanel(new GridLayout(3, 3));
		JPanel lbl_pnl = new JPanel();
		JPanel restart_pnl = new JPanel();
		for (int i = 0; i < numberButtons.length; i++) {
			btn_pnl.add(numberButtons[i]);
		}
		lbl_pnl.add(turn_lbl);
		restart_pnl.add(btn_restart);
		btn_restart.addMouseListener(this);
		
		add(lbl_pnl, BorderLayout.NORTH);
		add(btn_pnl, BorderLayout.CENTER);
		add(restart_pnl, BorderLayout.SOUTH);
		
		turn();
			
		

	}
	
	public void turn() {
			if(x_turn = true) {
				turn_lbl.setText("X Turn");
			}
			else if(x_turn = false) {
				turn_lbl.setText("O Turn");
			}
	}
	
	public void xWins(int a, int b, int c) {
		numberButtons[a].setBorderPainted(false);
		numberButtons[b].setBorderPainted(false);
		numberButtons[c].setBorderPainted(false);
		numberButtons[a].setBackground(Color.GREEN);
		numberButtons[b].setBackground(Color.GREEN);
		numberButtons[c].setBackground(Color.GREEN);
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i].setEnabled(false);
		}
		turn_lbl.setText("X wins");
		gameFinished = true;
	}
	
	public void oWins(int a, int b, int c) {
		numberButtons[a].setBorderPainted(false);
		numberButtons[b].setBorderPainted(false);
		numberButtons[c].setBorderPainted(false);
		numberButtons[a].setBackground(Color.GREEN);
		numberButtons[b].setBackground(Color.GREEN);
		numberButtons[c].setBackground(Color.GREEN);
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i].setEnabled(false);
		}
		turn_lbl.setText("O wins");
		gameFinished = true;
	}
	
	public void check() {
		// check x win conditions
		if((numberButtons[0].getText()=="X") &&
				(numberButtons[1].getText()=="X") &&
				(numberButtons[2].getText()=="X")) 
			xWins(0, 1, 2);
		else if((numberButtons[3].getText()=="X") &&
				(numberButtons[4].getText()=="X") &&
				(numberButtons[5].getText()=="X"))
			xWins(3, 4, 5);
		else if((numberButtons[6].getText()=="X") &&
				(numberButtons[7].getText()=="X") &&
				(numberButtons[8].getText()=="X"))
			xWins(6, 7, 8);
		else if((numberButtons[0].getText()=="X") &&
				(numberButtons[3].getText()=="X") &&
				(numberButtons[6].getText()=="X"))
			xWins(0, 3, 6);
		else if((numberButtons[1].getText()=="X") &&
				(numberButtons[4].getText()=="X") &&
				(numberButtons[7].getText()=="X"))
			xWins(1, 4, 7);
		else if((numberButtons[2].getText()=="X") &&
				(numberButtons[5].getText()=="X") &&
				(numberButtons[8].getText()=="X"))
			xWins(2, 5, 8);
		else if((numberButtons[0].getText()=="X") &&
				(numberButtons[4].getText()=="X") &&
				(numberButtons[8].getText()=="X"))
			xWins(0, 4, 8);
		else if((numberButtons[2].getText()=="X") &&
				(numberButtons[4].getText()=="X") &&
				(numberButtons[6].getText()=="X"))
			xWins(2, 4, 6);
		// check o win conditions
		else if((numberButtons[0].getText()=="O") &&
				(numberButtons[1].getText()=="O") &&
				(numberButtons[2].getText()=="O"))
			oWins(0, 1, 2);
		else if((numberButtons[3].getText()=="O") &&
				(numberButtons[4].getText()=="O") &&
				(numberButtons[5].getText()=="O"))
			oWins(3, 4, 5);
		else if((numberButtons[6].getText()=="O") &&
				(numberButtons[7].getText()=="O") &&
				(numberButtons[8].getText()=="O"))
			oWins(6, 7, 8);
		else if((numberButtons[0].getText()=="O") &&
				(numberButtons[3].getText()=="O") &&
				(numberButtons[6].getText()=="O"))
			oWins(0, 3, 6);
		else if((numberButtons[1].getText()=="O") &&
				(numberButtons[4].getText()=="O") &&
				(numberButtons[7].getText()=="O"))
			oWins(1, 4, 7);
		else if((numberButtons[2].getText()=="O") &&
				(numberButtons[5].getText()=="O") &&
				(numberButtons[8].getText()=="O"))
			oWins(2, 5, 8);
		else if((numberButtons[0].getText()=="O") &&
				(numberButtons[4].getText()=="O") &&
				(numberButtons[8].getText()=="O"))
			oWins(0, 4, 8);
		else if((numberButtons[2].getText()=="O") &&
				(numberButtons[4].getText()=="O") &&
				(numberButtons[6].getText()=="O"))
			oWins(2, 4, 6);
	}
	
	
	
	
	public static void main(String[] args) {
		
		new TicTacToe().setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < numberButtons.length; i++) {
			if(e.getSource() == numberButtons[i]) {
				if(x_turn) {
					if(numberButtons[i].getText() == "") {
						numberButtons[i].setForeground(new Color(255, 0, 0));
						numberButtons[i].setText("X");
						x_turn = false;
						turn_lbl.setText("O Turn");
						check();
					}
				}
				else {
					if(numberButtons[i].getText() == "") {
						numberButtons[i].setForeground(new Color(0, 0, 255));
						numberButtons[i].setText("O");
						x_turn = true;
						turn_lbl.setText("X Turn");
						check();
					}
				}
			}
			if(e.getSource() == btn_restart) {
				for (int j = 0; j < numberButtons.length; j++) {
					numberButtons[i].setText("");
					numberButtons[i].setBorderPainted(true);
					turn_lbl.setText("X Turn");
					x_turn = true;
				}
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
