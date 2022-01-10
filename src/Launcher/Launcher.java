package Launcher;

import javax.swing.*;
import java.awt.*;

public class Launcher extends javax.swing.JFrame{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    private JPanel launcherPanel;
    private JPanel buttonPanel;
    private JLabel backgroundJl;
    private ImageIcon backgroundII;




    public Launcher(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1070,700));
        this.setLocation(xSize/4-100,ySize/4-100);
        this.add(launcherPanel);
        this.setVisible(true);

        launcherPanel.setPreferredSize(new Dimension(xSize/4,ySize/4));
        launcherPanel.setForeground(new Color(255, 255, 255));





    }

    private void createUIComponents() {
        backgroundII = new ImageIcon("Images/Launcher/Launcher.LauncherPanelPicture.png");
        backgroundJl = new JLabel();
        backgroundJl.setIcon(backgroundII);
        backgroundJl.setLocation(0,0);

    }
}