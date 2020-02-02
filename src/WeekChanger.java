import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeekChanger extends JPanel implements ActionListener {
    JLabel weekLabel;

    public WeekChanger(){
        this.setPreferredSize(new Dimension(1000, 100));
        this.setLayout(null);
        this.setBounds(0, 500, 1000, 100);

        weekLabel = new JLabel(Timer.targetWeek + " ");
        weekLabel.setBounds(125, 0, 50, 50);

        JButton sub = new JButton("sub");
        sub.setPreferredSize(new Dimension(100, 30));
        sub.setBounds(0, 0, 100, 30);
        sub.addActionListener(this);
        sub.setActionCommand("sub");

        JButton add = new JButton("add");
        add.setPreferredSize(new Dimension(100, 30));
        add.setBounds(150, 0, 100, 30);
        add.addActionListener(this);
        add.setActionCommand("add");

        this.add(weekLabel);
        this.add(sub);
        this.add(add);
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        switch (cmd){
            case "add":
                Demo.timer.addTargetWeek();
                System.out.println(Demo.timer.targetWeek);
                Init.updateCoursePanel();
                weekLabel.setText(Timer.targetWeek + " ");
                this.updateUI();
                break;
            case "sub":
                Demo.timer.subTargetWeek();
                System.out.println(Demo.timer.targetWeek);
                Init.updateCoursePanel();
                weekLabel.setText(Timer.targetWeek + " ");
                this.updateUI();
                break;
            default:
                break;
        }
    }
}
