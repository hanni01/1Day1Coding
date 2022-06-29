package pcProgram;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ProgramScreen {
	
	public ArrayList<JButton> pcList = new ArrayList<JButton>();
	public JButton register;
	public String pc[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	public JComboBox<String> combo = new JComboBox<String>(pc);
	public JPanel panel3;
	public ProgramScreen() {
		
		JFrame mainScreen = new JFrame("PC 프로그램");
		mainScreen.setSize(1000, 710);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setLayout(null);
			
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 700, 50);
		panel1.setBackground(Color.BLACK);
		panel1.setLayout(new FlowLayout());
		mainScreen.add(panel1);
			
		register = new JButton("자리 등록");
		register.setOpaque(false);
		panel1.add(register);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 50, 700, 650);
		panel2.setBackground(Color.YELLOW);
		panel2.setLayout(new FlowLayout());
		mainScreen.add(panel2);
		
		panel3 = new JPanel();
		panel3.setBounds(700, 0, 300, 700);
		panel3.setBackground(Color.GREEN);
		panel3.setLayout(null);
		mainScreen.add(panel3);
		
		for(int i = 0;i < 9;i++) {
			JButton computer = new JButton((i+1)+"번 PC");
			computer.setHorizontalAlignment(SwingConstants.CENTER);
			computer.setVerticalAlignment(SwingConstants.TOP);
			computer.setPreferredSize(new Dimension(200, 200));
			panel2.add(computer);
			
			pcList.add(computer);
		}
		
		for(int i = 0;i < 9;i++) {
			pcList.get(i).addMouseListener(new pcBtn());
		}
		
		register.addActionListener(new RegisterBtn());
		
		mainScreen.setVisible(true);

	}
	
	class pcBtn implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			panel3.repaint();
			panel3.removeAll();
			if(((JButton)e.getSource()).getBackground() != Color.GRAY) {
				JLabel waitPC = new JLabel("-대기 중-");
				waitPC.setBounds(120, 50, 100, 100);
				panel3.add(waitPC);
			}else {
				JLabel ingPC = new JLabel("-사용 중-");
				ingPC.setBounds(115, 50, 100, 100);
				panel3.add(ingPC);
				JLabel ingTime = new JLabel(TimerEx.th.timerLabel.getText());
				ingTime.setBounds(120, 100, 100, 100);
				panel3.add(ingTime);
				
				
				JLabel charge = new JLabel("-이용 요금-");
				charge.setBounds(110, 150, 100, 100);
				panel3.add(charge);
				int money = 0;
				JLabel moneyLa = new JLabel("0원");
				moneyLa.setBounds(130, 200, 100, 100);
				if(TimerEx.secDiffTime == 30) {
					money += 300;
					moneyLa.setText(money+"원");
				}
				panel3.add(moneyLa);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
	class RegisterBtn implements ActionListener{

		static JFrame registerScreen;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			registerScreen = new JFrame("자리 등록");
			registerScreen.setSize(400, 200);
			registerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			registerScreen.setLayout(null);
			
			JPanel panel4 = new JPanel();
			panel4.setBounds(50, 10, 300, 100);
			panel4.setLayout(new GridLayout(2, 2));
			registerScreen.add(panel4);
			
			JPanel panel5 = new JPanel();
			panel5.setBounds(50, 120, 300, 80);
			panel5.setLayout(new FlowLayout());
			registerScreen.add(panel5);
			
			JLabel label1 = new JLabel("PC 번호: ");
			panel4.add(label1);
			panel4.add(combo);
			
			JLabel label2 = new JLabel("사용자 폰 번호: ");
			JTextField phone = new JTextField();
			panel4.add(label2);
			panel4.add(phone);
			
			JButton successRegister = new JButton("확인");
			panel5.add(successRegister);
			
			successRegister.addActionListener(new successBtn());
			
			registerScreen.setVisible(true);
			
		}
	}
	
	class successBtn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String Num = combo.getSelectedItem().toString();
			int pcNum = Integer.valueOf(Num);
			JButton selectBtn = pcList.get(pcNum-1);
			TimerEx timer = new TimerEx(selectBtn);
			selectBtn.setBackground(Color.GRAY);
			RegisterBtn.registerScreen.dispose();;
		}
		
	}
	
	class TimerThread1 extends Thread{
	    private JLabel timerLabel;
	    public TimerThread1(JLabel timerLabel){
	        this.timerLabel = timerLabel;
	    }
	    @Override
	    public void run(){
	        int sec = 0;
	        int min = 0;
	        int hour = 0;
	        while(true){
	        	if(sec >= 60) {
	        		min++;
	        		sec = 0;
	        	}
	        	if(min >= 60) {
	        		hour++;
	        		min = 0;
	        	}
	            timerLabel.setText(Integer.toString(hour)+" : "+Integer.toString(min)+" : "+Integer.toString(sec));
	            sec++;
	            try{
	                sleep(1000);
	            }catch(InterruptedException e){return;}
	        }
	    }
	}

	public class TimerEx{
		private JLabel timerLabel;
		static TimerThread1 th;
		static long secDiffTime;
	    public TimerEx(JButton b){
	        timerLabel = new JLabel();
	        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 20));
	        th = new TimerThread1(timerLabel);
	        b.add(timerLabel);
	        long beforeTime = System.currentTimeMillis();
	        th.start();
	        long afterTime = System.currentTimeMillis();
	        secDiffTime = (afterTime - beforeTime)/1000;
	    }
	}

    
}
