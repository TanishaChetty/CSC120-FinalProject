public class Room{
    
    //Attributes
    protected String name;
    protected String description;
    protected Room northWall;
    protected Room eastWall;
    protected Room southWall;
    protected Room westWall;

    /** 
     * Constructor for Room
     * @param name the name of the Room
     * @param description the description of the Room including where the doorways are
     * @param northWall the room to the north
     * @param eastWall the room to the east
     * @param southWall the room to the south
     * @param westWall the room to the west
    */
    public Room(String name, String description, Room northWall, Room eastWall,  Room southWall, Room westWall){
        this.name = name;
        this.description = description;
        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
    }


    /**
     * Accessor for Room name
     * @return  the name of the room
    */
    public String getName(){
        return name;
    }

    /**
     * Identifies neighboring rooms
     * @param dir the direction of the neighboring room to be identified
     * @return  the Room to the given direction
    */
    public Room getNeighbor(String dir){
        switch(dir){
            case "NORTH": 
                return northWall;
            case "EAST": 
                return eastWall;
            case "SOUTH": 
                return southWall;
            case "WEST": 
                return westWall;
            default:
                return null;
        }
    }

    /**
     * Accessor for Room description
     * @return  the description of the room
    */
    public String getDescription(){
        return description;
    }

    /**
     * Connects rooms with their neighboring rooms. Used after all rooms had been initially constructed.
     * @param northWall the room to the north
     * @param eastWall the room to the east
     * @param southWall the room to the south
     * @param westwall the room to the west
    */
    public void resetsWalls(Room northWall, Room eastWall, Room southWall, Room westWall){
        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
    }
}
