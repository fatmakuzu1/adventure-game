public abstract class NormalLoacation extends Location {
    

    NormalLoacation(Player player,String name){
        super(player);
        this.name = name;

    }
    public boolean getLocation(){
        return true;
    }
    
}
