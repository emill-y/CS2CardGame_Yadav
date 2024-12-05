//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024

public class Card {
    //Declaration of Instance Variables
    private String rank;
    private String suit;
    private int value;

    //Constructor for All Values
    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }
    //Constructor for The Rank
    public Card(String rank) {
        this.rank = rank;
    }
    //Constructor for The Value
    public Card(int value) {
        this.value = value;
    }
    //Gettor Method for Rank
    public String getRank() {
        return rank;
    }
    //Getter Method for Suit
    public String getSuit() {
        return suit;
    }
    //Getter Method for Value
    public int getValue() {
        int points = value;
        //Sets the point-value of all face cards to ten
        if (value > 10) {
            points = 10;
        }
        return points;
    }
    //Setter Method for Rank
    public void setRank(String rank) {
        this.rank = rank;
    }
    //Setter Method for Suit
    public void setSuit(String suit) {
        this.suit = suit;
    }
    //Setter Method for Value
    public void setValue(int value) {
        this.value = value;
    }
    //Method to Correspond Card's Value With its Full Name
    public String valueToName(int i){
        String[] cardNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Jack", "Queen", "King"};
        return cardNames[i];
    }
    //To String Method
    @java.lang.Override
    public java.lang.String toString() {
        String rankName  = valueToName(this.value - 1);
        return rankName + " of " + suit;
    }
}
