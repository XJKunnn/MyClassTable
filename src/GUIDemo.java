import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDemo extends JPanel implements ActionListener {
    static JPanel courses;
    static int OFFSET_DAY = 79;
    static int OFFSET_LESSEN = 40;

    GUIDemo(){
        setLayout(null);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(900, 600));

        JPanel course_panel = new JPanel();
        course_panel.setLayout(null);
        course_panel.setPreferredSize(new Dimension(800, 600));
        course_panel.setBounds(0, 0, 800, 600);
        course_panel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel lessens = new JPanel();
        lessens.setLayout(null);
        lessens.setPreferredSize(new Dimension(50, 580));
        lessens.setBounds(10, 10, 50, 580);
        lessens.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel blank = new JPanel();
        blank.setPreferredSize(new Dimension(50, 50));
        blank.setBounds(0, 0, 50, 50);
        lessens.add(blank);

        int offset_lessen = 0;

        for(int i = 0; i < 13; i++){
            JPanel new_date = new JPanel();
            new_date.setPreferredSize(new Dimension(50, 40));
            new_date.setBounds(0, 60+offset_lessen, 50, 40);
            JLabel label = new JLabel(" "+(i+1)+" ");
            new_date.add(label);
            offset_lessen += 40;

            lessens.add(new_date);
        }

        JPanel weekContainer = new JPanel();
        weekContainer.setPreferredSize(new Dimension(700, 580));
        weekContainer.setBounds(65, 10, 700, 580);
        weekContainer.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel week = new JPanel();
        week.setPreferredSize(new Dimension(680, 50));
        week.setBounds(10, 10, 680, 50);
        week.setBorder(BorderFactory.createLineBorder(Color.black));

        int offset_day = 0;

        for(int j = 0; j < 7; j++){
            JPanel day = new JPanel();
            day.setPreferredSize(new Dimension(79, 50));
            day.setBounds(offset_day, 0, 79, 50);
            JLabel day1 = new JLabel(" "+(j+1)+" ");
            day.add(day1);
            week.add(day);
            offset_day += 79;
        }

        courses = new JPanel();
        courses.setLayout(null);
        courses.setPreferredSize(new Dimension(680, 480));
        courses.setBounds(10, 80, 680, 480);
        courses.setBorder(BorderFactory.createLineBorder(Color.black));

        weekContainer.add(week);
        weekContainer.add(courses);

        course_panel.add(lessens);
        course_panel.add(weekContainer);

        JPanel controls = new JPanel();
        controls.setLayout(null);
        controls.setBounds(810, 0, 80, 600);
        controls.setBorder(BorderFactory.createTitledBorder("controls"));

        JButton add_course = new JButton("add course");
        add_course.setBounds(0, 0, 80, 100);
        add_course.setActionCommand("add");
        add_course.addActionListener(this);

        JButton delete_course = new JButton("delete course");
        delete_course.setBounds(0, 110, 80, 100);
        delete_course.setActionCommand("delete");
        delete_course.addActionListener(this);

        controls.add(add_course);
        controls.add(delete_course);

        add(course_panel);
        add(controls);
    }

    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "add": {
                JPanel a = new JPanel();
                a.setBounds(OFFSET_DAY * 3, OFFSET_LESSEN * 2, 79, 3 * OFFSET_LESSEN);
                a.setBackground(Color.BLUE);
                a.setVisible(true);
                courses.add(a);
                updateUI();
                break;
            }
            case "delete": {

            }
            default: break;
        }
    }

    public void createAndShowGUI(){
        JFrame frame = new JFrame("GUIDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 700));

        GUIDemo mainpanel = new GUIDemo();
        frame.add(mainpanel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIDemo demo = new GUIDemo();
                demo.createAndShowGUI();
            }
        });
    }
}
