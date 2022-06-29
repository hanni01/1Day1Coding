package day04;

class TV {
	  private int size;
	  public TV(int size){//private ����� size�� �����ϱ� ���� �޼ҵ�
	     this.size = size;
	  } 
	  public void show(){
	    System.out.println("My TV is"+getSize());
	  }

	  protected int getSize() {//private ����� size�� �����ϱ� ���� �޼ҵ�
	     return size; 
	  }
	  
	}


	class IPTV extends TV{
	  private String address;
	  private String play;
	  public IPTV(String address,int size,String play){
	    super(size); //TV�� ������ TV(size) ȣ��
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
	    IPTV myTV = new IPTV("192.1.1.2", 82, "Netflix"); //public IPTV ���� ���� 
	    myTV.printProperty();
	  }
	}
