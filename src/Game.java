//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024

import java.util.Scanner;

public class Game {
    //Declare Instance Variables
    private Player player;
    private Deck deck;

    public Game(String name) {
        this.player = new Player(name);
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        this.deck = new Deck(ranks, suits, values);

    }

    public static void printInstructions() {
        System.out.println("Instructions Here!");
    }

    public static void playGame(Game game) {
        //Code to play game here
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

