import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardGame {
    private static final String[] SUIT = {"♥","♠","♦","♣"};
    //创建一副牌
    public static List<Card> buyDeck(){
        List<Card> deck = new ArrayList<>(52);
        for(int i = 0;i < 4;i++){
            String suit = SUIT[i];
            for (int j = 1;j <= 13;j++){
                int rank = j;
                Card card = new Card(rank,suit);
                //将牌放入deck中
                deck.add(card);
            }
        }
        return deck;
    }

    //洗牌
    private static void swap(List<Card>deck,int i,int j){
        Card t = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,t);
    }
    public static void shuffle(List<Card> deck){
        Random random = new Random(20190911);
        for (int i = deck.size()-1;i > 0; i--){
            int r = random.nextInt(i);
            swap(deck,i,r);
        }
    }

    //三个玩家，每个人抓5张牌（一人抓一张，轮流抓）
    private static void send(List<List<Card>> hands, List<Card> deck, int numPerson, int numCard) {
        //调用get之前，一定要保证元素是存在的
        //相当于[] ---> [ [] ,[],[]]
        for (int k = 0;k < numPerson;k++){
            hands.add(new ArrayList<>());
        }
        for (int i = 0;i < numCard;i++){
            for (int j = 0;j < numPerson;j++){
                //抓牌
                Card card = deck.remove(0);
                hands.get(j).add(card);
            }

        }
    }

    //方片A在谁手中，则认为输了
    private static void play(List<List<Card>> hands) {
        Card card = new Card(1,"♦");
        for (int i = 0;i < hands.size();i++){
            if( hands.get(i).contains(card) ){
               System.out.println(String.format("%d 输了",i));
               return;
            }
            /*
            for (int j = 0;j < hands.get(i).size();j++){
                Card handCard = hands.get(i).get(j);
                if (card.equals(handCard)){
                    System.out.println("%d 输了");
                    return;
                }
            }
            */
        }
    }
    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        List<List<Card>> hands = new ArrayList<>();
        send(hands,deck,3,5);
        System.out.println(hands.get(0));
        System.out.println(hands.get(1));
        System.out.println(hands.get(2));
        System.out.println(deck);
        play(hands);
    }

}
