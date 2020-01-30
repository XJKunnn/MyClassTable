import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogOfCourse extends JDialog implements ActionListener {
    Component component;

    public DialogOfCourse(Component component){
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
        if("delete".equals(e.getActionCommand())){
            deleteCourse();
            JPanel panel = (JPanel)component;
            JLabel label = (JLabel)panel.getComponent(0);
            String name = label.getText();
            Conn con = new Conn();
            con.deleteCourse(name);
        }
    }
}
