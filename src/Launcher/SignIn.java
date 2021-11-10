package Launcher;

import javax.swing.*;
import java.awt.*;

public class SignIn{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    private JPanel signInPanel;
    private JTextField emailTf;
    private JPasswordField passwordTf;
    private JButton signInBtn;
    private JButton signUpBtn;
    private JButton forgotPasswordBtn;
    private JButton launchGameBtn;
    private JLabel enterEmailLabel;
    private JLabel enterPasswordLabel;

    public static JFrame frame = new JFrame("SurvivalGame Launcher");

    public SignIn(){
        signInPanel.setPreferredSize(new Dimension(xSize/4,ySize/4));
    }


}