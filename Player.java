import java.util.ArrayList;

public class Player extends Floor{

    protected ArrayList <Objects> inventory;

    public Player(){
        super();
        this.inventory = new ArrayList <Objects>();
    }

    public boolean harmonize(){
        return true;
        //if //you are chained to radiator then sets moveability to true;
            //return true
        //else // "That's a nice tune. If only music could really solve every problem. It's not solving this one." and return false;
    }

    public boolean backflip(){
        if (this.activeRoom == floorMap.get(9)){
            //"That was an awesome backflip! You land in the balls and feel a cold piece of metal poking into your behind. How embarassing! Hopefully nobody saw. You look under you to investigate and find that you backflipped onto a key!"
            return true;
        } else{
            //"Epic backflip. Okay, Benson Boone! If only you were really Benson Boone he would probably know what to do. Maybe it's time to try a new move."
            return false;
        }
    }

    public Room goNorth(Room activeRoom){
        if (activeRoom.getNeighbor("NORTH") != null){
            activeRoom = activeRoom.getNeighbor("NORTH");
            System.out.println("You have entered " + activeRoom.get(0) + ".");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public Room goEast(Room activeRoom){
        if (activeRoom.getNeighbor("EAST") != null){
            activeRoom = activeRoom.getNeighbor("EAST");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public Room goSouth(Room activeRoom){
        if (activeRoom.getNeighbor("SOUTH") != null){
            activeRoom = activeRoom.getNeighbor("SOUTH");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public Room goWest(Room activeRoom){
        if (activeRoom.getNeighbor("WEST") != null){
            activeRoom = activeRoom.getNeighbor("WEST");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

}
