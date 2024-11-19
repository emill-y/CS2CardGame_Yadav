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
}
