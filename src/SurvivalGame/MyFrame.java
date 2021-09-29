package SurvivalGame;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener{

    //<editor-fold desc="Get Screen Size">
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());
    // Home screen: 1920, 1080 School screen: 1920, 1080
    //</editor-fold>

    JLabel shrek;
    JProgressBar healthBar;
    ImageIcon icon, map, menu, youDied;
    JPanel inventoryPanel, healthBarPanel;
    public static JToggleButton inventoryButton;
    JButton damage, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;

    InventoryHandler iHandler = new InventoryHandler();


    MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(xSize,ySize);
        this.setLayout(null);
        this.addKeyListener(this);


        //<editor-fold desc="Death">

        youDied = new ImageIcon("YouDied.png");
        JLabel death = new JLabel();
        death.setSize(xSize,ySize);
        death.setIcon(youDied);
        this.add(death);
        death.setVisible(false);
        //</editor-fold>

        //<editor-fold desc="Health Bar">
        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(250,250,300,30);
        healthBarPanel.setLocation(0,700);
        healthBarPanel.setBackground(Color.blue);
        this.add(healthBarPanel);

        healthBar = new JProgressBar(0,100);
        healthBar.setPreferredSize(new Dimension(300,30));
        healthBar.setValue(Game.getCurrentPlayer().playerHp);
        healthBarPanel.add(healthBar);
        //</editor-fold>

        //<editor-fold desc="Damage Button">
        damage = new JButton("That's a lot of damage");
        damage.setForeground(white);
        damage.setBackground(black);
        damage.setSize(200, 50);
        damage.setLocation(50, 800);
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
            this.revalidate();

        }
        //</editor-fold>

        //<editor-fold desc="Inventory Button">
        inventoryButton = new JToggleButton("Inventory");
        inventoryButton.setBackground(black);
        inventoryButton.setForeground(white);
        inventoryButton.setSize(200, 50);
        inventoryButton.setLocation(50, 750);
        inventoryButton.setVisible(true);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(iHandler);




        inventoryButton.setActionCommand("inventoryButton");
        this.add(inventoryButton);
        //</editor-fold>

        //<editor-fold desc="Inventory Contents">
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
        itemButton1.setText((Game.currentPlayer.getPlayerItems()[0].getName()));
        itemButton2 = new JButton();
        itemButton2.setBackground(black);
        itemButton2.setForeground(white);
        itemButton2.setFocusPainted(false);
        itemButton2.addActionListener(iHandler);
        itemButton2.setActionCommand("item2");
        itemButton1.setText((Game.currentPlayer.getPlayerItems()[1].getName()));
        itemButton3 = new JButton();
        itemButton3.setBackground(black);
        itemButton3.setForeground(white);
        itemButton3.setFocusPainted(false);
        itemButton3.addActionListener(iHandler);
        itemButton3.setActionCommand("item3");
        itemButton1.setText((Game.currentPlayer.getPlayerItems()[2].getName()));
        itemButton4 = new JButton();
        itemButton4.setBackground(black);
        itemButton4.setForeground(white);
        itemButton4.setFocusPainted(false);
        itemButton4.addActionListener(iHandler);
        itemButton4.setActionCommand("item4");
        itemButton1.setText((Game.currentPlayer.getPlayerItems()[3].getName()));
        itemButton5 = new JButton();
        itemButton5.setBackground(black);
        itemButton5.setForeground(white);
        itemButton5.setFocusPainted(false);
        itemButton5.addActionListener(iHandler);
        itemButton5.setActionCommand("item5");
        itemButton1.setText((Game.currentPlayer.getPlayerItems()[4].getName()));

        inventoryPanel.add(itemButton1);
        inventoryPanel.add(itemButton2);
        inventoryPanel.add(itemButton3);
        inventoryPanel.add(itemButton4);
        inventoryPanel.add(itemButton5);

        inventoryPanel.setVisible(false);
        //</editor-fold>

        //<editor-fold desc="Main Menu">
        menu = new ImageIcon("MainMenuPicture.png");
        JLabel jl1= new JLabel();
        jl1.setSize(xSize,ySize);
        jl1.setIcon(menu);
        //this.add(jl1);
        //</editor-fold>

        //<editor-fold desc="Player Model">
        icon = new ImageIcon("Shrek.png");
        shrek = new JLabel();
        shrek.setBounds(0, 0, 200, 200);
        shrek.setIcon(icon);
        this.add(shrek);
        //</editor-fold>

        //<editor-fold desc="Map">
        map = new ImageIcon("Map1.png");
        JLabel jl = new JLabel();
        jl.setSize(xSize,ySize);
        jl.setIcon(map);
        this.add(jl);
        //</editor-fold>

        this.setVisible(true);
    }
    public void revalidate(){
        this.repaint();
        this.revalidate();
    }

    //<editor-fold desc="Player Movement">
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
    //</editor-fold>
}

