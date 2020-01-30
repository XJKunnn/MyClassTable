import javax.swing.*;
import java.awt.*;

public class AddCourse extends JPanel {
    Course course;
    JPanel panel;
    JPanel course_panel;
    int START_TIME, END_TIME, COURSE_DAY, START_WEEK, END_WEEK;

    public AddCourse(JPanel course_panel, Course course){
        super();
        this.course_panel = course_panel;
        this.course = course;
        START_TIME = course.getStart_time();
        END_TIME = course.getEnd_time();
        COURSE_DAY = course.getCourse_day();

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(115 * (COURSE_DAY - 1), 30 * (START_TIME - 1),
                100, 30 * (END_TIME - START_TIME + 1));
        panel.setBackground(Color.YELLOW);
        panel.setVisible(true);
        panel.addMouseListener(new Mouse());

        JLabel name = new JLabel(course.getName());
        name.setBounds(20, 30 * (END_TIME - START_TIME + 1) / 2 - 30, 60, 20);
        JLabel location = new JLabel(course.getLocation());
        location.setBounds(20, 30 * (END_TIME - START_TIME + 1) / 2 , 60, 20);

        panel.add(name);
        panel.add(location);

        course_panel.add(panel);
        course_panel.updateUI();
    }
}
