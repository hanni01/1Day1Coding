package day25;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class Q3_2 extends JFrame{
  Vector<Point> v = new Vector<Point>();
  public Q3_2(){
    setTitle("Q3");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container c = getContentPane();
    c.setLayout(null);
    MyLabel bar = new MyLabel();
    c.add(bar);

    c.addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent e){
        v.add(new Point(e.getX(),e.getY()));
        bar.setText("("+e.getX()+", "+e.getY()+")");
        System.out.println("Left mouse button pressed at ("+e.getX()+", "+e.getY()+")");
      }
    });
    c.addKeyListener(new KeyAdapter(){
      public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
          System.out.println(v.size()+" histories of click");
          for(int i=v.size()-1; i>=0; i--){
            Point p = v.get(i);
            System.out.println(p);
          }
        }
      }
    });

    setSize(500,500);
    setVisible(true);
    c.requestFocus();
  }
  public static void main(String[] args){
    new Q3();
  }
  class Point{
    private int x,y;
    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
    public String toString(){
      return "(" + x + "," + y + ")";
    }
  }
  class MyLabel extends JLabel{
    public MyLabel(){
      setLocation(0,0);
      setSize(200,10);
      setText("("+getX()+","+getY()+")");
    }
  }
}


