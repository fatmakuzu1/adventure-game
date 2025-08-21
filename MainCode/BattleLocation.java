

public abstract class BattleLocation extends Location {
    protected Obstacle obstacle;
    protected String award;
   
    
    BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int obsCount = obstacle.obstacleCount();
        System.out.println("You are now at: " + this.getName());
        System.out.println("Be careful! " + obsCount + " " + obstacle.getName() + "(s) live here!");
        playerStats();
        enemyStats();
        System.out.print("(F)ight or (R)un: ");
        String selCase = input.nextLine();
        selCase = selCase.toUpperCase();

        if (selCase.equals("F")) {
            if (combat(obsCount)) {
                
                System.out.println("You have defeated all the enemies at " + this.getName() + "!");

                // THE LOCATION AWARD IS GIVEN HERE
                if (this.award.equals("Food") && !player.getInventory().isFood()) {
                    System.out.println("You have earned the '" + this.award + "' award!");
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Firewood") && !player.getInventory().isFirewood()) {
                    System.out.println("You have earned the '" + this.award + "' award!");
                    player.getInventory().setFirewood(true);
                } else if (this.award.equals("Water") && !player.getInventory().isWater()) {
                    System.out.println("You have earned the '" + this.award + "' award!");
                    player.getInventory().setWater(true);
                }
                return true; 
            } else {
                
                if (player.getHealthy() <= 0) {
                    System.out.println("You have died :((");
                    return false; 
                }
                System.out.println("You have left this dangerous area.");
                return true;
            }
        } else if (selCase.equals("R")) {
            System.out.println("You've fled the area!");
        } else {
            System.out.println("Invalid choice!");
        }
        return true; 
    }

    public boolean combat(int obsCount) {
       
        for (int i = 0; i < obsCount; i++) {
            obstacle.setHealth(obstacle.getOriginalHealth());
            System.out.println("\n--------------------");
            System.out.println((i + 1) + ". " + obstacle.getName() + " appeared!");

            
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
                System.out.print("(H)it or (R)un: ");
                String selCase = input.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("H")) {
                    System.out.println("You hit!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println(obstacle.getName() + " hit you!");
                        
                        int damageTaken = obstacle.getDamage() - player.getInventory().getArmor();
                        if (damageTaken < 0) {
                            damageTaken = 0;
                        }
                        player.setHealthy(player.getHealthy() - damageTaken);
                        afterHit();
                    }
                } else if (selCase.equals("R")) {
                    System.out.println("You fled from the battle!");
                    return false; 
                } else {
                    System.out.println("Invalid command!");
                }

            
                if (player.getHealthy() <= 0) {
                    return false; 
                }
            }

            if (obstacle.getHealth() <= 0) {
                System.out.println("You defeated a " + obstacle.getName() + "!");
            }
        }

        System.out.println("\nYou have cleared all the enemies in the area!");
        int totalMoneyAward = obstacle.getAward() * obsCount;
        player.setMoney(player.getMoney() + totalMoneyAward);
        System.out.println("You earned a total of " + totalMoneyAward + " money!");
        System.out.println("Current Money: " + player.getMoney());

        return true; 
    }

    public void playerStats() {
        System.out.println("\nPlayer Stats\n--------");
        System.out.println("Health: " + player.getHealthy());
        System.out.println("Damage: " + player.getTotalDamage()); 
        System.out.println("Money: " + player.getMoney());
        if (player.getInventory().getDamage() > 0) {
            System.out.println("Weapon: " + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmor() > 0) {
            System.out.println("Armor: " + player.getInventory().getArmorName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Stats\n--------");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Award: " + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Player Health: " + player.getHealthy());
        System.out.println(obstacle.getName() + " Health: " + obstacle.getHealth());
    }
}