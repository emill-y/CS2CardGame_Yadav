import java.util.ArrayList;

//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024
public class Player {
    //Declare Instance Variables
    private ArrayList<Card> hand;
    private int points;
    private String name;
    private boolean isStanding;
    //Constructor
    public Player(String name, ArrayList<Card> hand) {
        this.points = 100;
        this.hand = hand;
        this.name = name;
        this.isStanding = false;
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
    //Resets the Hand
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
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
    //Stores if the player is standing or not.
    public void setIsStanding(boolean b){
         this.isStanding = b;
    }
    //Returns if the player is standing or not.
    public boolean getIsStanding(){
        return isStanding;
    }
    //Prints the players hand
    public void printCards() {
        String handCards = "";
        for (Card card : hand) {
            handCards += card + "  ";
        }
        System.out.println("Here is your hand: " + handCards);
    }
    //Checks if the player has an ace in their hand.
    public boolean hasAce(){
        for (Card card : hand) {
            if (card.getValue() == 1) {
                return true;
            }
        }
        return false;
    }
    //Adds the sum of the players cards in their hand
    public int sumCards() {
        int cardSum = 0;
        for (Card card : hand) {
            cardSum += card.getValue();
        }
        //Sets the value of the ace equal to 11 if the value does not exceed 21.
        if (hasAce() && !isOver21(cardSum + 10)) {
            cardSum += 10;
        }
        return cardSum;
    }
    //Checks if the players total has surpassed 21.
    public boolean isOver21(int cardSum) {
        if (cardSum > 21) {
            return true;
        }
        else {
            return false;
        }
    }
}
