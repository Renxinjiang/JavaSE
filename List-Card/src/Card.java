//一副扑克牌，不包含大小王，共52张

/**
 * 1.买一副牌，按花色A-K
 * 2.洗牌
 * 3.三个玩家，每个人抓5张牌（一人抓一张，轮流抓）
 * 4.问方片A在谁手中，则认为输了
 */

public class Card {
    public int rank;  //排面值
    public String suit; //花色

    public Card(int rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    //为了打印出来的效果，需要覆写toString方法

    @Override
    public String toString() {
        String r;
        if (rank == 1){
            r = "A";
        }else if (rank == 11){
            r = "J";
        }else if (rank == 12){
            r = "Q";
        } else if (rank == 13){
            r = "K";
        }else{
            r = String.valueOf(rank);
        }
        return String.format("[%s %s]",suit,r);
    }
    //进行值语义相等判断，需要覆写equals方法

    @Override
    public boolean equals(Object obj) {
        //this和obj是否语义相等
        if (obj == null){
            return false;
        }
        //如果obj不是一个Card类的对象
        if (!(obj instanceof Card)){
            return false;
        }
        //因为obj没有rank属性，因此需要向下转型
        //this.rank = obj.rank
        Card o = (Card)obj;
        return rank == o.rank && suit.equals(o.suit);
    }
}

