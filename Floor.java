import java.util.ArrayList;


public class Floor{

    protected ArrayList <Room>floorMap;
    protected Room activeRoom;

    // constructor
    public Floor(){
        this.floorMap = new ArrayList <Room>();
        floorMap.add(new Room ("Main Basement Room", "Large mostly empty room. Smells a little odd.", null, null, null, null));
        floorMap.add(new Room ("Basement Cupboard", "Just a set of shelves behind a door, really.", null, null, null, null));
        floorMap.add(new Room ("Meeting Room", "Sterile white walls surround a u-shaped concrete table.", null, null, null, null));
        floorMap.add(new Room ("Kitchen", "A homey vibe in here. The moss green cupbords are lit by the soft sunlight streaming throught the curtains.", null, null, null, null));
        floorMap.add(new Room ("Dining Room", "Grand room with a large oak table in the center", null, null, null, null));
        floorMap.add(new Room ("Bathroom", "It feels like you just stepped onto a sailing ship. The floors are lined with seashells and algae and the walls are decorated with rope-framed paintings.", null, null, null, null));
        floorMap.add(new Room ("Bunk room", "Huge sleepover vibes in here. Filled with bunk beds and plushies and fluffy pillows.", null, null, null, null));
        floorMap.add(new Room ("Hall of mirrors", "A disorienting freaky room of mirrors. You're met with your reflection everywhere you look.", null, null, null, null));
        floorMap.add(new Room ("Ball pit", "The floor is balls. Everything is balls. Bright, multicolored balls.", null, null, null, null));
        floorMap.add(new Room ("Entry way", "It's an entryway. Welcome. Or goodbye but probably not goodbye. You're probably stuck here.", null, null, null, null));
        floorMap.add(new Room ("Outside", "You're free!", null, null, null, null));

        floorMap.set(0, new Room("Main Basement Room", "Large mostly empty room. Smells a little odd. To the north, stairs lead up out of the basement. The walls to the East and South are empty and solid looking. There is a doorway on the West wall.", floorMap.get(3), null, null, floorMap.get(1)));
        floorMap.set(1, new Room ("Basement Cupboard", "Just a set of shelves behind a door, really. The doorway to the Main Basement Room is to the East", null, floorMap.get(0), null, null));
        floorMap.set(2, new Room ("Meeting Room", "Sterile white walls surround a u-shaped concrete table. There are doorways on each wall except for the East wall.", floorMap.get(4), null, floorMap.get(8), floorMap.get(7)));
        floorMap.set(3, new Room ("Kitchen", "A homey vibe in here. The moss green cupbords are lit by the soft sunlight streaming throught the curtains. Doorways lead out to East and South. There are stairs leading down to the North.", floorMap.get(0), floorMap.get(4), floorMap.get(7), null));
        floorMap.set(4, new Room ("Dining Room", "Grand room with a large oak table in the center. Doorways lead out on the South and West walls.", null, null, floorMap.get(2), floorMap.get(3)));
        floorMap.set(5, new Room ("Bathroom", "It feels like you just stepped onto a sailing ship. The floors are lined with seashells and algae and the walls are decorated with rope-framed paintings. There is a door on the North wall, and a door on the West wall.", floorMap.get(8), null, null, floorMap.get(9)));
        floorMap.set(6, new Room ("Bunk room", "Huge sleepover vibes in here. Filled with bunk beds and plushies and fluffy pillows. There are doorways on the North wall, East wall, and South wall.", floorMap.get(7), floorMap.get(8), floorMap.get(9), null));
        floorMap.set(7, new Room ("Hall of mirrors", "A disorienting freaky room of mirrors. You're met with your reflection everywhere you look. You can't tell which ways the doors are. EEK!", floorMap.get(3), floorMap.get(2), floorMap.get(6), null));
        floorMap.set(8, new Room ("Ball pit", "The floor is balls. Everything is balls. Bright, multicolored balls. There are doors to the North, South, and West", floorMap.get(2), null, floorMap.get(5), floorMap.get(6)));
        floorMap.set(9, new Room ("Entry way", "It's an entryway. Welcome. Or goodbye but probably not goodbye. You're probably stuck here. There are doorways to the North and East. There is a bigger awesomer grander doorway to the South. It has 3 keyholes.", floorMap.get(6), floorMap.get(5), floorMap.get(10), null));
        floorMap.set(10, new Room ("Outside", "You're free!", floorMap.get(9), null, null, null));


    }


    public Room getActiveRoom(){
        return activeRoom;
    }

   
    

}