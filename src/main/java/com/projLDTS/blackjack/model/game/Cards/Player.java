package com.projLDTS.blackjack.model.game.Cards;

import com.projLDTS.blackjack.gui.UserInput;
import com.projLDTS.blackjack.model.game.Decks.Deck;

public class Player extends CardSet {
    private static int credit = UserInput.getCredit();
    public Player() {
        super();
        credit =  UserInput.getCredit();
    }

    public boolean hit(Deck deck) {
        Hand currentHand = hand;
        if (currentHand.getValue() < 21) {
            System.out.println(currentHand.getValue());
            currentHand.addCard(deck);
        }
        return currentHand.getValue() <= 21;
    }
    public int stand() {
        return hand.getValue();
    }
    public boolean doubleDown(Deck deck) {
        if (hand.getHand().size() != 2 || hand.getValue() >= 21 ||
            hand.getBet() >= credit) {
            return false;
        }
        credit = credit - 2 * Integer.parseInt(UserInput.getBet().toString());
        UserInput.setCredit(credit);
        return hit(deck);
    }

    public void clearHand() {
        for (int i = 0; i < hand.getHand().size(); i++) {
            hand.removeCard(i);
        }
    }
}
