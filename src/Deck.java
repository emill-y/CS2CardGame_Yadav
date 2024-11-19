//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024

//Import Needed Libraries
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    //Constructor
    public Deck() {
        //Create New ArrayList, Deep Copy Rather Than a Shallow Copy
        cards = new ArrayList<>();

        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // Create Cards And Add To The Deck
        for (int i = 0; i < ranks.length; i++) {
            for (String suit : suits) {
                cards.add(new Card(ranks[i], suit, values[i]));
            }
        }
        // Set cardsLeft to Total Number of Cards
        cardsLeft = cards.size();

        // Shuffles the Deck
        shuffle();
    }

    // Check if the Deck is Empty
    public boolean isEmpty() {
        return cardsLeft == 0;
    }

    // Get the Number of Cards Left in the Deck
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Deal a Card From the Deck
    public Card deal() {
        if (isEmpty()) {
            return null; // No Cards left to Deal
        }
        cardsLeft--; // Decrement cardsLeft
        return cards.get(cardsLeft); // Return the Next Card
    }

    //Implements Shuffling of the Deck
    public void shuffle() {
        // Reset cardsLeft to the total number of cards
        cardsLeft = cards.size();

        // Shuffle Cards According to Structure Given
        for (int i = cards.size() - 1; i > 0; i--) {
            int r = (int) (Math.random() * (i + 1)); // Generate a Random index Between 0 and i
            // Swap cards at indexes i and r
            Card temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }

}
