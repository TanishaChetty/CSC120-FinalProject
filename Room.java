public class Room{
    
    protected String name;
    protected String description;
    protected String northWall;
    protected String eastWall;
    protected String southWall;
    protected String westWall;

    public Room(String name, String description, String northWall, String eastWall,  String southWall, String westWall){
        this.name = name;
        this.description = description;
        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
    }
}
