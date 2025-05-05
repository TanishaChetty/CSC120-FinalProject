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


    /**
     * Indicate whether the user has used the harmonize function to free themselves from the radiator
     * @return  Boolean value indicating function has been used
    */
    public boolean harmonize(){
        System.out.println("The radiator's tune and yours blend together to create a wonderful soothing melody. The radiator is pleased and releases you. Hear that? That's the sound of freedom.");
        return true;
    }

    /**
     * Allow the user to backflip and indicate if they did so in the Ball Pit room
     * @param activeRoom the room the player is currently in
     * @return  Boolean value indicating if the function was called from the Ball Pit
    */
    public boolean backflip(Room activeRoom){
        if (activeRoom.getName() == "Ball pit"){
            return true;
        } else{
            System.out.println("Epic backflip. Okay, Benson Boone! If only you were really Benson Boone he would probably know what to do. Maybe it's time to try a new move.");
            return false;
        }
    }

    /**
     * Allow the player to move North
     * @param activeRoom the room the player is currently in
     * @return  the room the player has moved to
    */
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

    /**
     * Allow the player to move East
     * @param activeRoom the room the player is currently in
     * @return  the room the player has moved to
    */
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

    /**
     * Allow the player to move South
     * @param activeRoom the room the player is currently in
     * @return  the room the player has moved to
    */
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

    /**
     * Allow the player to move West
     * @param activeRoom the room the player is currently in
     * @return  the room the player has moved to
    */
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

    /**
     * Describes the player's surroundings. Modifies Basement Cupboard description if key has been found.
     * @param activeRoom the room the player is currently in
     * @return  the description of the player's activeRoom
    */
    public String lookAround(Room activeRoom){
        if (activeRoom.getName()!="Basement Cupboard"){
            return activeRoom.getDescription();
        } else{
            if (this.inventory.contains(keyOne)){
                return "Just a set of shelves behind a door, really. The doorway to the Main Basement Room is to the East.";
            } else{
                return activeRoom.getDescription();
            }
        }
    }

    /**
     * Allows the player to pee; first step to obtaining KeyTwo
     * @param activeRoom the room the player is currently in
     * @return  Boolean value based on whether they peed in the Bathroom
    */
    public Boolean goPee(Room activeRoom){
        if (activeRoom.getName() == "Bathroom"){
            return true;
        } else{
            System.out.println("GROSS! What are you doing?? You freak! You can't do that here!");
            return false;
        }
    }

    /**
     * Allows the player to flush; second step to obtaining KeyTwo
     * @param activeRoom the room the player is currently in
     * @return  Boolean value based on whether they flushed in the Bathroom
    */
    public Boolean flush(Room activeRoom){
        if (activeRoom.getName() == "Bathroom"){
            return true;
        } else{
            System.out.println("Flush what? Don't answer that...");
            return false;
        }
    }

    /**
     * Allows the player to pee; final step to obtaining KeyTwo
     * @param activeRoom the room the player is currently in
     * @return  Boolean value based on whether they washed their hands in the Bathroom
    */
    public Boolean washHands(Room activeRoom){
        if (activeRoom.getName() == "Bathroom"){
            return true;
        } else{
            System.out.println("Not sure what you're trying to wash your hands with but it doesn't seem to be working.");
            return false;
        }
    }
    /**
     * Allows the player to pick up keys
     * @param activeRoom the room the player is currently in
     * @param foundKeyOne Boolean value indicating whether player has found KeyOne
     * @param foundKeyTwo Boolean value indicating whether player has found KeyTwo
     * @param foundKeyThree Boolean value indicating whether player has found KeyThree
    */
    public void pickUp (Room activeRoom, Boolean foundKeyOne, Boolean foundKeyTwo, Boolean foundKeyThree){
        if (activeRoom.getName() == "Basement Cupboard" && foundKeyOne == true){
            if (this.inventory.contains(keyOne)){
                System.out.println("You already have this key.");
            } else{
                System.out.println("Nice! You just picked up a key!");
                this.inventory.add(keyOne);
            }
        } else if (activeRoom.getName() == "Ball pit" && foundKeyTwo == true){
            if (this.inventory.contains(keyTwo)){
                System.out.println("You already have this key.");
            } else{   
                System.out.println("Nice! You just picked up a key!");
                this.inventory.add(keyTwo);
            }
        } else if (activeRoom.getName() == "Bathroom" && foundKeyThree == true){
            if (this.inventory.contains(keyThree)){
                System.out.println("You already have this key.");
            } else{
                System.out.println("Nice! You just picked up a key!");
                this.inventory.add(keyThree);
            }
        } else{
            System.out.println("Hmmm... doesn't seem to be working.");
        }
    }

    /**
     * Empties the player's inventory
     * @preturn returns Boolean based on whether the inventory was emptied
    */
    public Boolean putDown(){
        if (this.inventory.contains(keyOne)||this.inventory.contains(keyTwo)||this.inventory.contains(keyThree)){
            System.out.println("You put down the key and you dropped everything you were carrying! Oops! Your inventory is now empty. Retrace your steps to get your items back.");
            this.inventory.clear();
            return true;
        } else{
            return false;
        }
    }

    /**
     * Allows player to use keys in the exit door
     * @preturn Boolean based on whether the player's inventory contains all three keys
    */
    public Boolean useKeys(){
        if (this.inventory.contains(keyOne)&&this.inventory.contains(keyTwo)&&this.inventory.contains(keyThree)){
            return true;
        } else{
            System.out.println("Stop right there buster! The amount of keys you have doesn't seem to match the amount of keyholes. You're still stuck!!");
            return false;
        }
    }




}
