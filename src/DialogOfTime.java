import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DialogOfTime extends JDialog implements ActionListener {
    static final int DIALOG_OF_TIME_WIDTH = 300;
    static final int DIALOG_OF_TIME_HEIGHT = 200;
    static final int PANEL_WIDTH = 300;
    static final int PANEL_HEIGHT = 50;
    static final int LABEL_X_MARGIN = 30;
    static final int LABEL_Y_MARGIN = 20;
    static final int LABEL_WIDTH = 130;
    static final int LABEL_HEIGHT = 40;
    static final int TEXT_X_MARGIN = 160;
    static final int TEXT_Y_MARGIN = 30;
    static final int TEXT_WIDTH = 100;
    static final int TEXT_HEIGHT = 20;
    JTextField startTimeText, lengthText;

    Timer timer;
    Date startDate, endDate;

    static private JPanel course_panel;

    public DialogOfTime(){
        this.setPreferredSize(new Dimension(DIALOG_OF_TIME_WIDTH, DIALOG_OF_TIME_HEIGHT));
        this.setBounds(200, 200, DIALOG_OF_TIME_WIDTH, DIALOG_OF_TIME_HEIGHT);
        this.setLayout(null);

        JPanel startTimePanel = new JPanel();
        startTimePanel.setLayout(null);
        startTimePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        startTimePanel.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        JLabel startTimeLabel = new JLabel("请输入学期开始时间");
        startTimeLabel.setBounds(LABEL_X_MARGIN, LABEL_Y_MARGIN, LABEL_WIDTH, LABEL_HEIGHT);

        startTimeText = new JTextField("yyyy-MM-DD");
        startTimeText.setBounds(TEXT_X_MARGIN, TEXT_Y_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);

        startTimePanel.add(startTimeLabel);
        startTimePanel.add(startTimeText);

        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(null);
        lengthPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        lengthPanel.setBounds(0, PANEL_HEIGHT, PANEL_WIDTH, PANEL_HEIGHT);

        JLabel lengthLabel = new JLabel("请输入学期课程周数");
        lengthLabel.setBounds(LABEL_X_MARGIN, LABEL_Y_MARGIN, LABEL_WIDTH, LABEL_HEIGHT);

        lengthText = new JTextField();
        lengthText.setBounds(TEXT_X_MARGIN, TEXT_Y_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);

        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthText);

        JPanel buttonPanel= new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        buttonPanel.setBounds(0, PANEL_HEIGHT * 2, PANEL_WIDTH, PANEL_HEIGHT);

        JButton confirm = new JButton("确定");
        confirm.addActionListener(this);
        confirm.setActionCommand("confirm");
        confirm.setBounds(50, 20, 80, 30);

        JButton cancel = new JButton("取消");
        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");
        cancel.setBounds(150, 20, 80, 30);

        buttonPanel.add(confirm);
        buttonPanel.add(cancel);

        this.add(startTimePanel);
        this.add(lengthPanel);
        this.add(buttonPanel);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        switch (cmd){
            case "confirm":
                try{
                    String setTime = startTimeText.getText();
                    int lengthWeek = Integer.parseInt(lengthText.getText());
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");       //dd not DD
                    Date setDate = sf.parse(setTime);
                    timer = new Timer(setDate, lengthWeek);
                    this.setStartDate(timer.getStartDate());
                    this.setEndDate(timer.getEndDate());
                    new Conn().addTime(timer);
                    Init init = new Init(course_panel);
                    init.createAndShowGUI();
                    new Conn().findDate();
                    init.calStartWeek(Demo.startDate);
                    System.out.println(Demo.startDate + " " + Demo.endDate );
                    init.firstSHowCourse();
                    this.setVisible(false);
                    break;
                } catch (ParseException pe){
                    pe.printStackTrace();
                }
            case "cancel":
                break;
            default:
                break;
        }
    }



    public Timer getTimer(){
        return timer;
    }

    public void setStartDate(Date date){
        this.startDate = date;
    }

    public void setEndDate(Date date){
        this.endDate = date;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }
}
