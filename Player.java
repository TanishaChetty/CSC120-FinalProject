import java.util.ArrayList;

public class Player extends Floor{

    protected ArrayList <Objects> inventory;
    Objects keyOne = new Objects ("keyOne");
    Objects keyTwo = new Objects ("keyTwo");
    Objects keyThree = new Objects ("keyThree");

    public Player(){
        super();
        this.inventory = new ArrayList <Objects>();
    }

    public boolean harmonize(){
        System.out.println("The radiator's tune and yours blend together to create a wonderful soothing melody. The radiator is pleased and releases you. Hear that? That's the sound of freedom.");
        return true;
    }

    public boolean backflip(){
        if (activeRoom == floorMap.get(8)){
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

    public Boolean goPee(Room activeRoom){
        if (activeRoom.getName() == "Bathroom"){
            return true;
        } else{
            System.out.println("GROSS! What are you doing?? You freak! You can't do that here!");
            return false;
        }
    }

    public Boolean flush(Room activeRoom){
        if (activeRoom.getName() == "Bathroom"){
            return true;
        } else{
            System.out.println("Flush what? Don't answer that...");
            return false;
        }
    }

    public Boolean washHands(Room activeRoom){
        if (activeRoom.getName() == "Bathroom"){
            return true;
        } else{
            System.out.println("Not sure what you're trying to wash your hands with but it doesn't seem to be working.");
            return false;
        }
    }

    public void pickUp (Room activeRoom, Boolean foundKeyOne, Boolean foundKeyTwo, Boolean foundKeyThree){
        if (activeRoom.getName() == "Basement Cupboard" && foundKeyOne == true){
            if (this.inventory.contains(keyOne)){
                System.out.println("You already have this key.");
            } else{
                System.out.println("Nice! You just picked up a key!");
                this.inventory.add(keyOne);
            }
        } else if (activeRoom.getName() == "Ball pit" && foundKeyTwo == true){
            if (this.inventory.contains(keyOne)){
                System.out.println("You already have this key.");
            } else{   
                System.out.println("Nice! You just picked up a key!");
                this.inventory.add(keyTwo);
            }
        } else if (activeRoom.getName() == "Bathroom" && foundKeyThree == true){
            if (this.inventory.contains(keyOne)){
                System.out.println("You already have this key.");
            } else{
                System.out.println("Nice! You just picked up a key!");
                this.inventory.add(keyThree);
            }
        } else{
            System.out.println("Hmmm... doesn't seem to be working.");
        }
    }

    public Boolean putDown(){
        if (this.inventory.contains(keyOne)||this.inventory.contains(keyTwo)||this.inventory.contains(keyThree)){
            System.out.println("You put down the key and you dropped everything you were carrying! Oops! Your inventory is now empty. Retrace your steps to get your items back.");
            this.inventory.clear();
            return true;
        } else{
            return false;
        }
    }

    public Boolean useKeys(){
        if (this.inventory.contains(keyOne)&&this.inventory.contains(keyTwo)&&this.inventory.contains(keyThree)){
            return true;
        } else{
            System.out.println("Stop right there buster! The amount of keys you have doesn't seem to match the amount of keyholes. You're still stuck!!");
            return false;
        }
    }




}
