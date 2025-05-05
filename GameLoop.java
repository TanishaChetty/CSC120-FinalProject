import java.util.Scanner;

public class GameLoop {

    public static void main(String[] args) {

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner scanner = new Scanner(System.in);

        // Storage for user's responses
        String command = "";

        // Game opening
        System.out.println("****************************************************************");
        System.out.println("ESCAPING THE CLOWN HOUSE CHALLENGE!! NOT CLICKBAIT!! *emotional*");
        System.out.println("****************************************************************");

        // Setting the scene
        System.out.println("You wake up.");
        System.out.println("You’re in a dark basement and you are chained to the radiator! It seems to be HUMMING a TUNE");
        System.out.println("The last thing you remember is your higher up in the MLM, holding a big rubber mallet telling you that you didn’t sell enough leggings this month.");
        System.out.println("Next thing you know you were hearing the squeak of the mallet as it hit your head.");
        System.out.println("You went down whack-a-mole style.");

        // Giving instructions
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


        System.out.println("You can use any of these commands to navigate through the house as you attempt to escape! But first you'll have to unchain yourself from this MUSICAL radiator...");

        //Calling constructors to start the game, and initializing some variables
        Floor f = new Floor();
        f.activeRoom = f.floorMap.get(0);

        Player p = new Player();
        Boolean moveability = false; //indicates if you are stuck to the radiator
        Boolean foundKeyOne = false; //indicates if you've located the basement cupboard key
        Boolean foundKeyTwo = false; //indicates if you've located the ball pit key
        Boolean foundKeyThree = false; //indicates if you've located the bathroom key
        Boolean bigDoorOpen = false; //indicates if you've unlocked the big door to escape the clownhouse
        Boolean wentPee = false; //indicates if you've gone pee in the bathroom
        Boolean flushed = false; //indicates if you've flushed the toilet
        int backflipCounter = 0; //counts how many backflips you've done

        // do...while structure creates game loop. Goes through do first before checking stopping condition and stops if you've died or escaped.
        do {
            //standardize case to upper
            command = scanner.nextLine().toUpperCase();

            //go north: check if you can move, call goNorth from player class
            if (command.equals("GO NORTH")) {
                if (moveability==true){
                    f.activeRoom = p.goNorth(f.activeRoom);
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            //go east: check if you can move, call goEast from player class
            } else if (command.equals("GO EAST")) {
                if (moveability==true){
                    f.activeRoom = p.goEast(f.activeRoom);
                } else {
                    System.out.println("Hmmmm... you seem to be a bit stuck. Can't move... yet...");
                }
            //go south: check if you can move, check if you're trying to leave the entire house, call goSouth from player class
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
            //go west: check if you can move, check if you're going west in the cupboard (in which case you're finding a key), call goWest from player class
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
            //harmonize: unchain you from radiator if you are stuck.
            } else if (command.equals("HARMONIZE")){
                if (moveability==false){
                    if (p.harmonize()){
                        moveability = true;
                    }
                } else{
                    System.out.println("That's a nice tune. If only music could really solve every problem. It's not solving this one.");
                }
            //backflip: check if you are able to move first. Then check if you are in the mirror room, in which case you die. Then check if you've backfliped 20 times already, in which case you die. Then call backflip, and if you're in the ball pit, you find a key (if you haven't found that key yet).
            } else if (command.equals("BACKFLIP")){
                if (moveability==true){
                    if (f.activeRoom!=f.floorMap.get(7)){
                        if (backflipCounter<20){
                            if (p.backflip(f.activeRoom)){
                                if (foundKeyTwo == false){
                                    System.out.println("That was an awesome backflip! You land in the balls and feel a cold piece of metal poking into your behind. How embarassing! Hopefully nobody saw. You look under you to investigate and find that you backflipped onto a key!");
                                    foundKeyTwo = true;
                                    backflipCounter+=1;
                                } else{
                                    System.out.println("That was an awesome backflip!");
                                    backflipCounter+=1;
                                }
                            } else{
                                backflipCounter+=1;
                            }
                        } else{
                            System.out.println("You have done so many backflips that this time you're not able to muster up enough energy to complete a full rotation. You land  right on your head and your neck snaps. You've flipped your last flip. Barbara always said you got too cocky when you backflipped. Oh Barbara...");
                        }
                    } else{
                        System.out.println("YIKES! That backflip was a little wonky, and you shatterred the mirrors around you. The glass came spilling down and cut you all up and now you're bleeding out. Your life flashes before your eyes. You see the face of Barbara, your first love from the tenth grade. You think of the naive but deep and true love you shared and you think of how carelessly you broke her heart when you both left for college because you didn't want to do long distance. You think of the beautiful life you two could have shared together. You think of how you'll never get the chance to reconcile with her ever again. Life around you fades and you see a bright light. You move towards it. And now you're dead.");
                        stillPlaying = false;
                    }
                } else {
                    System.out.println("Woah there buster, maybe try freeing yourself from those chains before you start doing flips.");
                }
            //look around: print return from lookAround from player class
            } else if (command.equals("LOOK AROUND")){
                System.out.println(p.lookAround(f.activeRoom));
            //go pee: call goPee from player class, if in bathroom updates "wentPee"
            } else if (command.equals("GO PEE")){
                if (p.goPee(f.activeRoom)){
                    System.out.println("Epic! You just peed in the toilet. Your bladder feels so relieved.");
                    wentPee = true;
                }
            //flush: if you've gone pee already call flush from player class and updates "flushed". 
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
            //wash hands: if you've gone pee and flushed call washHands from the player class and you find a key.
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
            //pick up key: call pickUp from player class.
            } else if (command.equals ("PICK UP KEY")){
                p.pickUp(f.activeRoom,foundKeyOne,foundKeyTwo,foundKeyThree);
            //put down key: call putDown from player class and reset foundKey variables.
            } else if (command.equals ("PUT DOWN KEY")){
                if (p.putDown()){
                    foundKeyOne = false;
                    foundKeyTwo = false;
                    foundKeyThree = false;
                }
            //use keys: check if you are in entry way, if so call useKeys from player class and update bigDoorOpen.
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

        // Let 'em know it's over
        System.out.println("*********");
        System.out.println("GAME OVER");
        System.out.println("*********");

    }

}