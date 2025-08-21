public class SafetyHouse extends NormalLoacation{
    SafetyHouse(Player player){
        super(player, "Safety House");

    }
    public boolean getLocation(){
        System.out.println("Your Healthy: "+player.getHealthy());
        player.setHealthy(player.getRealHealthy());
        System.out.println("Now, You are in Safety House ");
        System.out.println("You are 100% healthy , Healthy: "+player.getHealthy());
        
        
        return true;
    }
    
}
