package day19;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutABC extends JFrame {
	FlowLayoutABC() {
		super("FlowLayout¿Ã¥Ÿ!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		cp.add(new JButton("apple"));
		cp.add(new JButton("banana"));
		cp.add(new JButton("carrot"));
		cp.add(new JButton("donut"));
		cp.add(new JButton("eagle"));
		
		setSize(400,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FlowLayoutABC fla = new FlowLayoutABC();
	}
}