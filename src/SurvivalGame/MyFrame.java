package SurvivalGame;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;



public class MyFrame extends JFrame implements KeyListener{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());
    // Home screen: 1920, 1080
    // School screen: 1920, 1080

    JLabel shrek;
    ImageIcon icon;
    ImageIcon map;
    ImageIcon menu;
    JButton inventoryButton, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
    JPanel inventoryPanel, healthBarPanel;
    String inventoryStatus;
    int playerHp;
    JProgressBar healthBar;

    InventoryHandler iHandler = new InventoryHandler();

    SuperItem[] playerItem = new SuperItem[5];
    Item_HealingPotion healingPotion = new Item_HealingPotion();
    Item_Poison poison = new Item_Poison();
    Item_Empty empty = new Item_Empty();

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(xSize,ySize);
        this.setLayout(null);
        this.addKeyListener(this);

        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(250,250,300,30);
        healthBarPanel.setBackground(Color.blue);
        this.add(healthBarPanel);

        healthBar = new JProgressBar(0,100);
        healthBar.setPreferredSize(new Dimension(300,30));
        healthBar.setValue(playerHp);
        healthBarPanel.add(healthBar);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(black);
        inventoryButton.setForeground(white);
        inventoryButton.setSize(200, 50);
        inventoryButton.setLocation(850, 900);
        inventoryButton.setVisible(true);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(iHandler);
        inventoryButton.setActionCommand("inventoryButton");
        this.add(inventoryButton);


        inventoryPanel = new JPanel();
        inventoryPanel.setBackground(black);
        inventoryPanel.setForeground(black);
        inventoryPanel.setBounds(650, 200, 600, 600);
        inventoryPanel.setLayout(new GridLayout(5,1));
        this.add(inventoryPanel);

        itemButton1 = new JButton();
        itemButton1.setBackground(black);
        itemButton1.setForeground(white);
        itemButton1.setFocusPainted(false);
        itemButton1.addActionListener(iHandler);
        itemButton1.setActionCommand("item1");
        itemButton2 = new JButton();
        itemButton2.setBackground(black);
        itemButton2.setForeground(white);
        itemButton2.setFocusPainted(false);
        itemButton2.addActionListener(iHandler);
        itemButton2.setActionCommand("item1");
        itemButton3 = new JButton();
        itemButton3.setBackground(black);
        itemButton3.setForeground(white);
        itemButton3.setFocusPainted(false);
        itemButton3.addActionListener(iHandler);
        itemButton3.setActionCommand("item1");
        itemButton4 = new JButton();
        itemButton4.setBackground(black);
        itemButton4.setForeground(white);
        itemButton4.setFocusPainted(false);
        itemButton4.addActionListener(iHandler);
        itemButton4.setActionCommand("item1");
        itemButton5 = new JButton();
        itemButton5.setBackground(black);
        itemButton5.setForeground(white);
        itemButton5.setFocusPainted(false);
        itemButton5.addActionListener(iHandler);
        itemButton5.setActionCommand("item1");

        inventoryPanel.add(itemButton1);
        inventoryPanel.add(itemButton2);
        inventoryPanel.add(itemButton3);
        inventoryPanel.add(itemButton4);
        inventoryPanel.add(itemButton5);

        inventoryPanel.setVisible(true);

        menu = new ImageIcon("MainMenuPicture.png");

        JLabel jl1= new JLabel();
        jl1.setSize(xSize,ySize);
        jl1.setIcon(menu);
        //this.add(jl1);

        map = new ImageIcon("Map1.png");

        JLabel jl = new JLabel();
        jl.setSize(xSize,ySize);
        jl.setIcon(map);


        icon = new ImageIcon("Shrek.png");

        shrek = new JLabel();
        shrek.setBounds(0, 0, 200, 200);
        shrek.setIcon(icon);

        Color myBackgroundColor = new Color(31, 143, 43);

        this.getContentPane().setBackground(myBackgroundColor);

        this.add(shrek);
        this.add(jl);
        this.setVisible(true);
    }

    public void playerSetup(){
        playerHp = 50;

        inventoryStatus = "close";

        playerItem[0] = healingPotion;
        playerItem[1] = poison;
        playerItem[2] = empty;
        playerItem[3] = empty;
        playerItem[4] = empty;
    }

    public void itemUsed(int slotNumber){

        playerHp = playerHp + playerItem[slotNumber].healingValue;

        playerItem[slotNumber] = empty;
        itemButton1.setText(playerItem[0].name);
        itemButton2.setText(playerItem[1].name);
        itemButton3.setText(playerItem[2].name);
        itemButton4.setText(playerItem[3].name);
        itemButton5.setText(playerItem[4].name);

    }

    @Override
    public void keyTyped(KeyEvent e) {

        switch(e.getKeyChar()) {
            case 'a': shrek.setLocation(shrek.getX()-15, shrek.getY());
                break;
            case 'w': shrek.setLocation(shrek.getX(), shrek.getY()-15);
                break;
            case 's': shrek.setLocation(shrek.getX(), shrek.getY()+15);
                break;
            case 'd': shrek.setLocation(shrek.getX()+15, shrek.getY());
                break;

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()) {
            case 37: shrek.setLocation(shrek.getX()-15, shrek.getY());
                break;
            case 38: shrek.setLocation(shrek.getX(), shrek.getY()-15);
                break;
            case 39: shrek.setLocation(shrek.getX()+15, shrek.getY());
                break;
            case 40: shrek.setLocation(shrek.getX(), shrek.getY()+15);
                break;
        }

        if(shrek.getX()== 0){
            shrek.setLocation(shrek.getX()+15, shrek.getY());
        }
        if(shrek.getY()== 0){
            shrek.setLocation(shrek.getX(), shrek.getY()+15);
        }
        if(shrek.getX()== 1920){
            shrek.setLocation(shrek.getX()-15, shrek.getY());
        }
        if(shrek.getY()== 1080){
            shrek.setLocation(shrek.getX(), shrek.getY()-15);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
}

