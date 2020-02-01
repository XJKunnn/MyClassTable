import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String args[]){
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse("2020-09-01");
            System.out.println(date);
        } catch (ParseException pe){
            pe.printStackTrace();
        }

    }
}
