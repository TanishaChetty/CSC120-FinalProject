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
        System.out.println("Pick up key");
        System.out.println("Put down key");
        System.out.println("Harmonize");
        System.out.println("Use keys");
        System.out.println("Backflip");
        System.out.println("Go pee");
        System.out.println("Flush");
        System.out.println("Wash hands");


        System.out.println("You can use any of these commands to navigate through the house as you attempt to escape! But first you'll have to unchain yourself from this musical radiator...");

        Floor f = new Floor();
        f.activeRoom = f.floorMap.get(0);

        Player p = new Player();
        Boolean moveability = false;
        Boolean foundKeyOne = false;
        Boolean foundKeyTwo = false;
        Boolean foundKeyThree = false;
        Boolean bigDoorOpen = false;
        Boolean wentPee = false;
        Boolean flushed = false;

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {

            command = scanner.nextLine().toUpperCase();

            if (command.equals("GO NORTH")) {
                if (moveability==true){
                    f.activeRoom = p.goNorth(f.activeRoom);
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            } else if (command.equals("GO EAST")) {
                if (moveability==true){
                    f.activeRoom = p.goEast(f.activeRoom);
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            } else if (command.equals("GO SOUTH")) {
                if (moveability==true){
                    if (f.activeRoom==f.floorMap.get(9)){
                        if (bigDoorOpen){
                            p.goSouth(f.activeRoom);
                            System.out.println("You made it! You're free! A tear of happiness rolls down your face and you're overcome with a newfound sense of gratitude for the world. You finally have a chance to reconcile with Barbara and maybe build that beautiful life together that you've always dreamed of. Goodbye crazy MLM clown house... for now...");
                            stillPlaying = false;
                        } else{
                            System.out.println("LOUD INCORRECT BUZZER NOISE. Seems like you need some keys to get through here.");
                        }
                    } else{
                        f.activeRoom = p.goSouth(f.activeRoom);
                    }
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            } else if (command.equals("GO WEST")) {
                if (moveability==true){
                    if (f.activeRoom == f.floorMap.get(1)){
                        if (foundKeyOne == false){
                            System.out.println("Ooh a key! In the cupboard!");
                            foundKeyOne = true;
                        }
                    } else{
                        f.activeRoom = p.goWest(f.activeRoom);
                    }
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            } else if (command.equals("HARMONIZE")){
                if (moveability==false){
                    if (p.harmonize()){
                        moveability = true;
                    }
                } else{
                    System.out.println("That's a nice tune. If only music could really solve every problem. It's not solving this one.");
                }
            } else if (command.equals("BACKFLIP")){
                if (moveability==true){
                    if (f.activeRoom!=f.floorMap.get(7)){
                        if (p.backflip(f.activeRoom)){
                            if (foundKeyTwo == false){
                                System.out.println("That was an awesome backflip! You land in the balls and feel a cold piece of metal poking into your behind. How embarassing! Hopefully nobody saw. You look under you to investigate and find that you backflipped onto a key!");
                                foundKeyTwo = true;
                            } else{
                                System.out.println("That was an awesome backflip!");
                            }
                        }
                    } else{
                        System.out.println("YIKES! That backflip was a little wonky, and you shatterred the mirrors around you. The glass came spilling down and cut you all up and now you're bleeding out. Your life flashes before your eyes. You see the face of Barbara, your first love from the tenth grade. You think of the naive but deep and true love you shared and you think of how carelessly you broke her heart when you both left for college because you didn't want to do long distance. You think of the beautiful life you two could have shared together. You think of how you'll never get the chance to reconcile with her ever again. Life around you fades and you see a bright light. You move towards it. And now you're dead.");
                        stillPlaying = false;
                    }
                } else {
                    System.out.println("Woah there buster, maybe try freeing yourself from those chains before you start doing flips.");
                }
            } else if (command.equals("LOOK AROUND")){
                System.out.println(p.lookAround(f.activeRoom));
            } else if (command.equals("GO PEE")){
                if (p.goPee(f.activeRoom)){
                    System.out.println("Epic! You just peed in the toilet. Your bladder feels so relieved.");
                    wentPee = true;
                }
            } else if (command.equals("FLUSH")){
                if (wentPee == true){
                    if (p.flush(f.activeRoom)){
                        System.out.println("Awesome! Gold star.");
                        flushed = true;
                    }
                } else if (f.activeRoom!=f.floorMap.get(5)){
                    System.out.println("Flush what? Don't answer that...");
                } else {
                    System.out.println("Ok sure.");
                }
            } else if (command.equals("WASH HANDS")){
                if (flushed == true){
                    if (p.washHands(f.activeRoom)){
                        if (foundKeyThree == false){
                            System.out.println("Nice. Your hands are all clean. Woah! A key just appeared in the sink!");
                            foundKeyThree = true;
                        } else{
                            System.out.println("Nice. Your hands are all clean.");
                        }
                    }
                } else if (f.activeRoom!=f.floorMap.get(5)){
                    System.out.println("Not sure what you're trying to wash your hands with but it doesn't seem to be working.");
                } else{
                    System.out.println("Your hands are nice and clean. But something's missing. Maybe you missed some steps?");
                }
            } else if (command.equals ("PICK UP KEY")){
                p.pickUp(f.activeRoom,foundKeyOne,foundKeyTwo,foundKeyThree);
            } else if (command.equals ("PUT DOWN KEY")){
                if (p.putDown()){
                    foundKeyOne = false;
                    foundKeyTwo = false;
                    foundKeyThree = false;
                }
            } else if (command.equals ("USE KEYS")){
                if (f.activeRoom == f.floorMap.get(9)){
                    if(p.useKeys()){
                        bigDoorOpen = true;
                        System.out.println("Wow you got the door open! One more step and you're free!");
                    }
                } else {
                    System.out.println("Use keys where? Up your butt??");
                }
            } else {
                System.out.println("Command not recognized. Try again.");
            }



        } while (stillPlaying);

        // Tidy up
        scanner.close();

        System.out.println("*********");
        System.out.println("GAME OVER");
        System.out.println("*********");

    }

}