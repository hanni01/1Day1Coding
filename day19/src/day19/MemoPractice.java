package day19;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import day19.testMemo.okBtnEvent;

import java.awt.event.*;

public class MemoPractice extends JFrame{
	
	public static int count = 0;
	static JButton memofield;
	static JCheckBox checkDelete;
	static Container c;
	static JButton okBtn;
	static int y2 = 15;

	public static void main(String[] args) {
		
		JFrame memoApp = new JFrame("메모장");
		c = memoApp.getContentPane();
		c.setLayout(null);
		memoApp.setSize(400, 600);
		memoApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memoApp.setVisible(true);
		
		createMenu();
		

	}
	
	private static void createMenu() {
		JMenuBar mBar = new JMenuBar();
		JMenu screenMenu = new JMenu("편집");
		JMenuItem openItem[] = new JMenuItem[2];
		String ItemName[] = {"메모 추가", "메모 삭제"};
		
		for(int i = 0;i < openItem.length;i++) {
			openItem[i] = new JMenuItem(ItemName[i]);
			openItem[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String menuName = e.getActionCommand();
					memoButton mB;
					switch(menuName){
						case "메모 추가":
						while(true){
							mB = new memoButton("");
							break;
						}
						mB.y1 += 60;
						count += 1;
						break;
						case "메모 삭제":
						if(count == 0) {
							JOptionPane.showMessageDialog(null, "삭제할 메세지가 없습니다.");
						}else {
							for(int j = 0;j < count;j++) {
								okBtn.setFont(new Font("Bahnschrift", Font.ITALIC ,12));
								okBtn.setForeground(Color.BLACK);
								okBtn.setBorderPainted(false);
								okBtn.setBackground(new Color(201, 231, 248));
								checkDelete = new JCheckBox();
								testMemo.checkBoxList.add(checkDelete);
								checkDelete.setBounds(5, y2, 25, 25);
								okBtn.setBounds(148, y2+60, 100, 30);
								c.add(checkDelete);
								c.add(okBtn);
								y2 += 60;
								okBtn.repaint();
							}
							okBtn.addActionListener(new okBtnEvent());
							break;
						}
					}
				}
			});
			screenMenu.add(openItem[i]);
		}
		mBar.add(screenMenu);
		this.setJMenuBar(mBar);
	}
}
