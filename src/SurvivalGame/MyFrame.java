package SurvivalGame;

import org.w3c.dom.ls.LSOutput;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


import static java.awt.Color.*;

public class MyFrame extends JFrame implements KeyListener {

    //<editor-fold desc="Get Screen Size">
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    // Home screen: 1920, 1080 School screen: 1920, 1080
    //</editor-fold>
    Boolean dead = false;
    JLabel playerJl, map, mapDetails, mapSolidObjects;
    JProgressBar healthBar, staminaBar, manaBar;
    ImageIcon playerIcon, mapIcon, mapDetailsIcon, mapSolidObjectsIcon, youDied, InventoryButtonImage, DamageButtonImage;
    JPanel inventoryPanel, healthBarPanel, staminaBarPanel, manaBarPanel;
    public static JToggleButton inventoryButton;
    JButton damage, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
    public ImageIcon up1, up2, up3, up4, down1, down2, down3, down4, left1, left2, left3, left4, right1, right2, right3, right4;
    int spriteCounter = 1;
    private GameScreen gameScreen;

//    InventoryHandler iHandler = new InventoryHandler();

    Player currentPlayer;

    // https://www.pinterest.co.uk/0heape4vu8xhohi/2d-tile-map/


    public MyFrame() {
        up1 = new ImageIcon("Images/Sprites/WalkingSprites/Player_up_1.png");
        up2 = new ImageIcon("Images/Sprites/WalkingSprites/Player_up_2.png");
        up3 = new ImageIcon("Images/Sprites/WalkingSprites/Player_up_3.png");
        up4 = new ImageIcon("Images/Sprites/WalkingSprites/Player_up_4.png");

        down1 = new ImageIcon("Images/Sprites/WalkingSprites/Player_down_1.png");
        down2 = new ImageIcon("Images/Sprites/WalkingSprites/Player_down_2.png");
        down3 = new ImageIcon("Images/Sprites/WalkingSprites/Player_down_3.png");
        down4 = new ImageIcon("Images/Sprites/WalkingSprites/Player_down_4.png");

        left1 = new ImageIcon("Images/Sprites/WalkingSprites/Player_left_1.png");
        left2 = new ImageIcon("Images/Sprites/WalkingSprites/Player_left_2.png");
        left3 = new ImageIcon("Images/Sprites/WalkingSprites/Player_left_3.png");
        left4 = new ImageIcon("Images/Sprites/WalkingSprites/Player_left_4.png");

        right1 = new ImageIcon("Images/Sprites/WalkingSprites/Player_right_1.png");
        right2 = new ImageIcon("Images/Sprites/WalkingSprites/Player_right_2.png");
        right3 = new ImageIcon("Images/Sprites/WalkingSprites/Player_right_3.png");
        right4 = new ImageIcon("Images/Sprites/WalkingSprites/Player_right_4.png");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(null);
        this.addKeyListener(this);
        this.setSize(xSize,ySize);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);


        gameScreen = new GameScreen();
        this.add(gameScreen);

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
        //this.add(damage);
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
        //*this.add(inventoryButton);
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
        ImageIcon character = null;
        switch (Game.getCurrentPlayer().direction) {
            case "up":
                character = up1;
                break;
            case "down":
                character = down1;
                break;
            case "left":
                character = left1;
                break;
            case "right":
                character = right1;
                break;
        }
//        playerIcon = character;
        playerJl = new JLabel();
        playerJl.setBounds(0, 0, 100, 150);
        playerJl.setIcon(character);
        playerJl.setLocation(1105, 30);
        playerJl.setVisible(true);
        this.add(playerJl);

        //</editor-fold>

