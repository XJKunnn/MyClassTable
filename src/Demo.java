import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Demo {
    static JPanel course_panel;
    static Date startDate = null, endDate = null;

    public static void main(String args[]) throws InterruptedException{
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DialogOfTime dialogOfTime = new DialogOfTime();
            }
        });
    }
}
