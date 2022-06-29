package day19;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Memo extends JFrame{
	public static void main(String[] args) {
		//�޸��忡 ���� ���� �ʵ� �����
		JFrame memoApp = new JFrame("�޸���");
		memoApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memoApp.setSize(350,500);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image i = toolkit.getImage("C:\\Users\\he308\\OneDrive\\���� ȭ��\\"
				+ "JAVA\\workspace\\day19\\src\\day19\\memo.png");
		memoApp.setIconImage(i);
                        
        JTextArea memoArea = new JTextArea();      
        memoApp.add(memoArea);
        
        memoApp.setVisible(true);
        
        //�޴��� �����
        JMenuBar mBar = new JMenuBar();
        memoApp.setJMenuBar(mBar);
         
        //�޴��ٿ� ���� �޴� ����
        JMenu screenMenu = new JMenu("����");
        mBar.add(screenMenu);
        
        //�޴� ��Ͽ� ���� ������ ����
        JMenuItem save = new JMenuItem("����");
        JMenuItem load = new JMenuItem("�ε�");     
        screenMenu.add(save);
        screenMenu.add(load);
        
        //������ Ŭ������ ��
        save.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	//��ȭ����(����â) ����
            	FileDialog fd = new FileDialog(memoApp, "�ε�", FileDialog.SAVE);
            	fd.setVisible(true);
            	
            	//����� ������ ��θ� path�� ����
            	String path = fd.getDirectory() + fd.getFile();
            	try {
            		//�� ��θ� ���� ���� ��ü�� fw�� ����
            		FileWriter fw = new FileWriter(path);
            		
            		//�޸��� �������κ��� �ؽ�Ʈ ������ memoContent�� ����
            		String memoContent = memoArea.getText();
            		//fw�� ���� ����
            		fw.write(memoContent);
            		
            		//���� ���� �Լ��� �� �ݾ�����!
            		fw.close();
            		
            	//���� ���� �Լ��� �� ���� ó���� ������!
            	}catch(Exception e1) {
            		System.out.println("�������"+e1);
            	}
            }            
        });
        
        //�ε带 Ŭ������ ��
        load.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	//��ȭ����(����â) ����
                FileDialog fd = new FileDialog(memoApp, "�ε�", FileDialog.LOAD);
                fd.setVisible(true);
                
                String path = fd.getDirectory()+fd.getFile();
                String s = "";
                
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
                		//����n�� ���ڷ� ����ȯ �Ͽ� ���ڿ� s�� ���� -> �Ѳ����� �д� ���� ����
                		s += (char)n;
                	}
                	fr.close();
                }catch(Exception e2) {
                	System.out.println("����"+e2);
                }
                //�޸��� ���α׷��� �о�� ���� �ҷ����̱�
                memoArea.setText(s);
            }  
        }); 
        
    }       
}