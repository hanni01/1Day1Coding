package day19;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Memo extends JFrame{
	public static void main(String[] args) {
		//메모장에 내용 적는 필드 만들기
		JFrame memoApp = new JFrame("메모장");
		memoApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memoApp.setSize(350,500);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image i = toolkit.getImage("C:\\Users\\he308\\OneDrive\\바탕 화면\\"
				+ "JAVA\\workspace\\day19\\src\\day19\\memo.png");
		memoApp.setIconImage(i);
                        
        JTextArea memoArea = new JTextArea();      
        memoApp.add(memoArea);
        
        memoApp.setVisible(true);
        
        //메뉴바 만들기
        JMenuBar mBar = new JMenuBar();
        memoApp.setJMenuBar(mBar);
         
        //메뉴바에 넣을 메뉴 생성
        JMenu screenMenu = new JMenu("파일");
        mBar.add(screenMenu);
        
        //메뉴 목록에 넣을 아이템 생성
        JMenuItem save = new JMenuItem("저장");
        JMenuItem load = new JMenuItem("로드");     
        screenMenu.add(save);
        screenMenu.add(load);
        
        //저장을 클릭했을 때
        save.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	//대화상자(파일창) 생성
            	FileDialog fd = new FileDialog(memoApp, "로드", FileDialog.SAVE);
            	fd.setVisible(true);
            	
            	//저장될 파일의 경로를 path에 저장
            	String path = fd.getDirectory() + fd.getFile();
            	try {
            		//그 경로를 파일 쓰기 객체인 fw에 저장
            		FileWriter fw = new FileWriter(path);
            		
            		//메모썼던 공간으로부터 텍스트 가져와 memoContent에 저장
            		String memoContent = memoArea.getText();
            		//fw에 내용 적기
            		fw.write(memoContent);
            		
            		//파일 쓰기 함수는 꼭 닫아주자!
            		fw.close();
            		
            	//파일 쓰기 함수는 꼭 예외 처리를 해주자!
            	}catch(Exception e1) {
            		System.out.println("저장오류"+e1);
            	}
            }            
        });
        
        //로드를 클릭했을 때
        load.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	//대화상자(파일창) 생성
                FileDialog fd = new FileDialog(memoApp, "로드", FileDialog.LOAD);
                fd.setVisible(true);
                
                String path = fd.getDirectory()+fd.getFile();
                String s = "";
                
                try {
                	FileReader fr = new FileReader(path);
                	
                	//정수인 이유는 파일을 읽어오는 read()함수가 바이트 형태로 읽어오기 때문
                	int n;
                	for(;;) {
                		n = fr.read();
                		
                		//그리고 그 바이트는 파일의 끝에 도달했을 때 -1을 반환하므로 -1이 
                		//뜰 때까지 파일을 읽어오는 것으로 설정
                		if(n == -1) {
                			break;
                		}
                		//정수n을 문자로 형변환 하여 문자열 s에 저장 -> 한꺼번에 읽는 것을 위함
                		s += (char)n;
                	}
                	fr.close();
                }catch(Exception e2) {
                	System.out.println("오류"+e2);
                }
                //메모장 프로그램에 읽어온 파일 불러들이기
                memoArea.setText(s);
            }  
        }); 
        
    }       
}