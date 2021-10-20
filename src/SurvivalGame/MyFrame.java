package SurvivalGame;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;

import static java.awt.Color.*;

public class MyFrame extends JFrame implements KeyListener {

    //<editor-fold desc="Get Screen Size">
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());
    // Home screen: 1920, 1080 School screen: 1920, 1080
    //</editor-fold>

    JLabel shrek, InventoryButtonImage2;
    JProgressBar healthBar;
    ImageIcon icon, map, youDied, InventoryButtonImage, DamageButtonImage;
    JPanel inventoryPanel, healthBarPanel;
    public static JToggleButton inventoryButton;
    JButton damage, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;

//    InventoryHandler iHandler = new InventoryHandler();

    Player currentPlayer;


    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setBackground(black);

        //<editor-fold desc="Death">

        youDied = new ImageIcon("Images/YouDied.png");
        JLabel death = new JLabel();
        death.setSize(412, 122);
        death.setLocation((xSize / 2) - 206, 300);
        death.setIcon(youDied);
        this.add(death);
        death.setVisible(false);
        //</editor-fold>

        //<editor-fold desc="Health Bar">
        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(250, 250, 500, 30);
        healthBarPanel.setLocation((xSize / 2) - 250, 950);
        healthBarPanel.setBackground(BLACK);
        healthBarPanel.setForeground(GRAY);
        this.add(healthBarPanel);

        healthBar = new JProgressBar(0, 100);
        healthBar.setPreferredSize(new Dimension(500, 20));
        healthBar.setValue(Game.getCurrentPlayer().playerHp);
        healthBar.setBackground(GRAY);
        healthBar.setForeground(RED);
        healthBarPanel.add(healthBar);
        //</editor-fold>

        //<editor-fold desc="Damage Button">
        DamageButtonImage = new ImageIcon("Images/DamageButton.png");
        damage = new JButton(DamageButtonImage);
        damage.setOpaque(false);
        damage.setForeground(white);
        damage.setBackground(black);
        damage.setSize(80, 80);
        damage.setLocation((xSize / 2) + 250, 970);
        damage.setVisible(true);
        this.add(damage);
        damage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int damageAmount = -10;
                healthBar.setValue((Game.getCurrentPlayer().playerHp) + damageAmount);
                (Game.getCurrentPlayer().playerHp) = (Game.getCurrentPlayer().playerHp) + damageAmount;
                System.out.println(Game.getCurrentPlayer().playerHp);

            }
        });
        if (Game.getCurrentPlayer().playerHp <= 0) {
            death.setVisible(true);
            this.repaint();
            this.revalidate();
        }
        //</editor-fold>

        //<editor-fold desc="Inventory Button">
        InventoryButtonImage = new ImageIcon("Images/InventoryButton.png");
        inventoryButton = new JToggleButton(InventoryButtonImage);
        inventoryButton.setOpaque(false);
        inventoryButton.setBackground(white);
        inventoryButton.setForeground(white);
        inventoryButton.setSize(80, 80);
        inventoryButton.setLocation((xSize / 2) - 330, 970);
        inventoryButton.setVisible(true);
        inventoryButton.setFocusPainted(false);
        //inventoryButton.addActionListener(iHandler);
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryButtonAction(e);
            }
        });


        inventoryButton.setActionCommand("inventoryButton");
        this.add(inventoryButton);
        //</editor-fold>

        //<editor-fold desc="Inventory Contents">
        inventoryPanel = new JPanel();
        inventoryPanel.setBackground(black);
        inventoryPanel.setForeground(black);
        inventoryPanel.setBounds(650, 200, 600, 600);
        inventoryPanel.setLayout(new GridLayout(5, 1));
        this.add(inventoryPanel);

        itemButton1 = new JButton();
        itemButton1.setBackground(black);
        itemButton1.setForeground(white);
        itemButton1.setFocusPainted(false);
        itemButton1.addActionListener(inventoryButton.getAction());
        itemButton1.setActionCommand("item1");
        itemButton1.setText(Game.currentPlayer.getPlayerItems()[0].getName());
        itemButton2 = new JButton();
        itemButton2.setBackground(black);
        itemButton2.setForeground(white);
        itemButton2.setFocusPainted(false);
        itemButton2.addActionListener(inventoryButton.getAction());
        itemButton2.setActionCommand("item2");
        itemButton2.setText(Game.currentPlayer.getPlayerItems()[1].getName());
        itemButton3 = new JButton();
        itemButton3.setBackground(black);
        itemButton3.setForeground(white);
        itemButton3.setFocusPainted(false);
        itemButton3.addActionListener(inventoryButton.getAction());
        itemButton3.setActionCommand("item3");
        itemButton3.setText(Game.currentPlayer.getPlayerItems()[2].getName());
        itemButton4 = new JButton();
        itemButton4.setBackground(black);
        itemButton4.setForeground(white);
        itemButton4.setFocusPainted(false);
        itemButton4.addActionListener(inventoryButton.getAction());
        itemButton4.setActionCommand("item4");
        itemButton4.setText(Game.currentPlayer.getPlayerItems()[3].getName());
        itemButton5 = new JButton();
        itemButton5.setBackground(black);
        itemButton5.setForeground(white);
        itemButton5.setFocusPainted(false);
        itemButton5.addActionListener(inventoryButton.getAction());
        itemButton5.setActionCommand("item5");
        itemButton5.setText(Game.currentPlayer.getPlayerItems()[4].getName());

        inventoryPanel.add(itemButton1);
        inventoryPanel.add(itemButton2);
        inventoryPanel.add(itemButton3);
        inventoryPanel.add(itemButton4);
        inventoryPanel.add(itemButton5);

        inventoryPanel.setVisible(false);
        //</editor-fold>


        //<editor-fold desc="Player Model">
        icon = new ImageIcon("Images/Shrek.png");
        shrek = new JLabel();
        shrek.setBounds(0, 0, 200, 200);
        shrek.setIcon(icon);
        //this.add(shrek);
        //</editor-fold>

        //<editor-fold desc="Map">
        map = new ImageIcon("Images/Map1.png");
        JLabel jl = new JLabel();
        jl.setSize(xSize, ySize);
        jl.setIcon(map);
        this.add(jl);
        //</editor-fold>

        this.setVisible(true);


    }

    public void InventoryButtonAction(ActionEvent e) {
        currentPlayer = Game.currentPlayer;

        String yourChoice = e.getActionCommand();


        switch (yourChoice) {
            case "inventoryButton":
                if (inventoryButton.isSelected() && currentPlayer.inventoryStatus.equals("close")) {


                    inventoryPanel.setVisible(true);

                    currentPlayer.inventoryStatus = "Open";


                } else {

                    inventoryPanel.setVisible(false);

                    currentPlayer.inventoryStatus = "close";


                }


                break;
            case "item1":
                currentPlayer.itemUsed(0);
                break;
            case "item2":
                currentPlayer.itemUsed(1);
                break;
            case "item3":
                currentPlayer.itemUsed(2);
                break;
            case "item4":
                currentPlayer.itemUsed(3);
                break;
            case "item5":
                currentPlayer.itemUsed(4);
                break;
        }
    }

    //<editor-fold desc="Player Movement">
    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'a':
                shrek.setLocation(shrek.getX() - 15, shrek.getY());
                break;
            case 'w':
                shrek.setLocation(shrek.getX(), shrek.getY() - 15);
                break;
            case 's':
                shrek.setLocation(shrek.getX(), shrek.getY() + 15);
                break;
            case 'd':
                shrek.setLocation(shrek.getX() + 15, shrek.getY());
                break;

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37:
                shrek.setLocation(shrek.getX() - 15, shrek.getY());
                break;
            case 38:
                shrek.setLocation(shrek.getX(), shrek.getY() - 15);
                break;
            case 39:
                shrek.setLocation(shrek.getX() + 15, shrek.getY());
                break;
            case 40:
                shrek.setLocation(shrek.getX(), shrek.getY() + 15);
                break;
        }

        if (shrek.getX() == 0) {
            shrek.setLocation(shrek.getX() + 15, shrek.getY());
        }
        if (shrek.getY() == 0) {
            shrek.setLocation(shrek.getX(), shrek.getY() + 15);
        }
        if (shrek.getX() == 1770) {
            shrek.setLocation(shrek.getX() - 15, shrek.getY());
        }
        if (shrek.getY() == 840) {
            shrek.setLocation(shrek.getX(), shrek.getY() - 15);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
    //</editor-fold>
}

