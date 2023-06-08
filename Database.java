import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {
    public static void main(String[] args) {
        String fileName = "src//input.txt";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
