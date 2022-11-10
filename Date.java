import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Date {
    private String weekday[] = new String[7];
    private LocalDate date;

    /**
     Den här klassen innehåller tre metoder som har datum med att göra.
     Första metoden skriver ut veckans datum + veckodag beroende på index som input.
     Andra metoden skriver ut  veckans datum beroende på index som input.
     Tredje metoden skriver ut dagens datum.
     */
    Date(LocalDate date) {
        this.date = date;
        weekday[0] = "Monday";
        weekday[1] = "Tuesday";
        weekday[2] = "Wednesday";
        weekday[3] = "Thursday";
        weekday[4] = "Friday";
        weekday[5] = "Saturday";
        weekday[6] = "Sunday";
    }
    public String printDate (int day) {

        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate dayOfWeek = this.date.with(fieldISO,day+1);
        String output = dayOfWeek.toString() + " " + weekday[day] ;

        return output;
    }

    public String checkDate(int day) {
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate weekday = this.date.with(fieldISO,day+1);
        String output = weekday.toString();

        return output;
    }

    public String todayDate() {
        String output = date.toString();
        return output;
    }
}