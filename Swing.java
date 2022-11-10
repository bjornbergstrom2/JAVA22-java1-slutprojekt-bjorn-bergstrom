import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

public class Swing {
    JPanel panel[] = new JPanel[7];
    JButton addBtn[] = new JButton[7];
    JButton removeBtn[] = new JButton[7];
    JLabel dateLbl[] = new JLabel[7];
    JTextArea dayEventField[] = new JTextArea[7];
    JTextField addTextField[] = new JTextField[7];
    JFrame frame;
    Date localDate;
    String dayString[] = new String[7];
    int layoutX = 0;

    /**
     Den här klassen skapar GUI med hjälp av Swing. Det finns fyra metoder,
     därav den första metoden innehåller allt som kommer att visas på fönstret.
     Andra och tredje metoderna lägger till actionlistner i "Add" & "Clear"
     knapparna. Fjärde metoden ändrar färg på dagens datum.

     */

    Swing(LocalDate today) {

        localDate = new Date(today);

    }

    // ===================================[METHOD]=======================================

    public void createGUI() {
        frame = new JFrame("Calendar");
        frame.setSize(1050,328);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        for (int i=0; i<addBtn.length;i++) {
            addBtn[i] = new JButton();
            addBtn[i].setText("ADD");
        }

        for (int i=0; i<removeBtn.length;i++) {
            removeBtn[i] = new JButton();
            removeBtn[i].setText("CLEAR");
        }

        for (int i=0; i<dayString.length;i++)
            dayString[i] = "";

        // Skapa lite aktiviteter i scheman
        dayString[0] = "Handla mat\nTvätt kl 19:00\n";
        dayString[1] = "Lämna in slutprojektet\n";
        dayString[2] = "Thaiboxning\n";
        dayString[4] = "Resa till Stockholm\n";

        for (int i=0; i<dateLbl.length;i++) {
            dateLbl[i] = new JLabel();
            dateLbl[i].setText(localDate.printDate(i));
            dateLbl[i].setFont(new Font("Times New Roman",Font.PLAIN,12));
            dateLbl[i].setForeground(Color.white);
        }

        for (int i=0; i<dayEventField.length;i++) {
            dayEventField[i] = new JTextArea(dayString[i], 12, 10);
            dayEventField[i].setLineWrap(true);
        }

        for (int i=0; i<addTextField.length;i++) {
            addTextField[i] = new JTextField(10);
        }

        // Metoden som tar text från textfält och adderar in i textrutan
        actionAdd();

        // Metoden som tömmer textrutan på all text
        actionRemove();

        // Metoden som ändrar dagens datum till lila
        setTodayDate();

        for (int i=0; i<panel.length;i++) {
            panel[i] = new JPanel();
            panel[i].add(dateLbl[i]);
            panel[i].add(dayEventField[i]);
            panel[i].add(addTextField[i]);
            panel[i].add(addBtn[i]);
            panel[i].add(removeBtn[i]);
            panel[i].setBackground(new Color(i*20,50,70));
            panel[i].setBounds(layoutX, 0, 150, 300);
            layoutX += 150;
        }

        for (int i=0; i<panel.length;i++)
            frame.add(panel[i]);
        frame.setVisible(true);

    }

    public void actionAdd() {
        for (int i=0; i<addBtn.length;i++) {

            int j = i;

            addBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dayString[j] += addTextField[j].getText() + "\n";
                    dayEventField[j].setText(dayString[j]);
                    addTextField[j].setText("");
                }
            });
        }
    }

    public void actionRemove() {
        for (int i=0; i<removeBtn.length;i++) {

            int j = i;

            removeBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dayString[j] = "";
                    dayEventField[j].setText(dayString[j]);
                }
            });
        }
    }

    public void setTodayDate() {

        for (int i=0; i<dateLbl.length; i++) {

            if (Objects.equals(localDate.checkDate(i), localDate.todayDate()))
                dateLbl[i].setForeground(Color.magenta);
        }
    }
}
