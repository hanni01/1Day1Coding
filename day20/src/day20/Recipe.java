package day20;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileReader;

public class Recipe {
	public static ArrayList<String> btnList = new ArrayList<String>();
	public static ArrayList<JButton> btnList2 = new ArrayList<JButton>();

	public static void main(String[] args) {

		JFrame recipeApp =  new JFrame("�丮 ������ ��");
		recipeApp.setSize(400, 600);
		recipeApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recipeApp.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 400, 37);
		panel1.setLayout(null);
		panel1.setBackground(new Color(204, 153, 255));
		recipeApp.add(panel1);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 37, 400, 489);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setBackground(Color.WHITE);
		recipeApp.add(mainPanel);

		JTextField search = new JTextField();
		search.setBounds(100, 3, 200, 30);
		panel1.add(search);

		JLabel label1 = new JLabel("�丮 �˻�");
		label1.setBounds(25, 3, 100, 30);
		panel1.add(label1);

		JButton searchBtn = new JButton("");
		ImageIcon icon = new ImageIcon("C:\\Users\\he308\\OneDrive"
				+ "\\���� ȭ��\\������Ʈ ���� ����\\30_00title.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
		searchBtn = new JButton(new ImageIcon(changeImg));
		searchBtn.setBounds(320, 3, 50, 30);
		panel1.add(searchBtn);

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(search.getText().equals("")) {
					JFrame popup = new JFrame();
					popup.setSize(400, 200);
					popup.setLayout(null);
					popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					JLabel alarm = new JLabel("! �˻�� �Է����ֽʽÿ�.");
					alarm.setBounds(120, 40, 200, 50);
					popup.add(alarm);
					
					JButton ok = new JButton("Ȯ��");
					ok.setBounds(165, 115, 60, 30);
					popup.add(ok);
					
					ok.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e2) {
							popup.dispose();
						}
						
					});
					popup.setVisible(true);
				}else {
					for(String name : btnList) {
						if(search.getText().equals(name)) {
							JFrame searchResult = new JFrame();
							searchResult.setSize(300, 150);
							searchResult.setLayout(new FlowLayout(FlowLayout.CENTER));
							searchResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							
							JButton jb = btnList2.get(btnList.indexOf(name));
							
							jb.setSize(80, 100);
							searchResult.add(jb);
							
							JButton ok3 = new JButton("Ȯ��");
							ok3.setSize(200, 30);
							searchResult.add(ok3);
							
							ok3.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e3) {
									mainPanel.add(jb);
									mainPanel.repaint();
									searchResult.dispose();
								}
								
							});
							searchResult.setVisible(true);
						}else {
							continue;
						}
					}
					for(String name : btnList) {
						if(!search.getText().equals(name)) {
							JFrame popup2 = new JFrame();
							popup2.setSize(400, 200);
							popup2.setLayout(null);
							popup2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							
							JLabel alarm2 = new JLabel("! ��ġ�ϴ� �丮�� �����ϴ�.");
							alarm2.setBounds(120, 40, 200, 50);
							popup2.add(alarm2);
							
							JButton ok2 = new JButton("Ȯ��");
							ok2.setBounds(165, 115, 60, 30);
							popup2.add(ok2);
							
							ok2.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e4) {
									popup2.dispose();
								}
								
							});
							popup2.setVisible(true);
							break;
						}
					}
				}
			}
			
		});
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 526, 400, 37);
		panel2.setBackground(new Color(204, 153, 255));
		recipeApp.add(panel2);

		JButton plus = new JButton("+");
		plus.setOpaque(false);
		plus.setBounds(25, 527, 50, 30);
		panel2.add(plus);

		//�÷��� ��ư�� ������ ��
		plus.addActionListener(new ActionListener() {
			String menuName;
			String pathPictures;
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame plusMenu = new JFrame("���� �̸��� ������ ÷�����ּ���!");
				plusMenu.setLayout(null);
				plusMenu.setSize(400, 200);
				plusMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JLabel putName = new JLabel("�޴� �̸�");
				putName.setBounds(25, 30, 100, 30);
				plusMenu.add(putName);

				JTextField nameField = new JTextField();
				nameField.setBounds(120, 30, 150, 30);
				plusMenu.add(nameField);

				JLabel putPictures = new JLabel("����");
				putPictures.setBounds(25, 70, 100, 30);
				plusMenu.add(putPictures);

				JTextField picturesField = new JTextField();
				picturesField.setBounds(120, 70, 150, 30);
				plusMenu.add(picturesField);

				JButton file = new JButton("÷��");
				file.setOpaque(false);
				file.setBounds(300, 70, 60, 30);
				plusMenu.add(file);

				JButton complete = new JButton("�Ϸ�");
				complete.setOpaque(false);
				complete.setBounds(170, 120, 60, 30);
				plusMenu.add(complete);

				//÷�� ��ư�� ������ ��
				file.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//��ȭ����(����â) ����
		                FileDialog fd = new FileDialog(plusMenu, "�ε�", FileDialog.LOAD);
		                fd.setVisible(true);

		                String path = fd.getDirectory()+fd.getFile();
		                try {

		                	FileReader fr = new FileReader(path);
		                	//������ ������ ������ �о���� read()�Լ��� ����Ʈ ���·� �о���� ����
		                	int n;
		                	for(;;) {
		                		n = fr.read();
		                		//�׸��� �� ����Ʈ�� ������ ���� �������� �� -1�� ��ȯ�ϹǷ� -1�� 
		                		//�� ������ ������ �о���� ������ ����
		                		if(n == -1) {
		                			break;
		                		}
		                	}
		                	fr.close();
		                }catch(Exception e2) {
		                	System.out.println("����"+e2);
		                }
		                //���� �ؽ�Ʈ �ʵ忡 �о�� ���� �ҷ����̱�
		                picturesField.setText(path);
					}
				});
				//�Ϸ� ��ư�� ������ ��
				complete.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menuName = nameField.getText();
						pathPictures = picturesField.getText();
						
						JButton cook = new JButton(menuName);
						btnList.add(menuName);
						cook.setHorizontalAlignment(SwingConstants.CENTER);
						cook.setVerticalAlignment(SwingConstants.BOTTOM);
						cook.setSize(80, 100);
						ImageIcon icon2 = new ImageIcon(pathPictures);
						Image img2 = icon2.getImage();
						Image changeImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
						cook = new JButton(new ImageIcon(changeImg2));

						mainPanel.add(cook);
						mainPanel.repaint();
				        cook.addActionListener(new ActionListener() {
							String s = "";
							@Override
							public void actionPerformed(ActionEvent e) {
								if(s.equals("")) {
									JFrame recipeContent = new JFrame("������ ����");
									recipeContent.setSize(400, 300);
									recipeContent.setLayout(null);
									recipeContent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
										
									JButton contentComplete = new JButton("�Ϸ�");
									contentComplete.setBounds(175, 220, 60, 30);
									recipeContent.add(contentComplete);
										
										
									JTextArea recipeText = new JTextArea(s);
									recipeText.setBounds(75, 3, 250, 200);
									recipeContent.add(recipeText);
										
									contentComplete.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											s = recipeText.getText();
											recipeContent.dispose();
										}
											
									});
									recipeContent.setVisible(true);
								}else {
									JFrame showContent = new JFrame("������ ����");
									showContent.setSize(400, 300);
									showContent.setLayout(null);
									showContent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									
									JTextArea contentText = new JTextArea(s);
									contentText.setBounds(75, 3, 250, 200);
									showContent.add(contentText);
									
									JButton contentComplete2 = new JButton("�Ϸ�");
									contentComplete2.setBounds(175, 220, 60, 30);
									showContent.add(contentComplete2);
									
									contentComplete2.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											s = contentText.getText();
											showContent.dispose();
										}	
									});
									showContent.setVisible(true);
								}
							}
						});
				        btnList2.add(cook);
				        mainPanel.repaint();
						plusMenu.dispose();
					}
				});
				plusMenu.setVisible(true);
				mainPanel.repaint();
			}
		});
		//������������ setVisible(true)�� �׻� �� �������� ���ش�
		recipeApp.setVisible(true);
	}
}
