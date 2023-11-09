package unit5.cardexample;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void clear() {
        hand.clear();
    }

    public void addCard(Card c) {
        if (c == null) {
            throw new NullPointerException("널을 추가 할 수는 없습니다.");
        }
        hand.add(c);
    }

    public void removeCard(Card c) {
        hand.remove(c);
    }

    public void removeCard(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("존재하지 않는 포지션입니다. : " + position);
        }
        hand.remove(position);
    }

    public int getCardCount() {
        return hand.size();
    }

    public Card getCardCount(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("존재하지 않는 포지션입니다. : " + position);
        }
        return hand.get(position);
    }

    public void sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;
            Card c = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if (c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;
            Card c = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if (c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
}
