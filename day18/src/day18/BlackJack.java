package day18;

import java.util.*;

public class BlackJack {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Rule rule = new Rule();
		Gamer gamer = new Gamer();
		Dealer dealer = new Dealer();
		
		System.out.println("�١ڡ١ڡٺ��� ���ӡڡ١ڡ١�");
		System.out.println("ī�� �й踦 �����մϴ�.");
		System.out.println("==============================");
		gamer.selectCard(gamer, 2);
		dealer.selectCard(dealer, 2);
		Thread.sleep(1000);
		gamer.openCard();
		Thread.sleep(1000);
		dealer.openCard();
		System.out.println("==============================");
		
		while(true) {
			int YesOrNo = 0;
			Thread.sleep(1000);
			System.out.println("������ ���Դϴ�.");
			rule.dealerTotal1617(dealer);
			Thread.sleep(1000);
			System.out.println("���̸��� ���Դϴ�. ī�带 �����ðڽ��ϱ�?");
			Thread.sleep(1000);
			System.out.println("1. �� | 2. �ƴϿ�");
			YesOrNo = sc.nextInt();
			if(YesOrNo == 1) {
				gamer.selectCard(gamer, 1);
				Thread.sleep(1000);
				gamer.openCard();
			}else {
				Thread.sleep(1000);
				System.out.println("���̸Ӵ� �߰��� ī�带 ���� �ʰ� ���ʸ� ��Ĩ�ϴ�.");
			}
			if(YesOrNo == 2 && rule.bust) {
				break;
			}
		}
		Thread.sleep(1000);
		System.out.println("������ ī�带 �����մϴ�.");
		gamer.print(gamer);
		dealer.print(dealer);
		rule.whoIsWinner(gamer, dealer);
		Thread.sleep(1000);
		System.out.println("������ �����մϴ�.");
		sc.close();
		System.exit(0);
		
	}

}

class Card{
	private String pattern;
	private String rank;
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String toString() {
		return "{"+getPattern()+"}"+"{"+getRank()+"}";
	}
}

class Deck{
	private ArrayList<Card> cards;
	private static final String patternList[] = {"spades", "hearts", 
			"diamonds", "clubs"};
	private static final int patternN = 13;
	
	public Deck() {
		cards = new ArrayList<Card>();
		
		for(String pattern : patternList) {
			for(int i = 1;i <= patternN;i++) {
				Card card = new Card();
				String RANK = rankDecision(i);
				
				card.setPattern(pattern);
				card.setRank(RANK);
				cards.add(card);
			}
		}
        Random random = new Random();
		
		for(int i = 0;i < cards.size();i++) {
			int randIndex = random.nextInt(cards.size());
			Card temp = cards.get(i);
			cards.set(i, cards.get(randIndex));
			cards.set(randIndex, temp);
			
		}
	}
	
	public String rankDecision(int num) {
		if(num == 1) {
			return "A";
		}else if(num == 11) {
			return "J";
		}else if(num == 12) {
			return "Q";
		}else if(num == 13) {
			return "K";
		}else {
			return String.valueOf(num);
		}
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void print() {
		for(Card c : cards) {
			System.out.println(c.toString());
		}
	}
}

class Rule{
	public boolean dealer1617;
	public boolean bust;
	
	public int sumPoint(Player p) throws InterruptedException {
		p.total = 0;
		for(Card c : p.ownDeck) {
			switch(c.getRank()){
			case "A":
				p.total += 1;
				break;
			case "J":
				p.total += 10;
				break;
			case "Q":
				p.total += 10;
				break;
			case "K":
				p.total += 10;
				break;
			default:
				p.total += Integer.valueOf(c.getRank());
			}
		}
		
		if(p.total > 21) {
			Thread.sleep(1000);
			System.out.println(p.name()+"�� ������ 21�� �Ѿ����ϴ�."+p.name()+"�� �й��Դϴ�.");
			p.print(p);
			System.exit(0);
		}else if(p.total == 21) {
			Thread.sleep(1000);
			System.out.println("����!"+p.name()+"�� ������ 21�� �Ǿ����ϴ�."+p.name()+"�� �¸��Դϴ�!");
			p.print(p);
			System.exit(0);
		}
		return p.total;
	}
	
	public boolean dealerTotal1617(Player p) throws InterruptedException {
		if(p.total <= 16) {
			Thread.sleep(1000);
			System.out.println("������ �߰��� ī�带 �̽��ϴ�.");
			p.selectCard(p, 1);
			dealer1617 = true;
			return dealer1617;
		}else {
			Thread.sleep(1000);
			System.out.println("������ �߰��� ī�带 ���� �ʰ� ���ʸ� ��Ĩ�ϴ�.");
			dealer1617 = false;
			bust = true;
			return dealer1617;
		}
		
	}
	
	public void whoIsWinner(Player gamer, Player dealer) throws InterruptedException {
		if(gamer.total > dealer.total) {
			Thread.sleep(1000);
			System.out.println("���� "+gamer.total+" : "+dealer.total+"�� ���̸Ӱ� ����ϼ̽��ϴ�!");
		}else if(gamer.total < dealer.total) {
			Thread.sleep(1000);
			System.out.println("���� "+gamer.total+" : "+dealer.total+"�� ������ ����ϼ̽��ϴ�!");
		}else if(gamer.total == dealer.total) {
			Thread.sleep(1000);
			System.out.println("���� "+gamer.total+" : "+dealer.total+"�� ������ ���º��Դϴ�!");
		}
	}
}

abstract class Player{
	public int total;
	Rule rule = new Rule();
	Deck d = new Deck();
	protected ArrayList<Card> ownDeck;

	public Player() {
		ownDeck = new ArrayList<Card>();
	}
	
	public void selectCard(Player p, int selectNum) throws InterruptedException {
		for(int i = 1;i <= selectNum;i++) {
			Card nextCard = d.getCards().remove(d.getCards().size()-1);
			ownDeck.add(nextCard);
		}
		rule.sumPoint(p);
		
	}
	
	public ArrayList<Card> getPlayerDeck() {
		return ownDeck;
	}
	
	public String toString() {
		return "{"+getPlayerDeck()+"}";
	}
	
	public void print(Player p) throws InterruptedException {
		System.out.println("------"+p.name()+"�� ��------");
		for(Card c : ownDeck) {
			System.out.print(c.toString());
		}
		System.out.println("");
	}
	
	abstract void openCard();
	abstract String name();
}

class Gamer extends Player{

	@Override
	void openCard() {
		System.out.println("------���̸��� ��------");
		for(Card c : ownDeck) {
			System.out.print(c.toString());
		}
		System.out.println("");
	}

	@Override
	String name() {
		return "���̸�";
	}
}

class Dealer extends Player{

	@Override
	void openCard() {
		Random r = new Random();
		System.out.println("------������ ��------");
		System.out.println(ownDeck.get(r.nextInt(ownDeck.size())));
	}

	@Override
	String name() {
		return "����";
	}
}
