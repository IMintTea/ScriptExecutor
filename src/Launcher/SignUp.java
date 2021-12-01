package Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SignUp extends javax.swing.JFrame{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    private JTextField emailTf;
    private JPasswordField passwordTf;
    private JLabel enterEmailLabel;
    private JLabel enterPasswordLabel;
    private JPanel picturePanel;
    private JPanel LogoPicturePanel;
    private JPanel signUpPanel;
    private JButton backBtn;
    private JButton registerBtn;
    private JLabel confirmPasswordLb;
    private JPasswordField confirmPasswordTf;
    private JTextField accountNameTf;
    private JLabel accountNameLb;

    public SignUp(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1070,700));
        this.setLocation(xSize/4-100,ySize/4-100);
        this.add(signUpPanel);
        this.setVisible(true);

        signUpPanel.setPreferredSize(new Dimension(xSize/4,ySize/4));
        signUpPanel.setForeground(new Color(255, 255, 255));

        emailTf.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        emailTf.setBackground(new Color(92, 91, 105, 255));
        emailTf.setForeground(new Color(255, 255, 255));
        accountNameTf.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        accountNameTf.setBackground(new Color(92, 91, 105, 255));
        accountNameTf.setForeground(new Color(255, 255, 255));
        passwordTf.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        passwordTf.setBackground(new Color(92, 91, 105));
        passwordTf.setForeground(new Color(255, 255, 255));
        confirmPasswordTf.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        confirmPasswordTf.setBackground(new Color(92, 91, 105));
        confirmPasswordTf.setForeground(new Color(255, 255, 255));

        accountNameLb.setForeground(new Color(255, 255, 255));
        enterEmailLabel.setForeground(new Color(255, 255, 255));
        enterPasswordLabel.setForeground(new Color(255, 255, 255));
        confirmPasswordLb.setForeground(new Color(255, 255, 255));

        backBtn.setBackground(new Color(92, 91, 105));
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        registerBtn.setBackground(new Color(92, 91, 105));;
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        picturePanel.setLayout(new FlowLayout());
        try {
            BufferedImage myPicture = ImageIO.read(new File(("Images/Launcher/LauncherPanelPicture.png")));
            JLabel launcherImageLabel = new JLabel(new ImageIcon(myPicture));
            picturePanel.add(launcherImageLabel);
            launcherImageLabel.setPreferredSize(new Dimension(picturePanel.getWidth(), picturePanel.getHeight()));
            launcherImageLabel.revalidate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogoPicturePanel.setLayout(new FlowLayout());
        try {
            BufferedImage myLogoPicture = ImageIO.read(new File(("Images/Launcher/Logo.png")));
            JLabel launcherLogoLabel = new JLabel(new ImageIcon(myLogoPicture));
            LogoPicturePanel.add(launcherLogoLabel);
            launcherLogoLabel.revalidate();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}