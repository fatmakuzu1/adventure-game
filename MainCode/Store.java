public class Store extends NormalLoacation {

    Store(Player player) {
        super(player, "The Merchant's Shop");
    }

    public boolean getLocation() {
        System.out.println("---------------------------------------------------------");
        System.out.println("The merchant greets you with a smile. 'Welcome, adventurer!'");
        System.out.println("'Your purse holds " + player.getMoney() + " gold. Come, take a look at my wares...'");
        System.out.println();
        System.out.println("1- Weapons (Sharp Steel)");
        System.out.println("2- Armor (Sturdy Protection)");
        System.out.println("3- Leave the Shop");
        System.out.println();
        System.out.print("Which counter catches your eye? ");
        int invID = input.nextInt();
        int selectItemID;
        switch (invID) {
            case 1:
                selectItemID = weaponsMenu();
                buyWeapon(selectItemID);
                break;
            case 2:
                selectItemID = armorMenu();
                buyArmor(selectItemID);
                break;
            case 3:
                System.out.println("'Come back anytime!' the merchant calls out as you leave.");
                break;
            default:
                System.out.println("'I'm not sure what you mean, friend,' the merchant says.");
                break;
        }
        return true;
    }

    public int armorMenu() {
        System.out.println("\n--- THE ARMOR RACK ---");
        System.out.println("1- Light Armor  | Protection: 1 | Cost: 15 Gold");
        System.out.println("2- Medium Armor | Protection: 3 | Cost: 25 Gold");
        System.out.println("3- Heavy Armor  | Protection: 5 | Cost: 45 Gold");
        System.out.println("4- Go Back");
        System.out.print("Choose what will protect you from the beasts: ");
        int selArmorID = input.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String armorName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                price = 15;
                armorName = "Light Armor";
                break;
            case 2:
                avoid = 3;
                price = 25;
                armorName = "Medium Armor";
                break;
            case 3:
                avoid = 5;
                price = 45;
                armorName = "Heavy Armor";
                break;
            case 4:
                System.out.println("You step away from the armor rack.");
                break;
            default:
                System.out.println("That's not a valid choice!");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmor(avoid);
                player.getInventory().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println("\nYou've purchased the '" + armorName + "'. You will now block " + player.getInventory().getArmor() + " more damage!");
                System.out.println("Remaining Gold: " + player.getMoney());
            } else {
                System.out.println("\n'Hey friend, you don't have enough gold for that!' the merchant warns.");
            }
        }
    }

    public int weaponsMenu() {
        System.out.println("\n--- THE WEAPONS RACK ---");
        System.out.println("1- Handgun | Damage: +2 | Cost: 25 Gold");
        System.out.println("2- Sword   | Damage: +3 | Cost: 35 Gold");
        System.out.println("3- Rifle   | Damage: +7 | Cost: 45 Gold");
        System.out.println("4- Go Back");
        System.out.print("Choose the weapon that will become your enemies' nightmare: ");
        int selWeapon = input.nextInt();
        return selWeapon;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String weaponName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                price = 25;
                weaponName = "Handgun";
                break;
            case 2:
                damage = 3;
                price = 35;
                weaponName = "Sword";
                break;
            case 3:
                damage = 7;
                price = 45;
                weaponName = "Rifle";
                break;
            case 4:
                System.out.println("You decide to look at other wares.");
                break;
            default:
                System.out.println("That's not a valid choice!");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println("\nThe '" + weaponName + "' is now yours! Your new total damage: " + player.getTotalDamage());
                System.out.println("Remaining Gold: " + player.getMoney());
            } else {
                System.out.println("\n'Your eyes are sharp, but your purse is light, adventurer!' says the merchant.");
            }
        }
    }
}