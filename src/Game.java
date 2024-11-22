//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {
    //Declare Instance Variables
    private static Player player;
    private static Player dealer;
    private static Deck deck;

    public Game(String name) {
        this.player = new Player(name);
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        this.deck = new Deck(ranks, suits, values);

    }

    public static void moveScreen() {
        System.out.println("\f");
    }
    public static void printInstructions() {
        moveScreen();
        waitSeconds(2);
        System.out.println("\nRules of Blackjack:\n" +
                "The goal of blackjack is simple.  All one needs to do to win is have a higher hand value than the " +
                "dealer, without going over 21. \nPlayers are dealt two cards and can then choose to “hit” (receive additional " +
                "cards) or “stand” (keep their current hand).\nThe dealer also receives two cards, but only one is face up.\n" +
                "\n" +
                "If a player’s hand exceeds 21, they “bust” and lose the game. If the dealer busts, all remaining players" +
                " win.\nIf neither the player nor the dealer busts, the player with the highest hand value wins.");
        waitSeconds(5);
        moveScreen();
        System.out.println("\n\n\nLet's get into some more detail!");
        System.out.println("\nPlace your bet: Before the cards are dealt, players must place a bet. The minimum and maximum bets are usually posted on the table.\n" +
                "Receive your cards: Once all bets have been placed, the dealer will deal two cards to each player, face up.\n" +
                "Decide to hit or stand: After receiving your two cards, you can choose to “hit” and receive additional cards or “stand” and keep your current hand.\n" +
                "Dealer’s turn: After all players have had their turn, the dealer will reveal their face-down card and hit or stand according to predetermined rules.\n" +
                "Determine the winner: If neither the player nor the dealer busts, the person with the highest hand value wins.");


    }

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
    public static void playGame(Game game) {
        //Code to play game here
        bet();
        while (askTurn()) {
            askTurn();
            dealerTurn();
        }

    }

    public static int bet() {
        int bet = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("You have " + player.getPoints() + " points. How much would you like to bet?");
        bet = s.nextInt();
        s.nextLine();
        return bet;
    }

    public static boolean askTurn() {
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to hit or stand?");
        String response = s.nextLine();
        if (response.equals("hit")) {
            hitTurn(player);
            return true;
        }
        return false;
    }

    public static void dealerTurn() {
        if (dealer.sumCards() > 17) {
            hitTurn(dealer);
        }
        else {
            standTurn(dealer, player);
        }

    }

    public static void hitTurn(Player name){
        if(name.getHand().isEmpty()) {
            name.addCard(deck.deal());
        }
        name.addCard(deck.deal());
        name.printCards();
        System.out.println("The Sum of your cards is :" + player.sumCards());
    }

    public static void standTurn(Player name, Player otherName){
        name.setIsStanding(true);
        if (otherName.getIsStanding()) {
            System.out.println("You have a total of " + player.sumCards() + " and the dealer has a total of " + dealer.sumCards());
            if(roundisWon()){
                System.out.println("Because of that, you won the game! Your points have been added.");
                player.addPoints(bet());
                System.out.println(player.getPoints());
                System.out.println(dealer.getPoints());

            }
            else {
                System.out.println("Because of that, you LOST the game! Your points have been subtracted- and given to the dealer...");
                player.addPoints(-bet());
                dealer.addPoints(bet());
                System.out.println(player.getPoints());
                System.out.println(dealer.getPoints());


            }
        }
        if (gameisOver()) {
            System.out.println("Looks like you have gambled away all of your money... Better luck next time?");
        }
        else {
            resetGame();
        }

    }

    public static void resetGame() {
        ArrayList<Card> hand = new ArrayList<Card>();
    }

    public static boolean gameisOver() {
        if (player.getPoints() < 1) {
            return true;
        }
        return false;
    }
    public static boolean roundisWon(){
        int playerSum = player.sumCards();
        int dealerSum = dealer.sumCards();
        if (!player.isOver21(playerSum) && !dealer.isOver21(dealerSum) && playerSum > dealerSum ){
            return true;
        }
        if (!player.isOver21(playerSum) && dealer.isOver21(dealerSum)) {
            return true;
        }
        return false;
    }
    public static void welcomeUser() {
        System.out.println("Welcome to Blackjack!");
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Nice to Meet you, " + name + "! Let's learn how to play.");
        Game game = new Game(name);
        ArrayList<Card> hand = new ArrayList<Card>();
        player = new Player(name, hand);
        printInstructions();
        playGame(game);
    }
    public static void main(String[] args) {
        welcomeUser();
    }
}

