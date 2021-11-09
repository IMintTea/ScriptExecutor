package SurvivalGame;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());
    private JPanel panel1;
    private JTextField EmailTf;
    private JPasswordField PaswordTf;


    Launcher(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setSize(xSize/2,ySize/2);
        this.setLocation(xSize/4,ySize/4);
        this.setVisible(true);
    }
}