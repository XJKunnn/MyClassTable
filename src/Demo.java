import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    static JPanel course_panel;
    static Timer timer;
    static List<Course> currentList = new ArrayList<>();

    public static void main(String args[]) throws InterruptedException{
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(new Conn().findDate()){
                    Init init = new Init();
                    init.setTimer();
                    init.createAndShowGUI();
                    init.firstSHowCourse();
                } else {
                    DialogOfTime dialogOfTime = new DialogOfTime();
                }
            }
        });
    }
}
