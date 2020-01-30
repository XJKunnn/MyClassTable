import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogOfCourse extends JDialog implements ActionListener {
    Component component;
    JPanel coursePanel;
    JTextField nameText, startWeekText, endWeekText, locationText;
    JComboBox startTimeBox, endTimeBox, courseDayBox;

    public DialogOfCourse(JPanel coursePanel){            //当课程不存在时，初始化消息框
        super();
        this.coursePanel = coursePanel;
        this.setPreferredSize(new Dimension(200, 500));
        this.setBounds(200, 200, 300, 500);

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(null);
        dialogPanel.setPreferredSize(new Dimension(200, 500));
        dialogPanel.setBounds(0, 0, 300, 500);

        JLabel label = new JLabel("课程设置");
        label.setBounds(100, 10, 140, 30);
        label.setFont(new Font("宋体", Font.PLAIN, 20));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(null);
        namePanel.setPreferredSize(new Dimension(300, 40));
        namePanel.setBounds(0, 45, 300, 40);

        JLabel nameLabel = new JLabel("课程名称");
        nameLabel.setBounds(20, 0, 50, 40);

        nameText = new JTextField("请输入课程名称");
        nameText.setBounds(90, 12, 150, 20);

        namePanel.add(nameLabel);
        namePanel.add(nameText);

        JPanel startTimePanel = new JPanel();
        startTimePanel.setLayout(null);
        startTimePanel.setPreferredSize(new Dimension(300, 40));
        startTimePanel.setBounds(0, 90, 300, 40);

        JLabel startTimeLabel = new JLabel("开始时间");
        startTimeLabel.setBounds(20, 0, 50, 40);

        String[] course_time = {"1", "2", "3", "4", "5", "6", "7", "8",
                                "9", "10", "11", "12", "13"};

        startTimeBox = new JComboBox(course_time);
        startTimeBox.setBounds(90, 12, 150, 20);
        //actionListener

        startTimePanel.add(startTimeLabel);
        startTimePanel.add(startTimeBox);

        JPanel endTimePanel = new JPanel();
        endTimePanel.setLayout(null);
        endTimePanel.setPreferredSize(new Dimension(300, 40));
        endTimePanel.setBounds(0, 135, 300, 40);

        JLabel endTimeLabel = new JLabel("结束时间");
        endTimeLabel.setBounds(20, 0, 50, 40);

        endTimeBox = new JComboBox(course_time);
        endTimeBox.setBounds(90, 12, 150, 20);
        //actionListener

        endTimePanel.add(endTimeLabel);
        endTimePanel.add(endTimeBox);

        JPanel startWeekPanel = new JPanel();
        startWeekPanel.setLayout(null);
        startWeekPanel.setPreferredSize(new Dimension(300, 40));
        startWeekPanel.setBounds(0, 180, 300, 40);

        JLabel startWeekLabel = new JLabel("开始周数");
        startWeekLabel.setBounds(20, 0, 50, 40);

        startWeekText = new JTextField("请输入课程开始周数");
        startWeekText.setBounds(90, 12, 150, 20);
        //actionListener

        startWeekPanel.add(startWeekLabel);
        startWeekPanel.add(startWeekText);

        JPanel endWeekPanel = new JPanel();
        endWeekPanel.setLayout(null);
        endWeekPanel.setPreferredSize(new Dimension(300, 40));
        endWeekPanel.setBounds(0, 225, 300, 40);

        JLabel endWeekLabel = new JLabel("结束周数");
        endWeekLabel.setBounds(20, 0, 50, 40);

        endWeekText = new JTextField("请输入课程结束周数");
        endWeekText.setBounds(90, 12, 150, 20);
        //actionListener

        endWeekPanel.add(endWeekLabel);
        endWeekPanel.add(endWeekText);

        JPanel courseDayPanel = new JPanel();
        courseDayPanel.setLayout(null);
        courseDayPanel.setPreferredSize(new Dimension(300, 40));
        courseDayPanel.setBounds(0, 270, 300, 40);

        JLabel courseDayLabel = new JLabel("课程日期");
        courseDayLabel.setBounds(20, 0, 50, 40);

        String[] course_day = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

        courseDayBox = new JComboBox(course_day);
        courseDayBox.setBounds(90, 12, 150, 20);
        //actionListener

        courseDayPanel.add(courseDayLabel);
        courseDayPanel.add(courseDayBox);

        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(null);
        locationPanel.setPreferredSize(new Dimension(300, 40));
        locationPanel.setBounds(0, 315, 300, 40);

        JLabel locationLabel = new JLabel("课程地点");
        locationLabel.setBounds(20, 0, 50, 40);

        locationText = new JTextField("请输入课程地点");
        locationText.setBounds(90, 12, 150, 20);
        //actionListener

        locationPanel.add(locationLabel);
        locationPanel.add(locationText);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300, 40));
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 360, 300, 40);

        JButton confirm = new JButton("确定");
        confirm.setActionCommand("confirm");
        confirm.setPreferredSize(new Dimension(50, 30));
        confirm.setBounds(20, 0, 80, 30);
        confirm.addActionListener(this);
        confirm.setVisible(true);
        //actionListener

        JButton cancel = new JButton("取消");
//        cancel.setActionCommand("cancel");
        cancel.setBounds(150, 0, 80, 30);
//        cancel.addActionListener(this);
        //actionListener

        buttonPanel.add(confirm);
        buttonPanel.add(cancel);

        dialogPanel.add(label);
        dialogPanel.add(namePanel);
        dialogPanel.add(startTimePanel);
        dialogPanel.add(endTimePanel);
        dialogPanel.add(startWeekPanel);
        dialogPanel.add(endWeekPanel);
        dialogPanel.add(courseDayPanel);
        dialogPanel.add(locationPanel);
        dialogPanel.add(buttonPanel);

        this.add(dialogPanel);
        this.setVisible(true);
    }

    public DialogOfCourse(Component component){     //当课程存在时，初始化消息框
        super();
        this.component = component;

        this.setPreferredSize(new Dimension(100, 100));
        this.setBounds(0,0,100, 100);

        JButton button = new JButton("delete");
        button.addActionListener(this);
        button.setActionCommand("delete");

        this.add(button);
        this.setVisible(true);
    }

    public void deleteCourse(){
        component.setVisible(false);
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        switch (cmd){
            case "delete":{
                deleteCourse();
                JPanel panel = (JPanel)component;
                JLabel label = (JLabel)panel.getComponent(0);
                String name = label.getText();
                Conn con = new Conn();
                con.deleteCourse(name);
                break;
            }
            case "confirm":
                String name = nameText.getText();
                String location = locationText.getText();
                int startWeek = Integer.parseInt(startWeekText.getText());
                int endWeek = Integer.parseInt(endWeekText.getText());
                int startTime = startTimeBox.getSelectedIndex() + 1;
                int endTime = endTimeBox.getSelectedIndex() + 1;
                int courseDay = courseDayBox.getSelectedIndex();
                Course course = new Course(name, startTime, endTime, courseDay, location);
                new AddCourse(coursePanel, course);
                new Conn().addCourse(course);
                break;
            case "cancel":
                //cancel
                break;
            default:break;
        }
    }

    public static void main(String args[]){
//        DialogOfCourse dialogOfCourse = new DialogOfCourse();
    }
}
