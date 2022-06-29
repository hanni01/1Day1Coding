package day25;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class AgainFinal3 {
	
	static Vector<String> v = new Vector<String>();

	public static void main(String[] args) {
		JFrame j = new JFrame();
		Container c = j.getContentPane();
		j.setLayout(null);
		j.setSize(500, 500);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel la = new JLabel("(0, 0)");
		la.setSize(60, 60);
		la.setLocation(0, 0);
		c.add(la);
		j.setVisible(true);
		
		j.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setText("("+x+", "+y+")");
				la.setLocation(x, y);
				v.add("("+x+", "+y+")");
				System.out.println("Left mouse button pressed at ("+x+", "+y+")");
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		j.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(v.size()+" histories of click");
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					for(int i = v.size()-1;i >= 0;i--) {
						System.out.println(v.get(i));
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}
