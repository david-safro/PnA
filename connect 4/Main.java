import java.util.Scanner;
public class Main {
    public static String input;

    private static int move;
    public static void main(String[] args) {
        int[] pos;
        Connect4Board board = new Connect4Board();
        boolean run = true;
        boolean win = false;
        board.displayBoard();
        while(run){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            pos = board.updateBoard(checker(), move % 2 == 0 ? 'x' : move % 2 == 1 ? 'o' : '?');
            board.displayBoard();
            win = board.checkWin(pos[0],pos[1]);
            if(win){
                run = false;
            }
            move++;
        }
    }
    public static int checker() {
        input = cmdInput();
        try {
            int number = Integer.parseInt(input);
            if(number >= 1 && number <= 7) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Input is not between 1 and 7. Try again.");
                checker();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input is not an integer. Try again.");
            checker();
        }
        return Integer.parseInt(input);
    }
    public static String cmdInput(){
        System.out.print("Where do you want to move next: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
