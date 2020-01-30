import javax.swing.*;
import java.awt.*;

public class Control{
    public Control(){

    }

    public static void addCourse(JPanel course_panel){
        JPanel addCourse = new JPanel();
        addCourse.setBounds(115*2, 30*2, 100, 30*3);
        addCourse.setBackground(Color.YELLOW);
        addCourse.setVisible(true);
        addCourse.addMouseListener(new Mouse());
        course_panel.add(addCourse);
        course_panel.updateUI();
    }

    public void deleteCourse(){

    }

}
