package day19;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class testMemo extends JFrame{
	public static Container c;
	public int count = 0;
	int y2 = 15;
	public static ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	JButton memofield;
	JCheckBox checkDelete;
	JButton okBtn = new JButton("Complete");
	
	public testMemo(String title) {
		super(title);
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(573, 150);
		createMenu();
		setLayout(null);
		setVisible(true);
		c = getContentPane();
	}
	
	private void createMenu() {
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
								repaint();
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
	
	class okBtnEvent implements ActionListener{
		int index;

		@Override
		public void actionPerformed(ActionEvent e) {
			for(JCheckBox check : testMemo.checkBoxList) {
				if(check.isSelected()) {
					index = testMemo.checkBoxList.indexOf(check);
					JButton selectButton = memoButton.memofieldList.get(index);
					selectButton.setVisible(false);
					c.remove(selectButton);
				}
				check.setVisible(false);
				c.remove(check);
				okBtn.setVisible(false);
			}
			y2 = 15;
			memoButton.memofieldList.get(index+1).setBounds(30, y1-60, 400, 60);
			
		}
	}
	
	public static void main(String[] args) {
		testMemo testmemo = new testMemo("메모장");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image i = toolkit.getImage("C:\\Users\\he308\\OneDrive\\바탕 화면\\"
				+ "JAVA\\workspace\\day19\\src\\day19\\memo.png");
		testmemo.setIconImage(i);
	}
}

class memoButton extends JButton{
	public static ArrayList<JButton> memofieldList = new ArrayList<JButton>();
	int x = 30;
	int y1 = 0;
	int width = 400;
	int height = 60;
	
	public memoButton(String title) {
		this = new JButton(title);
		this = new JButton(new ImageIcon("C:\\Users\\he308\\"
				+ "OneDrive\\바탕 화면\\JHE\\자바프로그래밍\\"
				+ "메모장 프로젝트\\메모장배경긴버전.jpg"));
		this.setBounds(x, y1, width, height);
		testMemo.c.add(this);
		memofieldList.add(this);
		this.repaint();
	}
}
