import java.io.*;
import java.io.File;

public class CreateFile {
    File file;
    FileWriter fileWriter;

    /**
    Den här klassen skapar en textfil med metod som tar emot string
    och sedan matar in och skapar en fil som heter Calendar.txt

     (Nu kommer filen skapas i samma mapp som det här programmet)
     */

    CreateFile() {}
    public void fileCreater(String input) {
        try {
            file = new File("Calendar.txt");
            fileWriter = new FileWriter(file);
            fileWriter.write(input);
            fileWriter.flush();
            fileWriter.close();

            System.out.println("Successfully wrote to the file.");
        }

        catch(Exception error) {
            System.out.println(error);
        }
    }
}
