import java.util.Scanner;

public class GameLoop {

    public static void main(String[] args) {

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner scanner = new Scanner(System.in);

        // Storage for user's responses
        String command = "";

        // This could be replaced with a more interesting opening
        System.out.println("****************************************************************");
        System.out.println("ESCAPING THE CLOWN HOUSE CHALLENGE!! NOT CLICKBAIT!! *emotional*");
        System.out.println("****************************************************************");

        // Instructions are sometimes helpful
        System.out.println("You wake up.");
        System.out.println("You’re in a dark basement and you are chained to the radiator! It seems to be humming a tune…");
        System.out.println("The last thing you remember is your higher up in the MLM, holding a big rubber mallet telling you that you didn’t sell enough leggings this month.");
        System.out.println("Next thing you know you were hearing the squeak of the mallet as it hit your head.");
        System.out.println("You went down whack-a-mole style.");

        System.out.println("You know you have to escape this crazy clown house which serves as the headquarters for this MLM you joined that one god-forsaken night after you decided software engineering wasn't your passion anymore. But how?");
        System.out.println("Here are the commands you can use as you try to escape:");
        System.out.println("Look around");
        System.out.println("Go north");
        System.out.println("Go east");
        System.out.println("Go south");
        System.out.println("Go west");
        System.out.println("Pick up {object}");
        System.out.println("Put down {object}");
        System.out.println("Harmonize");
        System.out.println("Use {object}");
        System.out.println("Backflip");

        System.out.println("You can use any of these commands to navigate through the house as you attempt to escape! But first you'll have to unchain yourself from this musical radiator...");

        Floor f = new Floor();
        f.activeRoom = f.floorMap.get(0);

        Player p = new Player();
        Boolean moveability = false;
        Boolean foundKeyOne = false;
        Boolean foundKeyTwo = false;
        Boolean foundKeyThree = false;
        Boolean bigDoorOpen = false;

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {

            command = scanner.nextLine().toUpperCase();

            if (command.equals("GO NORTH")) {
                if (moveability==true){
                    p.goNorth(f.activeRoom);
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            }

            if (command.equals("GO EAST")) {
                if (moveability==true){
                    p.goEast(f.activeRoom);
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            }

            if (command.equals("GO SOUTH")) {
                if (moveability==true){
                    if (f.activeRoom==f.floorMap.get(9)){
                        if (bigDoorOpen){
                            p.goSouth(f.activeRoom);
                            System.out.println("You made it! You're free! Goodbye crazy MLM clown house... for now...");
                            stillPlaying = false;
                        } else{
                            System.out.println("LOUD INCORRECT BUZZER NOISE. Seems like you need some keys to get through here.");
                        }
                    } else{
                        p.goSouth(f.activeRoom);
                    }
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            }

            if (command.equals("GO WEST")) {
                if (moveability==true){
                    p.goWest(f.activeRoom);
                    if (f.activeRoom == f.floorMap.get(1)){
                        foundKeyOne = true;
                    }
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            }

            if (command.equals("HARMONIZE")){
                if (moveability==false){
                    if (p.harmonize()){
                        moveability = true;
                    }
                } else{
                    System.out.println("That's a nice tune. If only music could really solve every problem. It's not solving this one.");
                }
            }

            if (command.equals("BACKFLIP")){
                if (moveability==true){
                    if (f.activeRoom!=f.floorMap.get(7)){
                        if (p.backflip()){
                            foundKeyTwo = true;
                        }
                    } else{
                        System.out.println("YIKES! That backflip was a little wonky, and you shatterred the mirrors around you. The glass came spilling down and cut you all up and now you're bleeding out. And now you're dead.");
                        stillPlaying = false;
                    }
                } else {
                    System.out.println("Woah there buster, maybe try freeing yourself from those chains before you start doing flips.");
                }
            }

            if (command.equals("LOOK AROUND")){
                System.out.println(p.lookAround(f.activeRoom));
            }


        } while (stillPlaying);

        // Tidy up
        scanner.close();

        System.out.println("GAME OVER");

    }

}