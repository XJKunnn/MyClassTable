import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int btn = e.getButton();//获取鼠标按键
        switch (btn) {
            case MouseEvent.BUTTON1:
                DialogOfCourse dialogOfCourse = new DialogOfCourse(e.getComponent());
                break;
            case MouseEvent.BUTTON2:
                break;
            case MouseEvent.BUTTON3:
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
