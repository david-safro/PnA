import java.util.Scanner;

public class Adventure {
    private static final String[] LOCATIONS = {
            "Enchanted Forest: You stand at the entrance of a dense, mystical forest. The air is filled with a sweet fragrance, and the trees seem to whisper secrets. You notice two paths ahead.",
            "Abandoned Castle: You enter an eerie castle that seems to have been untouched for centuries. Dusty chandeliers hang from the ceiling, and cobwebs cover the furniture. You notice two different rooms to explore.",
            "Crystal Caves: You find yourself in a dazzling cave adorned with shimmering crystals of various colors. The air is cool and refreshing. Two paths lie ahead.",
            "Haunted Mansion: You enter a haunted mansion filled with an eerie atmosphere. The walls are adorned with portraits that seem to follow your every move. Two rooms are accessible.",
            "Forgotten Temple: You arrive at a forgotten temple, hidden deep within a remote mountain range. The structure is ancient and overgrown with vegetation. There are two areas to investigate."
    };

    private static final String[][] OPTIONS = {
            {"Follow a narrow path deeper into the forest", "Turn back and leave the forest"},
            {"Enter the grand hall and search for hidden treasures", "Investigate the mysterious underground dungeon"},
            {"Venture deeper into the cave to discover its secrets", "Return to the entrance of the cave"},
            {"Explore the dusty library for hidden knowledge", "Ascend the creaky staircase to the upper floor"},
            {"Enter the inner sanctum of the temple", "Explore the crumbling exterior of the temple"}
    };

    private static final int[][] RESULTS = {
            {1, -1},
            {2, 3},
            {4, 1},
            {4, 1},
            {200, 3}
    };

    public static void main(String[] args) {
        int location = 0;
        boolean playing = true;

        while (playing) {
            String format = "Do you want to \na) " + OPTIONS[location][0] + " or \nb) " + OPTIONS[location][1];
            String userInput = inquiry(LOCATIONS[location], format);
            location = compute(userInput, RESULTS[location][0], RESULTS[location][1]);

            if (location == -1) {
                System.out.println("You gave up");
                playing = false;
            } else if (location == 200) {
                System.out.println("You find a treasure chest full of gold! Congrats");
                playing = false;
            } else if (location == 404) {
                System.out.println("Incorrect input. Try again");
                location = 0;
            }
        }

        System.out.println("Game over!");
    }

    public static String inquiry(String text, String inquiry) {
        System.out.println(text + "\n \n" + inquiry);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int compute(String reply, int res1, int res2) {
        if (reply.equals("a")) {
            return res1;
        } else if (reply.equals("b")) {
            return res2;
        }
        return 404;
    }
}
