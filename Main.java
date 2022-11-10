import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        Swing swing = new Swing(today);
        Date date = new Date(today);
        CreateFile createFile = new CreateFile();
        Scanner sc = new Scanner(System.in);
        String file = "";

        swing.createGUI();

        System.out.println("\nPress ENTER to create a txt file.");
        sc.nextLine();

        // Sparar alla datum & strängar i [file] från kalendern
        for (int i=0;i<swing.dateLbl.length;i++)
            file += date.printDate(i) + "\n" + swing.dayString[i] + "\n\n";

        createFile.fileCreater(file);

    }
}