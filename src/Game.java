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
        this.deck = new Deck();

    }

    public static void printInstructions() {
        System.out.println("Instructions Here!");
    }

    public static void playGame(Game game) {
        //Code to play game here
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack! Get Ready to Play...");
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = s.nextLine();
        printInstructions();
        Game game = new Game(name);
        playGame(game);
    }
}

