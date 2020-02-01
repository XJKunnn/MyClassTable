import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Init {
    private static JPanel course_panel;
    public static int targetWeek;

    public Init(JPanel course_panel){
        this.course_panel = course_panel;
    }

    public static void createAndShowGUI(){                          //初始化课程表页面
        JFrame frame = new JFrame("myClassTabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        coursePanel coursePanel = new coursePanel();
        course_panel = coursePanel.getCourse_panel();
        frame.add(coursePanel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void firstSHowCourse(){                           //设置周数和开始时间后课程表的初始页面
        Conn con = new Conn();
        List<Course> getCourse = con.getCourse();
        for(int n = 0; n < getCourse.size(); n++){
            new AddCourse(course_panel, getCourse.get(n));
        }
    }

    public void calStartWeek(Date startDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int startWeek = calendar.get(calendar.WEEK_OF_YEAR);
        Timer timer = new Timer();
        int currentWeek = timer.getCurrentWeek();
        targetWeek = currentWeek - startWeek + 1;
    }
}
