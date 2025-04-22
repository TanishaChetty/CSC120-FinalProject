import java.util.ArrayList;

public class Floor extends House{

    protected int nFloor;
    protected ArrayList <Room>floorMap;
    protected String activeRoom;

    // constructor
    public Floor(int nFloor, int activeRoom){
        this.nFloor = nFloor;
        this.floorMap = new ArrayList <Room>();
        if (this.nFloor == 0){
            floorMap.add(new Room ("Main Basement Room", "Large mostly empty room. Smells a little odd.", "stairs to kitchen", "clown", "radiator", "exit to basement cupboard"));
            floorMap.add(new Room ("Basement Cupboard", "Just a set of shelves behind a door, really.", "shelves", "exit", "shelves", "shelves with key"));
        }
        if (this.nFloor == 1){
            floorMap.add(new Room ("Meeting Room", "Sterile white walls surround a u-shaped concrete table.", "exit to dining room", "wall", "exit to ball pit", "exit to hall of mirrors"));
            floorMap.add(new Room ("Kitchen", "A homey vibe in here. The moss green cupbords are lit by the soft sunlight streaming throught the curtains.", "stairs to basement", "exit to dining room", "exit to hall of mirrors", "wall"));
            floorMap.add(new Room ("Dining Room", "Grand room with a large oak table in the center", "wall", "wall", "exit to meeting room", "exit to kitchen"));
            floorMap.add(new Room ("Bathroom", "It feels like you just stepped onto a sailing ship. The floors are lined with seashells and algae and the walls are decorated with rope-framed paintings.", "exit to ball pit", "wall", "wall", "exit to entryway"));
            floorMap.add(new Room ("Bunk room", "Huge sleepover vibes in here. Filled with bunk beds and plushies and fluffy pillows.", "exit to hall of mirrors", "exit to ball pit", "exit to entryway", "wall"));
            floorMap.add(new Room ("Hall of mirrors", "A disorienting freaky room of mirrors. You're met with your reflection everywhere you look.", "exit to kitchen", "exit to meeting room", "exit to bunk room", "wall"));
            floorMap.add(new Room ("Ball pit", "The floor is balls. Everything is balls. Bright, multicolored balls.", "exit to meeting room", "wall", "exit to bathroom", "exit to bunk room"));
            floorMap.add(new Room ("Entry way", "It's an entryway. Welcome. Or goodbye but probably not goodbye. You're probably stuck here.", "exit to bunk room", "exit to bathroom", "escape", "wall"));
        }
    }

    

}