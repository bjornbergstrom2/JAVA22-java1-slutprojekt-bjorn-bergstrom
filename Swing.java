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
    JLabel label[] = new JLabel[7];
    JTextArea textArea[] = new JTextArea[7];
    JTextField textField[] = new JTextField[7];
    JFrame frame;
    Date date;
    String text[] = new String[7];
    int xBound = 0;

    /**
     Den här klassen skapar GUI med hjälp av Swing. Det finns fyra metoder,
     därav den första metoden innehåller allt som kommer att visas på fönstret.
     Andra och tredje metoderna lägger till actionlistner i "Add" & "Clear"
     knapparna. Fjärde metoden ändrar färg på dagens datum.

     */

    Swing(LocalDate today) {

        date = new Date(today);

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

        for (int i=0; i<text.length;i++)
            text[i] = "";

        // Skapa lite aktiviteter i scheman
        text[0] = "Handla mat\nTvätt kl 19:00\n";
        text[1] = "Lämna in slutprojektet\n";
        text[2] = "Thaiboxning\n";
        text[4] = "Resa till Stockholm\n";

        for (int i=0; i<label.length;i++) {
            label[i] = new JLabel();
            label[i].setText(date.printDate(i));
            label[i].setFont(new Font("Times New Roman",Font.PLAIN,12));
            label[i].setForeground(Color.white);
        }

        for (int i=0; i<textArea.length;i++) {
            textArea[i] = new JTextArea(text[i], 12, 10);
            textArea[i].setLineWrap(true);
        }

        for (int i=0; i<textField.length;i++) {
            textField[i] = new JTextField(10);
        }

        // Metoden som tar text från textfält och adderar in i textrutan
        actionAdd();

        // Metoden som tömmer textrutan på all text
        actionRemove();

        // Metoden som ändrar dagens datum till lila
        setTodayDate();

        for (int i=0; i<panel.length;i++) {
            panel[i] = new JPanel();
            panel[i].add(label[i]);
            panel[i].add(textArea[i]);
            panel[i].add(textField[i]);
            panel[i].add(addBtn[i]);
            panel[i].add(removeBtn[i]);
            panel[i].setBackground(new Color(i*20,50,70));
            panel[i].setBounds(xBound, 0, 150, 300);
            xBound += 150;
        }

        for (int i=0; i<panel.length;i++)
            frame.add(panel[i]);
        frame.setVisible(true);

    }

    public void actionAdd() {
        for (int i=0; i<addBtn.length;i++) {

            int finalI = i;

            addBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text[finalI] += textField[finalI].getText() + "\n";
                    textArea[finalI].setText(text[finalI]);
                    textField[finalI].setText("");
                }
            });
        }
    }

    public void actionRemove() {
        for (int i=0; i<removeBtn.length;i++) {

            int finalI = i;

            removeBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text[finalI] = "";
                    textArea[finalI].setText(text[finalI]);
                }
            });
        }
    }

    public void setTodayDate() {

        for (int i=0; i<label.length; i++) {

            if (Objects.equals(date.checkDate(i), date.todayDate()))
                label[i].setForeground(Color.magenta);
        }
    }
}
