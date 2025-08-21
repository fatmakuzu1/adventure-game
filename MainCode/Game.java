import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void login() {
        System.out.println();
        System.out.println("Welcome to the world of adventure!");
        System.out.print("Before you begin your quest, tell us your name, hero: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("========================================================");
            System.out.println("The world lies before you. Where will you venture?");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Safe House   -> A place to rest and recover your health.");
            System.out.println("2. The Store    -> Purchase powerful weapons and sturdy armor.");
            System.out.println("3. The Cave     -> A dark cavern crawling with Zombies.");
            System.out.println("4. The Forest   -> A haunted woods where Vampires stalk the shadows.");
            System.out.println("5. The River    -> A wild waterway guarded by ferocious Bears.");
            System.out.println("--------------------------------------------------------");
            System.out.print("Where do you wish to go? ");
            int locID = input.nextInt();

            while (locID < 1 || locID > 5) {
                System.out.print("That is not a known destination. Please choose from the map: ");
                locID = input.nextInt();
            }
            switch (locID) {
                case 1:
                    location = new SafetyHouse(player);
                    
                    break;
                case 2:
                    location = new Store(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafetyHouse(player);
                    break;
            }
            
           
            boolean isAlive = location.getLocation();
            if (!isAlive) {
                System.out.println("\nYour adventure has come to a tragic end... GAME OVER");
                break;
            }
        }
    }
}