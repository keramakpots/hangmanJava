package db;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;

public class MyFileWriter {

    public static void writeToFile(String name, Long score) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("../resources/scores.txt"), true))) {
            writer.append(name + "," + score + ".s\n");
            writer.close();
        } catch (FileNotFoundException e) {
           System.out.println(e);
       }
    }
}
