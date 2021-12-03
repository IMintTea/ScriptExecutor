package Launcher;

import SurvivalGame.MyFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Launcher.SignUp;

public class SignIn extends javax.swing.JFrame{
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
    private JPanel picturePanel;
    private JPanel LogoPicturePanel;



    public SignIn(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1070,700));
        this.setLocation(xSize/4-100,ySize/4-100);
        this.add(signInPanel);
        this.setVisible(true);

        signInPanel.setPreferredSize(new Dimension(xSize/4,ySize/4));
        signInPanel.setForeground(new Color(255, 255, 255));

        emailTf.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        emailTf.setBackground(new Color(92, 91, 105, 255));
        emailTf.setForeground(new Color(255, 255, 255));
        passwordTf.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        passwordTf.setBackground(new Color(92, 91, 105));
        passwordTf.setForeground(new Color(255, 255, 255));

        enterEmailLabel.setForeground(new Color(255, 255, 255));
        enterPasswordLabel.setForeground(new Color(255, 255, 255));

        signInBtn.setBackground(new Color(92, 91, 105));
        signInBtn.setForeground(new Color(255, 255, 255));
        signInBtn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        signUpBtn.setBackground(new Color(92, 91, 105));;
        signUpBtn.setForeground(new Color(255, 255, 255));
        signUpBtn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp().setLocation(SignIn.this.getLocation());
                SignIn.this.dispose();
            }
        });

        forgotPasswordBtn.setBackground(new Color(92, 91, 105));
        forgotPasswordBtn.setForeground(new Color(255, 255, 255));
        forgotPasswordBtn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        picturePanel.setLayout(new FlowLayout());
        try {
            BufferedImage myPicture = ImageIO.read(new File(("Images/Launcher/LauncherPanelPicture.png")));
            JLabel launcherImageLabel = new JLabel(new ImageIcon(myPicture));
            picturePanel.add(launcherImageLabel);
            launcherImageLabel.setPreferredSize(new Dimension(picturePanel.getWidth(), picturePanel.getHeight()));
            this.revalidate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogoPicturePanel.setLayout(new FlowLayout());
        try {
            BufferedImage myLogoPicture = ImageIO.read(new File(("Images/Launcher/Logo.png")));
            JLabel launcherLogoLabel = new JLabel(new ImageIcon(myLogoPicture));
            LogoPicturePanel.add(launcherLogoLabel);
            this.revalidate();
        }catch (IOException e){
            e.printStackTrace();
        }

        launchGameBtn.setVisible(false);
        launchGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyFrame();
                SignIn.this.dispose();
            }
        });
    }

}