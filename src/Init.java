import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Init {

    public Init(){

    }

    public void setTimer(){
        Timer timer = new Timer();
        timer.setTargetWeek();
    }

    public static void createAndShowGUI(){                          //初始化课程表页面
        JFrame frame = new JFrame("myClassTabel");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        coursePanel coursePanel = new coursePanel();
        //course_panel = coursePanel.getCourse_panel();

        WeekChanger weekChanger = new WeekChanger();

        frame.add(coursePanel);
        frame.add(weekChanger);

        frame.pack();
        frame.setVisible(true);
    }

    public static void firstSHowCourse(){                           //设置周数和开始时间后课程表的初始页面
        Conn con = new Conn();
        Demo.currentList = con.getCourse();
        for(int n = 0; n < Demo.currentList.size(); n++){
            new AddCourse(Demo.course_panel, Demo.currentList.get(n));
        }
    }

    public static void updateCoursePanel(){
        Demo.course_panel.removeAll();
        Demo.currentList = new Conn().getCourse();
        if(Demo.currentList.size() == 0){
            Demo.course_panel.removeAll();
        } else {
            for(int n = 0; n < Demo.currentList.size(); n++){
                new AddCourse(Demo.course_panel, Demo.currentList.get(n));
            }
        }
        Demo.course_panel.repaint();
    }

}
