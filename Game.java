//Eisha Yadav
//CS2 Mr. Blick
//November 18, 2024
public class Game {
    //Declare Instance Variables
    private Player player;
    private Deck deck;

    public Game(String name) {
        this.player = new Player player(name);
        this.deck = deck;
    }

    public void printInstructions() {
        System.out.println("Instructions Here!");
    }

    public void playGame(Game game) {
        //Code to play game here
    }

    public static void main() {
        System.out.println("Welcome to Blackjack! Get Ready to Play...");
        Scanner s = new Scanner(System.in);
        Sys.out.println("What is you name?")
        String name = s.nextLine();
        Game game = new Game(name);
        playGame(game);
    }


}
