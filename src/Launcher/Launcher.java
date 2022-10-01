package Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends javax.swing.JFrame{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    private JPanel launcherPanel;
    private JPanel buttonPanel;
    private JLabel backgroundJl;
    private JButton playBtn;
    private JButton backBtn;
    private ImageIcon backgroundII, playII;




    public Launcher(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1070,700));
        this.setLocation(xSize/4-100,ySize/4-100);
        this.add(launcherPanel);
        this.setVisible(true);

        launcherPanel.setPreferredSize(new Dimension(xSize/4,ySize/4));
        launcherPanel.setForeground(new Color(255, 255, 255));


        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Launcher.this.dispose();
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignIn().setLocation(Launcher.this.getLocation());
                Launcher.this.dispose();
            }
        });


    }

    private void createUIComponents() {
        backgroundII = new ImageIcon("Images/Launcher/Launcher.LauncherPanelPicture.png");
        backgroundJl = new JLabel();
        backgroundJl.setIcon(backgroundII);
        backgroundJl.setLocation(0,0);

        playII = new ImageIcon("Images/Launcher/image.png");
        playBtn = new JButton(playII);
        playBtn.setOpaque(false);
        playBtn.setBorder(BorderFactory.createLineBorder(new Color(39,46,66)));

    }
}