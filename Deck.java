import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;//Class Card
	private ArrayList<Card> usedCards;//已經使用過的牌
	public int nUsed=0;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int deck=1;deck<=nDeck;deck++)
		{
			for(Card.Suit s:Card.Suit.values())
			{
				for(int rank=1;rank<=13;rank++)
					{
					Card card = new Card(s,rank);
					cards.add(card);
					}
			}
		}
		nUsed=0;
		shuffle();
	}	
	public  void shuffle()
	{
		usedCards=new ArrayList<Card>();
		Random rnd = new Random();
		for(int i=0;i<=51;i++)
			{
			int j = rnd.nextInt(cards.size());//隨機從1-51抽出一個號碼
			usedCards.add(cards.get(j));//把取出來的號碼放到已經使用過的陣列當中
			cards.remove(cards.get(j));//把已經隨機選出來的數字拿出來
			}
		for(int i=0;i<=51;i++)
		{
			cards.add(usedCards.get(i));//把已經取出的卡片放回去原本的那副牌中
		}
		for(int i=0;i<=51;i++)
		{
			usedCards.remove(usedCards.get(0));//把已經取出的卡片全部放回去原本的那副牌中
		}
		
	}
	public Card getOneCard()
	{
		//usedCards=new ArrayList<Card>();
		Card c = new Card(cards.get(nUsed).getSuit(),cards.get(nUsed).getRank());//從cards裡面取出一張卡的花色和號碼
		usedCards.add(cards.get(nUsed));//把發出去的卡片放到已經使用過的卡片中
		nUsed++;//每發一次牌，使用過牌的數量便加一
		if(nUsed==52)//表示卡已經被發完了，需要洗牌
			shuffle();
		return c;
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}



