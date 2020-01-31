import javax.swing.*;
import java.awt.*;
import java.util.List;

public class coursePanel extends JPanel {
    static int LESSEN_OFFSET = 30;
    static JPanel course_panel;

    public coursePanel(){
        setLayout(null);
        this.setPreferredSize(new Dimension(840, 450));

        //lessenPanel
        JPanel lessenPanel = new JPanel();
        lessenPanel.setLayout(null);
        lessenPanel.setPreferredSize(new Dimension(50, 450));
        lessenPanel.setBounds(0, 0, 50, 450);

        JPanel blankPanel = new JPanel();
        blankPanel.setPreferredSize(new Dimension(50, 60));
        blankPanel.setBounds(0,0, 50, 60);
        blankPanel.setBackground(Color.YELLOW);

        lessenPanel.add(blankPanel);

        for(int i = 1; i <= 13; i++){
            JPanel newLessen = new JPanel();
            newLessen.setPreferredSize(new Dimension(50, 30));
            newLessen.setBounds(0, 60+(i-1)*LESSEN_OFFSET, 50, 30);
            newLessen.setBackground(Color.CYAN);
            JLabel label = new JLabel(" "+i+" ");
            newLessen.add(label);
            lessenPanel.add(newLessen);
        }

        //weekPanel
        JPanel weekPanel = new JPanel();
        weekPanel.setLayout(null);
        weekPanel.setPreferredSize(new Dimension(790, 450));
        weekPanel.setBounds(50, 0, 790, 450);

        //week
        JPanel week = new JPanel();
        week.setLayout(null);
        week.setPreferredSize(new Dimension(790, 60));
        week.setBounds(0, 0, 790, 60);

        int x_offset = 0;

        for(int j = 1; j <= 7; j++){
            JPanel newDay = new JPanel();
            newDay.setLayout(null);
            newDay.setPreferredSize(new Dimension(100, 60));
            newDay.setBounds(x_offset,0, 100, 60);
            newDay.setBackground(Color.CYAN);
            JLabel day = new JLabel(getDay(j));
            day.setBounds(40, 20, 20, 20);
            newDay.add(day);
            week.add(newDay);

            x_offset += 115;
        }

        course_panel = new JPanel();
        course_panel.setLayout(null);
        course_panel.setPreferredSize(new Dimension(790, 390));
        course_panel.setBounds(0, 60, 790, 390);

        blankPanel.addMouseListener(new Mouse(course_panel));

        weekPanel.add(week);
        weekPanel.add(course_panel);

        add(lessenPanel);
        add(weekPanel);
    }

    public JPanel getCourse_panel(){
        return course_panel;
    }

    public String getDay(int i){
        String day = "null";
        switch (i){
            case 1: day = "日";break;
            case 2: day = "一";break;
            case 3: day = "二";break;
            case 4: day = "三";break;
            case 5: day = "四";break;
            case 6: day = "五";break;
            case 7: day = "六";break;
            default: break;
        }
        return day;
    }

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("coursePanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        coursePanel course_panel = new coursePanel();
        frame.add(course_panel);

        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
                Conn con = new Conn();
                List<Course> getCourse = con.getCourse();
                for(int n = 0; n < getCourse.size(); n++){
                    new AddCourse(course_panel, getCourse.get(n));
                }
//                DialogOfCourse dialogOfCourse = new DialogOfCourse(course_panel);
            }
        });
    }
}
