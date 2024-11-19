//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    //Declare Instance Variables
    private static Player player;
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
        player.setPoints(100);
        int bet = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("You have " + player.getPoints() + " points. How much would you like to bet?");
        bet = s.nextInt();
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        System.out.println(player.toString());
        

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Nice to Meet you, " + name + "! Let's learn how to play.");
        printInstructions();
        Game game = new Game(name);
        playGame(game);
    }
}

