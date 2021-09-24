package SurvivalGame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryHandler implements ActionListener{

    Player currentPlayer;


    @Override
    public void actionPerformed(ActionEvent e) {
        currentPlayer = Game.currentPlayer;


        String yourChoice = e.getActionCommand();

        switch(yourChoice){
            case "inventoryButton":
                if(currentPlayer.inventoryStatus.equals("close")) {

                    Game.getCurrentFrame().inventoryPanel.setVisible(true);

                    currentPlayer.inventoryStatus = "Open";

                }else if(currentPlayer.inventoryStatus.equals("open")){

                    Game.getCurrentFrame().inventoryPanel.setVisible(false);

                    currentPlayer.inventoryStatus = "close";
            }


                break;
            case "item1":
                currentPlayer.itemUsed(0);
                break;
            case "item2":
                currentPlayer.itemUsed(1);
                break;
            case"item3":
                currentPlayer.itemUsed(2);
                break;
            case "item4":
                currentPlayer.itemUsed(3);
                break;
            case "item5":
                currentPlayer.itemUsed(4);
                break;}

    }

}

