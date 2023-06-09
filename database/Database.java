import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Database {
    public static String file = "src/input.txt";
    public static void main(String[] args) {

        try {
            int lineCount = lines();
            String[][] matrix = new String[lineCount][2];
            write(matrix);
            cmdInput(matrix);
        } catch (IOException e) {
            System.out.println("Error. Invalid text file. (Should be input.txt).");
        }
    }

    public static int lines() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        }
    }

    public static void write(String[][] fileData) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split("\\s+");
                fileData[index][0] = splitLine[0];
                fileData[index][1] = splitLine[1];
                index++;
            }
        }
    }

    public static void displayMatrix(String[][] fileData) {
        for (String[] data : fileData) {
            System.out.println(data[0] + " " + data[1]);
        }
    }

    public static boolean insertion(String[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            String[] keyArray = matrix[i];
            int key = Character.getNumericValue(keyArray[0].charAt(0));
            int j = i - 1;
            while (j >= 0 && Character.getNumericValue(matrix[j][0].charAt(0)) > key) {
                matrix[j + 1] = matrix[j];
                j = j - 1;
            }
            matrix[j + 1] = keyArray;
        }
        return true;
    }

    public static boolean selection(String[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < matrix.length; j++) {
                int current = Integer.parseInt(matrix[j][1]);
                int min = Integer.parseInt(matrix[index][1]);
                if (current < min) {
                    index = j;
                }
            }
            String[] temp = matrix[index];
            matrix[index] = matrix[i];
            matrix[i] = temp;
        }
        return true;
    }

    public static void cmdInput(String[][] data){
        displayMatrix(data);
        boolean run = false;
        System.out.println("Do you want to display the information in word order (1), number order (2), or exit (3)");
        Scanner scanner = new Scanner(System.in);
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 1 && number <= 3) {
                run = (number == 1 ? insertion(data) : (number == 2 ? selection(data) : false));
            } else {
                System.out.println("Input not between 1 and 3. Try again.");
                cmdInput(data);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");
            cmdInput(data);
        }
        if(run){
            cmdInput(data);
        }
    }
}
