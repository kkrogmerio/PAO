import java.text.ParseException;
import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Date  {
    int an,luna,zi;
    LocalDateTime myObj = LocalDateTime.now();
    String lvl;
    int exp;
    public Date(int an, int luna, int zi) {
        this.an = an;
        this.luna = luna;
        this.zi = zi;
    }


    void experience() {
        try {
            System.out.println(myObj);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
            String inputString1 = zi+" "+luna+" "+an;

            System.out.println(inputString1);
            LocalDateTime date1 = LocalDate.parse(inputString1, dtf).atStartOfDay();
           // LocalDateTime date2 = LocalDateTime.parse(myObj, dtf);
            int daysBetween = (int) Duration.between(date1, myObj).toDays();
            System.out.println(daysBetween);
            if((0 < daysBetween) && daysBetween< 365)
                lvl="Junior";
            else if ((365<daysBetween)&& daysBetween<3*365)
                lvl="Middle";
            else if (daysBetween>3*365)
                lvl="Senior";
            exp=(int)(daysBetween/365);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void specific(){
        if((20<=myObj.getYear()-an)&&myObj.getYear()-an<30)
            System.out.println("Young employee");
        if((30<=myObj.getYear()-an)&&myObj.getYear()-an<44)
            System.out.println("Millenial employee");
        if((44<=myObj.getYear()-an)&&myObj.getYear()-an<65)
            System.out.println("Experienced employee");
    }

}
