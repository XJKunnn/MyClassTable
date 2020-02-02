import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener, ItemListener {
    JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";

    public JMenuBar createMenuBar(){
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem radioButtonMenuItem;
        JCheckBoxMenuItem checkBoxMenuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menu.addActionListener(this);
        menu.setActionCommand("menu1");
        menuBar.add(menu);

        menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        ImageIcon icon = createImageIcon("img/1.gif");
        menuItem = new JMenuItem("Both text and icon", icon);
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(icon);
        menuItem.setMnemonic(KeyEvent.VK_D);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();

        radioButtonMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        radioButtonMenuItem.setSelected(true);
        radioButtonMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(radioButtonMenuItem);
        radioButtonMenuItem.addActionListener(this);
        menu.add(radioButtonMenuItem);

        radioButtonMenuItem = new JRadioButtonMenuItem("Another one");
        radioButtonMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(radioButtonMenuItem);
        radioButtonMenuItem.addActionListener(this);
        menu.add(radioButtonMenuItem);

        menu.addSeparator();
        checkBoxMenuItem = new JCheckBoxMenuItem("A check box menu item");
        checkBoxMenuItem.setMnemonic(KeyEvent.VK_C);
        checkBoxMenuItem.addActionListener(this);
        menu.add(checkBoxMenuItem);

        checkBoxMenuItem = new JCheckBoxMenuItem("Another one");
        checkBoxMenuItem.setMnemonic(KeyEvent.VK_H);
        checkBoxMenuItem.addActionListener(this);
        menu.add(checkBoxMenuItem);

        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        menuItem.addActionListener(this);
        submenu.add(menuItem);
        menu.add(submenu);

        menu = new JMenu("Another menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
        menuBar.add(menu);

        return menuBar;
    }

    public Container createContentPane(){
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(true);

        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        contentPanel.add(scrollPane, BorderLayout.CENTER);

        return contentPanel;
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if("menu1".equals(cmd)){
            System.out.println("menu1 is pressed!");
        } else {
            System.out.println("nothing");
        }
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Action event detected."
                + newline
                + "     Event source:" + source.getText()
                + "  (an instance of " + getClassName(source) + ")";
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

    public void itemStateChanged(ItemEvent e){
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Item event detected."
                + newline
                + "     Event source:" + source.getText()
                + "  (an instance of " + getClassName(source) + ")"
                + newline
                + "     New state: "
                + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected" : "unselected");
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

    protected String getClassName(Object o){
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex + 1);
    }

    protected static ImageIcon createImageIcon(String path){
        java.net.URL imgURL = MenuPanel.class.getResource(path);
        if(imgURL != null){
            return new ImageIcon(imgURL);
        } else {
            System.err.println("could not find file: " + imgURL);
            return null;
        }
    }

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("menuDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuPanel menuPanel = new MenuPanel();
        frame.setJMenuBar(menuPanel.createMenuBar());
        frame.setContentPane(menuPanel.createContentPane());

        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