        //<editor-fold desc="Map">s
//        mapSolidObjectsIcon = new ImageIcon("Images/Map/SolidObjects.png");
        mapSolidObjects = new JLabel();
        mapSolidObjects.setIcon(mapSolidObjectsIcon);
        mapSolidObjects.setSize(xSize,ySize);
        mapSolidObjects.setLocation(0,0);
        mapSolidObjects.setVisible(true);
        this.add(mapSolidObjects);

//        mapDetailsIcon = new ImageIcon("Images/Map/GroundDetails.png");
        mapDetails = new JLabel();
        mapDetails.setIcon(mapDetailsIcon);
        mapDetails.setSize(xSize,ySize);
        mapDetails.setLocation(0,0);
        mapDetails.setVisible(true);
        this.add(mapDetails);

//        mapIcon = new ImageIcon("Images/Map/HardGround.png");
        map = new JLabel();
        map.setIcon(mapIcon);
        map.setSize(xSize,ySize);
        map.setLocation(0,0);
        map.setVisible(true);
        this.add(map);

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
        if (spriteCounter > 4){
            spriteCounter = 1;
        }

        switch (e.getKeyChar()) {
            case 'a':
                playerJl.setLocation(playerJl.getX() - 15, playerJl.getY());
                Game.getCurrentPlayer().direction = "left";
                System.out.println(Game.getCurrentPlayer().direction);
                if (spriteCounter == 1){
                    playerJl.setIcon(left1);
                }
                if (spriteCounter == 2){
                    playerJl.setIcon(left2);
                }
                if (spriteCounter == 3){
                    playerJl.setIcon(left3);
                }
                if (spriteCounter == 4){
                    playerJl.setIcon(left4);
                }
                spriteCounter++;
                System.out.println(playerJl.getX()+" "+playerJl.getY());
                break;
            case 'w':
                playerJl.setLocation(playerJl.getX(), playerJl.getY() - 15);
                Game.getCurrentPlayer().direction = "up";
                System.out.println(Game.getCurrentPlayer().direction);
                if (spriteCounter == 1){
                    playerJl.setIcon(up1);
                }
                if (spriteCounter == 2){
                    playerJl.setIcon(up2);
                }
                if (spriteCounter == 3){
                    playerJl.setIcon(up3);
                }
                if (spriteCounter == 4){
                    playerJl.setIcon(up4);
                }
                spriteCounter++;
                System.out.println(playerJl.getX()+" "+playerJl.getY());
                break;
            case 's':
                playerJl.setLocation(playerJl.getX(), playerJl.getY() + 15);
                Game.getCurrentPlayer().direction = "down";
                System.out.println(Game.getCurrentPlayer().direction);
                if (spriteCounter == 1){
                    playerJl.setIcon(down1);
                }
                if (spriteCounter == 2){
                    playerJl.setIcon(down2);
                }
                if (spriteCounter == 3){
                    playerJl.setIcon(down3);
                }
                if (spriteCounter == 4){
                    playerJl.setIcon(down4);
                }
                spriteCounter++;
                System.out.println(playerJl.getX()+" "+playerJl.getY());
                break;
            case 'd':
                playerJl.setLocation(playerJl.getX() + 15, playerJl.getY());
                Game.getCurrentPlayer().direction = "right";
                System.out.println(Game.getCurrentPlayer().direction);
                if (spriteCounter == 1){
                    playerJl.setIcon(right1);
                }
                if (spriteCounter == 2){
                    playerJl.setIcon(right2);
                }
                if (spriteCounter == 3){
                    playerJl.setIcon(right3);
                }
                if (spriteCounter == 4){
                    playerJl.setIcon(right4);
                }
                spriteCounter++;
                System.out.println(playerJl.getX()+" "+playerJl.getY());
                break;
        }
        if (playerJl.getX() <= 0) {
            playerJl.setLocation(playerJl.getX() + 15, playerJl.getY());
        }
        if (playerJl.getY() <= 0) {
            playerJl.setLocation(playerJl.getX(), playerJl.getY() + 15);
        }
        if (playerJl.getX() >= 1800) {
            playerJl.setLocation(playerJl.getX() - 15, playerJl.getY());
        }
        if (playerJl.getY() >= 900) {
            playerJl.setLocation(playerJl.getX(), playerJl.getY() - 15);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'a':
                playerJl.setIcon(down1);
                break;
            case 'w':
                playerJl.setIcon(down1);
            case 's':
                playerJl.setIcon(down1);
                break;
            case 'd':
                playerJl.setIcon(down1);
        }
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
    //</editor-fold>

}

