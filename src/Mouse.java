import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    JPanel coursePanel;

    public Mouse(JPanel coursePanel){
        this.coursePanel = coursePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int btn = e.getButton();//获取鼠标按键
        switch (btn) {
            case MouseEvent.BUTTON1:
                DialogOfCourse dialogOfCourse1 = new DialogOfCourse(coursePanel, e.getComponent());
                break;
            case MouseEvent.BUTTON2:
                break;
            case MouseEvent.BUTTON3:
                DialogOfCourse dialogOfCourse2 = new DialogOfCourse(coursePanel);
                break;
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
