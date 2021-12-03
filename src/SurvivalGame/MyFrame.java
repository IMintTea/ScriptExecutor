package SurvivalGame;

import org.w3c.dom.ls.LSOutput;

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
    Boolean dead = false;
    JLabel BigLez, Map;
    JProgressBar healthBar, staminaBar, manaBar;
    ImageIcon icon, map, youDied, InventoryButtonImage, DamageButtonImage;
    JPanel inventoryPanel, healthBarPanel, staminaBarPanel, manaBarPanel;
    public static JToggleButton inventoryButton;
    JButton damage, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;

//    InventoryHandler iHandler = new InventoryHandler();

    Player currentPlayer;

    // https://www.pinterest.co.uk/0heape4vu8xhohi/2d-tile-map/


    public MyFrame() {

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
        death.setVisible(dead);
        //</editor-fold>

        //<editor-fold desc="Stamina Bar">
        staminaBarPanel = new JPanel();
        staminaBarPanel.setBounds(250, 250, 250, 30);
        staminaBarPanel.setLocation((xSize / 2) - 250 -80, 925);
        staminaBarPanel.setBackground(BLACK);
        staminaBarPanel.setForeground(GRAY);
        this.add(staminaBarPanel);

        staminaBar = new JProgressBar(0, 100);
        staminaBar.setPreferredSize(new Dimension(500, 20));
        staminaBar.setValue(Game.getCurrentPlayer().playerHp);
        staminaBar.setBackground(GRAY);
        staminaBar.setForeground(YELLOW);
        staminaBarPanel.add(staminaBar);
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

        //<editor-fold desc="Mana Bar">
        manaBarPanel = new JPanel();
        manaBarPanel.setBounds(250, 250, 250, 30);
        manaBarPanel.setLocation((xSize / 2) + 80, 925);
        manaBarPanel.setBackground(BLACK);
        manaBarPanel.setForeground(GRAY);
        this.add(manaBarPanel);

        manaBar = new JProgressBar(0, 100);
        manaBar.setPreferredSize(new Dimension(500, 20));
        manaBar.setValue(Game.getCurrentPlayer().playerHp);
        manaBar.setBackground(GRAY);
        manaBar.setForeground(BLUE);
        manaBarPanel.add(manaBar);
        //</editor-fold>

        //<editor-fold desc="Damage Button">
        DamageButtonImage = new ImageIcon("Images/DamageButton.png");
        damage = new JButton(DamageButtonImage);
        damage.setOpaque(false);
        damage.setForeground(white);
        damage.setBackground(black);
        damage.setSize(80, 80);
        damage.setLocation((xSize / 2) + 250, 955);
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
        inventoryButton.setLocation((xSize / 2) - 330, 955);
        inventoryButton.setVisible(true);
        inventoryButton.setFocusPainted(false);
//        inventoryButton.addActionListener(iHandler);
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
        icon = new ImageIcon("Images/BigLez.png");
        BigLez = new JLabel();
        BigLez.setBounds(0, 0, 130, 300);
        BigLez.setIcon(icon);
        BigLez.setLocation(xSize/2,ySize/2);
        this.add(BigLez);
        //</editor-fold>

        //<editor-fold desc="Map">
        map = new ImageIcon("Images/Map.png");
        Map = new JLabel();
        Map.setIcon(map);
        Map.setBounds(0, 0, 1920, 1080);
        Map.setLocation(0,0);
        // https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKULiPgDxSn08wYLVRS2NNvkeQ2-pnBnvZFdKD5B7rba5b8RAclQs0rXlR-FR4zS6Heoo&usqp=CAU
        this.add(Map);
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

    // do vertical movement.
    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'a':
                BigLez.setLocation(BigLez.getX() - 17, BigLez.getY());
                break;
            case 'w':
                BigLez.setLocation(BigLez.getX(), BigLez.getY() - 17);
                break;
            case 's':
                BigLez.setLocation(BigLez.getX(), BigLez.getY() + 17);
                break;
            case 'd':
                BigLez.setLocation(BigLez.getX() + 17, BigLez.getY());
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 39:
                Map.setLocation(Map.getX() - 17, Map.getY());
                break;
            case 40:
                Map.setLocation(Map.getX(), Map.getY() - 17);
                break;
            case 37:
                Map.setLocation(Map.getX() + 17, Map.getY());
                break;
            case 38:
                Map.setLocation(Map.getX(), Map.getY() + 17);
                break;
        }

        if (BigLez.getX() == 0) {
            BigLez.setLocation(BigLez.getX() + 17, BigLez.getY());
        }
        if (BigLez.getY() == 0) {
            BigLez.setLocation(BigLez.getX(), BigLez.getY() + 17);
        }
        if (BigLez.getX() == 1770) {
            BigLez.setLocation(BigLez.getX() - 17, BigLez.getY());
        }
        if (BigLez.getY() == 840) {
            BigLez.setLocation(BigLez.getX(), BigLez.getY() - 17);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
    //</editor-fold>
}

