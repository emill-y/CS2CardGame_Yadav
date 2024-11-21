import java.util.ArrayList;

//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024
public class Player {
    //Declare Instance Variables
    private ArrayList<Card> hand;
    private int points;
    private String name;
    //Constructor
    public Player(String name, ArrayList<Card> hand) {
        this.points = 0;
        this.hand = hand;
        this.name = name;
    }
    //Constructor
    public Player(String name) {
        this.points = 0;
        this.name = name;
    }
    //Gets Hand
    public ArrayList<Card> getHand() {
        return hand;
    }
    //Gets Points
    public int getPoints() {
        return points;
    }
    public void setPoints(int val) {
        points += val;
    }
    //Gets Name
    public String getName() {
        return name;
    }
    //Adds Val Points to Players Point Total
    public void addPoints(int val) {
        this.points += val;
    }
    //Adds a Card to Players Hand
    public void addCard(Card card) {
        hand.add(card);
    }
    //To String Method
    public String toString() {
        return name + " has " + points + " points /n"  + name  + "'s cards: "
                + hand;
    }
    public void printCards() {
        System.out.println("Here is your hand: " + hand);
    }
    public boolean hasAce(){
        for (Card card : hand) {
            if (card.getValue() == 1) {
                return true;
            }
        }
        return false;
    }
    public void sumCards() {
        int cardSum = 0;
        for (Card card : hand) {
            cardSum += card.getValue();
        }
        System.out.println("The sum of your cards is " + cardSum);
        if (hasAce() && !isOver21(cardSum + 10)) {
            System.out.println("Or, it could be " + cardSum + 10);
        }
    }

    public boolean isOver21(int cardSum) {
        if (cardSum > 21) {
            return true;
        }
        else {
            return false;
        }
    }
}
