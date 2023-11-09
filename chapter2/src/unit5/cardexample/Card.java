package unit5.cardexample;

public class Card {

    public final static int SPADE = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;
    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;


    private final int suit;

    private final int value;


    public Card() {
        this.suit = JOKER;
        this.value = 1;
    }

    public Card(int theValue, int theSuit) {
        if (theSuit != SPADE && theSuit != HEARTS && theSuit != DIAMONDS &&
                theSuit != CLUBS && theSuit != ACE && theSuit != JOKER) {
            throw new IllegalArgumentException("허용되지 않는 카드 게임 문양 ");
        }
        if (theSuit != JOKER && (theValue < 1 || theValue > 13)) {
            throw new IllegalArgumentException("허용되지 않는 카드게임의 값");
        }
        value = theValue;
        suit = theSuit;
    }

    public int getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String getSuitAsString() {
        switch (suit){
            case SPADE:
                return "스페이드";
            case HEARTS:
                return "하트";
            case  DIAMONDS:
                return "다이아몬드";
            case CLUBS:
                return "클로버";
            default:
                return "조커";
        }
    }

    public String getValueAsString() {
        if(suit == JOKER)
            return "" + value;
        else {
            switch (value) {
                case 1:   return "에이스";
                case 2:   return "2";
                case 3:   return "3";
                case 4:   return "4";
                case 5:   return "5";
                case 6:   return "6";
                case 7:   return "7";
                case 8:   return "8";
                case 9:   return "9";
                case 10:  return "10";
                case 11:  return "잭";
                case 12:  return "퀸";
                default:  return "킹";
            }
        }
    }

    @Override
    public String toString() {
        if (suit == JOKER) {
            if (value == 1) {
                return "조커";
            } else {
                return "조커 #" + value;
            }
        } else {
            return getValueAsString() + " " + getSuitAsString();
        }
    }
}
