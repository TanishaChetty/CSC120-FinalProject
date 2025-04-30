public class Room{
    
    protected String name;
    protected String description;
    protected Room northWall;
    protected Room eastWall;
    protected Room southWall;
    protected Room westWall;

    public Room(String name, String description, Room northWall, Room eastWall,  Room southWall, Room westWall){
        this.name = name;
        this.description = description;
        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
    }


    public String getName(){
        return name;
    }

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

    public String getDescription(){
        return description;
    }

    public void resetsWalls(Room northWall, Room eastWall, Room southWall, Room westWall){
        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
    }
}
