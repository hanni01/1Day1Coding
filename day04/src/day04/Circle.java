package day04;

class TV {
	  private int size;
	  public TV(int size){//private 멤버인 size에 접근하기 위한 메소드
	     this.size = size;
	  } 
	  public void show(){
	    System.out.println("My TV is"+getSize());
	  }

	  protected int getSize() {//private 멤버인 size에 접근하기 위한 메소드
	     return size; 
	  }
	  
	}


	class IPTV extends TV{
	  private String address;
	  private String play;
	  public IPTV(String address,int size,String play){
	    super(size); //TV의 생성자 TV(size) 호출
	    this.address=address;
	    this.play=play;

	  }
	  public String getAddress(){
	    return address;
	  }
	  public String getPlay(){
	    return play;

	  }
	 
	  public void printProperty(){ //
	    System.out.print("My TV is "+getSize()+" and IP address is "+address+", supports to play"+play);

	  }
	}

	public class Circle {
	  public static void main(String[] args) {
	    IPTV myTV = new IPTV("192.1.1.2", 82, "Netflix"); //public IPTV 에게 전달 
	    myTV.printProperty();
	  }
	}
