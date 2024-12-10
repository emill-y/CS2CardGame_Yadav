//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Class Allowing User to PLay Game
public class Game {
    //Declare Instance Variables
    private static Player player;
    private static Player dealer;
    private static Deck deck;
    private static int bet;

    //Constructor initializing game
    public Game(String name) {
        //Creates a new player
        player = new Player(name);
        //Initializes valid ranks, suits, and values for the game deck.
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        deck = new Deck(ranks, suits, values);

    }
    //Shifts the screen to declutter the users view.
    public static void moveScreen() {
        System.out.println("\f");
    }
    //Prints the instructions of the game, Blackjack
    public static void printInstructions() {
        moveScreen();
        waitSeconds(2);
        //Introduces Basic Rules
        System.out.println("\nRules of Blackjack:\n" +
                "The goal of blackjack is simple.  All one needs to do to win is have a higher hand value than the " +
                "dealer, without going over 21. \nPlayers are dealt two cards and can then choose to “hit” (receive additional " +
                "cards) or “stand” (keep their current hand).\nThe dealer also receives two cards, but only one is face up.\n" +
                "\n" +
                "If a player’s hand exceeds 21, they “bust” and lose the game. If the dealer busts, all remaining players" +
                " win.\nIf neither the player nor the dealer busts, the player with the highest hand value wins.");
        waitSeconds(5);
        moveScreen();
        //Shifts Screen and goes into more detail.
        System.out.println("\n\n\nLet's get into some more detail!");
        System.out.println("\nPlace your bet: Before the cards are dealt, players must place a bet. The minimum and maximum bets are usually posted on the table.\n" +
                "Receive your cards: Once all bets have been placed, the dealer will deal two cards to each player, face up.\n" +
                "Decide to hit or stand: After receiving your two cards, you can choose to “hit” and receive additional cards or “stand” and keep your current hand.\n" +
                "Dealer’s turn: After all players have had their turn, the dealer will reveal their face-down card and hit or stand according to predetermined rules.\n" +
                "Determine the winner: If neither the player nor the dealer busts, the person with the highest hand value wins.");


    }
    //Pauses a Certain amount of Seconds before continuing
    public static void waitSeconds(int seconds) {
        try
        {
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch(InterruptedException e)
        {
            //break;
        }
    }

    //Implements the main playing of the game
    public static void playGame(Game game) {
        //Code to play game here
        //Initializes game at Round 0
        int round = 0;
        //Continue while the user still has money (Still playing the game)
        while(!gameisOver()){
            waitSeconds(2);
            round++;
            //Tells user what round they are on
            System.out.println("\n\nRound " + round + " of Blackjack.");
            //User can make their bets at the beginning of the round
            game.bet();
            //initial turn for player and dealer
            hitTurn(player);
            dealerTurn();
            //While the user still wants to "hit", continue
            while(askTurn()){
                //If the player is not standing, and does not exceed 21, continue to hit
                if (!player.getIsStanding() && player.sumCards() < 21) {
                    hitTurn(player);
                    //Allow the dealer to go as well, along with the player
                    dealerTurn();
                }

            }
            //Once the player no longer wishes to hit, they will stand
            standTurn(player,dealer);
            //Resets the players hand, and other game values to continue playing
            resetGame();
        }
    }

    //Allows user to make a bet.
    public void bet() {
        Scanner s = new Scanner(System.in);
        System.out.println("You have " + player.getPoints() + " points. How much would you like to bet?");
        bet = s.nextInt();
        s.nextLine();
    }

    //Asks the user if they would prefer to hit or stand, returns true if they want to hit
    //Returns false if they want to stand or cannot hit as their cards value aldready exceeds 21
    public static boolean askTurn() {
        if (player.sumCards() >= 21 || player.getIsStanding()) {
            return false;
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to hit or stand?");
        String response = s.nextLine();
        return response.equals("hit");
    }

    //Lets the dealer take their turn
    public static void dealerTurn() {
        //If the dealers sum of their cards is less than 17, continue to hit
        if (dealer.getHand() == null || dealer.sumCards() < 17 ) {
            //On their first turn, the dealer recieves 2 cards
            if(dealer.getHand().isEmpty()) {
                dealer.addCard(deck.deal());
                System.out.println("One of the dealers cards is: " + dealer.getHand().getFirst());
            }
            dealer.addCard(deck.deal());
        }
        //If the dealer is standing, stand turn.
        else {
            dealer.setIsStanding(true);
            standTurn(dealer, player);
        }

    }
    //Allows the player to hit.
    public static void hitTurn(Player name){
        //If it is the players first turn, add two cards.
        if(name.getHand().isEmpty()) {
            name.addCard(deck.deal());
            name.addCard(deck.deal());
            name.printCards();
            //If the player scores a 21 on their first turn, print Blackjack
            if (player.sumCards() == 21){
                System.out.println("BLACKJACK!!");
            }
        }
        else {
            name.addCard(deck.deal());
            name.printCards();
        }
        //Print the sum of the players cards
        System.out.println("The Sum of your cards is: " + name.sumCards());

    }
    //When the player or dealer has chosen to stand:
    public static void standTurn(Player name, Player otherName){
        //Save the player or dealers choice to stand
        name.setIsStanding(true);
        //If the other player is also standing, or the player has busted
        if (otherName.getIsStanding() || (player.sumCards() >= 21 && dealer.getIsStanding())) {
            //Print out the sum of cards for the player and dealer
            System.out.println("You have a total of " + player.sumCards() + " and the dealer has a total of " + dealer.sumCards());
            //If the player won the round, display victory message and add bet.
            if(roundisWon()){
                System.out.println("Because of that, you won the game! Your points have been added.");
                player.addPoints(bet);
                System.out.println("The dealer currently has " + dealer.getPoints()+ " points.");
                resetGame();

            }
            //Else, if the dealer won, display losing message and give dealer income.
            else {
                System.out.println("Because of that, you LOST the game! Your points have been subtracted- and given to the dealer...");
                player.addPoints(-bet);
                dealer.addPoints(bet);
                System.out.println("The dealer now has " + dealer.getPoints()+ " points.");
                resetGame();


            }
        }
        //If the dealer is not standing yet, contine to have dealers turns until they have chosen to stand
        else {
            while(!dealer.getIsStanding()) {
                dealerTurn();
            }
        }
        //If the player no longer has any money left to bet, end game
        if (gameisOver()) {
            System.out.println("Looks like you have gambled away all of your money... Better luck next time?");
            System.exit(0);
        }

    }
    //Reset game in between rounds
    public static void resetGame() {
        //Give players empty hands, remove all cards currently in theri hand
        ArrayList<Card> newHand = new ArrayList<Card>();
        player.setHand(newHand);
        dealer.setHand(newHand);
        //Set the players bet equal to zero
        bet = 0;
        //The players will no longer be standing
        player.setIsStanding(false);
        dealer.setIsStanding(false);
    }
    //Check if the game is over
    public static boolean gameisOver() {
        //If the player no longer has any points, the game is over.
        return player.getPoints() < 1;
    }
    //Boolean to check if the round is won.
    public static boolean roundisWon(){
        int playerSum = player.sumCards();
        int dealerSum = dealer.sumCards();
        //If the player has not busted, and the players sum is higher, the player wins.
        if (!player.isOver21(playerSum) && !dealer.isOver21(dealerSum) && playerSum > dealerSum ){
            return true;
        }
        //Returns true if the player has not busted, and the dealer has busted- and false if vice versa
        return !player.isOver21(playerSum) && dealer.isOver21(dealerSum);
    }
    //Welcomes the user to the game
    public static void welcomeUser() {
        System.out.println("Welcome to Blackjack!");
        Scanner s = new Scanner(System.in);
        //Collects the users name
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Nice to Meet you, " + name + "! Let's learn how to play.");
        //Initializes a new game
        Game game = new Game(name);
        //Initialzes new hands for the players
        ArrayList<Card> playerHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        //Initializes the player and the dealer
        player = new Player(name, playerHand);
        dealer = new Player(name, dealerHand);
        //Prints the instructions
        printInstructions();
        //Begins the game
        playGame(game);
    }
    //Main Function
    public static void main(String[] args) {
        //Begins game by welcoming user.
        welcomeUser();
    }
}

