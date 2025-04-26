import java.util.ArrayList;

public class Player extends Floor{

    protected ArrayList <Objects> inventory;

    public Player(){
        super();
        this.inventory = new ArrayList <Objects>();
    }

    public boolean harmonize(){
        System.out.println("The radiator's tune and yours blend together to create a wonderful soothing melody. The radiator is pleased and releases you. Hear that? That's the sound of freedom.");
        return true;
    }

    public boolean backflip(){
        if (this.activeRoom == floorMap.get(9)){
            System.out.println("That was an awesome backflip! You land in the balls and feel a cold piece of metal poking into your behind. How embarassing! Hopefully nobody saw. You look under you to investigate and find that you backflipped onto a key!");
            return true;
        } else{
            System.out.println("Epic backflip. Okay, Benson Boone! If only you were really Benson Boone he would probably know what to do. Maybe it's time to try a new move.");
            return false;
        }
    }

    public Room goNorth(Room activeRoom){
        if (activeRoom.getNeighbor("NORTH") != null){
            activeRoom = activeRoom.getNeighbor("NORTH");
            String roomName = activeRoom.getName();
            System.out.println("You have entered " + roomName + ".");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public Room goEast(Room activeRoom){
        if (activeRoom.getNeighbor("EAST") != null){
            activeRoom = activeRoom.getNeighbor("EAST");
            String roomName = activeRoom.getName();
            System.out.println("You have entered " + roomName + ".");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public Room goSouth(Room activeRoom){
        if (activeRoom.getNeighbor("SOUTH") != null){
            activeRoom = activeRoom.getNeighbor("SOUTH");
            String roomName = activeRoom.getName();
            System.out.println("You have entered " + roomName + ".");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public Room goWest(Room activeRoom){
        if (activeRoom.getNeighbor("WEST") != null){
            activeRoom = activeRoom.getNeighbor("WEST");
            String roomName = activeRoom.getName();
            System.out.println("You have entered " + roomName + ".");
            return activeRoom;
        } else{
            System.out.println("Ouch! You just ran into a wall.");
            return activeRoom;
        }
    }

    public String lookAround(Room activeRoom){
        return activeRoom.getDescription();
    }


}
