import java.util.Scanner;

public class Player {
    private int damage, healthy, money, realHealthy;
    private String playerName, charName;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        switch (charMenu()) {
            case (1): //Selected Samurai
                initPlayer("Samurai", 5, 21, 15);
                break;
            case (2): //Selected Archer
                initPlayer("Archer", 7, 18, 20);
                break;
            case (3): //Selected Knight
                initPlayer("Knight", 8, 24, 5);
                break;
            default:
                initPlayer("Samurai", 5, 21, 15); // Default to Samurai if input is invalid
                break;
        }
        System.out.println("\n---------------------------------------------------------");
        System.out.println("You have chosen the path of the " + getCharName() + "!");
        System.out.println("Damage: " + getDamage() + " | Health: " + getHealthy() + " | Gold: " + getMoney());
        System.out.println("---------------------------------------------------------");
    }

    public void initPlayer(String name, int dmg, int hlthy, int mny) {
        setCharName(name);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setRealHealthy(hlthy);
    }

    public int charMenu() {
        System.out.println("\n=========================================================");
        System.out.println("The journey awaits, " + this.getPlayerName() + ". Choose your hero:");
        System.out.println("=========================================================");
        System.out.println("1. Samurai | A master of the blade from the far east. Balanced and resilient.");
        System.out.println("\t > Stats | Damage: 5, Health: 21, Gold: 15");
        System.out.println();
        System.out.println("2. Archer  | A keen-eyed marksman who strikes from afar. Agile and wealthy.");
        System.out.println("\t > Stats | Damage: 7, Health: 18, Gold: 20");
        System.out.println();
        System.out.println("3. Knight  | A stalwart warrior in heavy armor. A true powerhouse.");
        System.out.println("\t > Stats | Damage: 8, Health: 24, Gold: 5");
        System.out.println("=========================================================");
        System.out.print("Declare your choice (1-3): ");
        int charID = input.nextInt();

        while (charID < 1 || charID > 3) {
            System.out.print("That path is not open to you. Choose your destiny (1-3): ");
            charID = input.nextInt();
        }

        return charID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if (healthy < 0) {
            healthy = 0;
        }
        this.healthy = healthy;
    }



    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inv) {
        this.inventory = inv;
    }

    public int getRealHealthy() {
        return realHealthy;
    }

    public void setRealHealthy(int realHealthy) {
        this.realHealthy = realHealthy;
    }
}