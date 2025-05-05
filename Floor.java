import java.util.ArrayList;


public class Floor{

    protected ArrayList <Room>floorMap;
    protected Room activeRoom;

    /**
     * Constructor for the Floor
    */
    public Floor(){
        this.floorMap = new ArrayList <Room>();

        // initial construction of all the rooms
        floorMap.add(new Room ("Main Basement Room", "Large mostly empty room. Smells a little odd. To the north, stairs lead up out of the basement. The walls to the East and South are empty and solid looking. There is a doorway on the West wall.", null, null, null, null));
        floorMap.add(new Room ("Basement Cupboard", "Just a set of shelves behind a door, really. The doorway to the Main Basement Room is to the East. Theres something shining on the shelf to the west.", null, null, null, null));
        floorMap.add(new Room ("Meeting Room", "Sterile white walls surround a u-shaped concrete table. There are doorways on each wall except for the East wall.", null, null, null, null));
        floorMap.add(new Room ("Kitchen", "A homey vibe in here. The moss green cupbords are lit by the soft sunlight streaming throught the curtains. Doorways lead out to East and South. There are stairs leading down to the North.", null, null, null, null));
        floorMap.add(new Room ("Dining Room", "Grand room with a large oak table in the center. Doorways lead out on the South and West walls.", null, null, null, null));
        floorMap.add(new Room ("Bathroom", "It feels like you just stepped onto a sailing ship. The floors are lined with seashells and algae and the walls are decorated with rope-framed paintings. There is a door on the North wall, and a door on the West wall.", null, null, null, null));
        floorMap.add(new Room ("Bunk room", "Huge sleepover vibes in here. Filled with bunk beds and plushies and fluffy pillows. There are doorways on the North wall, East wall, and South wall.", null, null, null, null));
        floorMap.add(new Room ("Hall of mirrors", "A disorienting freaky room of mirrors. You're met with your reflection everywhere you look. You can't tell which ways the doors are. EEK!", null, null, null, null));
        floorMap.add(new Room ("Ball pit", "The floor is balls. Everything is balls. Bright, multicolored balls. It's so awesome you want to jump for joy! There are doors to the North, South, and West.", null, null, null, null));
        floorMap.add(new Room ("Entry way", "It's an entryway. Welcome. Or goodbye but probably not goodbye. You're probably stuck here. There are doorways to the North and East. There is a bigger awesomer grander doorway to the South. Maybe this one leads to freedom! It has 3 keyholes.", null, null, null, null));
        floorMap.add(new Room ("Outside", "You're free!", null, null, null, null));
        
        // attaches the neighboring rooms to each room using the resetWalls function
        this.floorMap.get(0).resetsWalls(floorMap.get(3), null, null, floorMap.get(1));
        this.floorMap.get(1).resetsWalls(null, floorMap.get(0), null, null);
        this.floorMap.get(2).resetsWalls(floorMap.get(4), null, floorMap.get(8), floorMap.get(7));
        this.floorMap.get(3).resetsWalls(floorMap.get(0), floorMap.get(4), floorMap.get(7), null);
        this.floorMap.get(4).resetsWalls(null, null, floorMap.get(2), floorMap.get(3));
        this.floorMap.get(5).resetsWalls(floorMap.get(8), null, null, floorMap.get(9));
        this.floorMap.get(6).resetsWalls(floorMap.get(7), floorMap.get(8), floorMap.get(9), null);
        this.floorMap.get(7).resetsWalls(floorMap.get(3), floorMap.get(2), floorMap.get(6), null);
        this.floorMap.get(8).resetsWalls(floorMap.get(2), null, floorMap.get(5), floorMap.get(6));
        this.floorMap.get(9).resetsWalls(floorMap.get(6), floorMap.get(5), floorMap.get(10), null);
        this.floorMap.get(10).resetsWalls(floorMap.get(9), null, null, null);


    }


    /**
     * Accessor for the room the player is currently in
     * @return Room the player is currently in
    */
    public Room getActiveRoom(){
        return activeRoom;
    }

   
    

}