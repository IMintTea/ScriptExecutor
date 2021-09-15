package SurvivalGame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryHandler implements ActionListener{

    player currentPlayer;

    public void actionPreformed(ActionEvent event){

    currentPlayer = Game.game.getCurrentPlayer();

         String yourChoice = event.getActionCommand();

         switch(yourChoice){
             case "inventoryButton":
                 if(currentPlayer.inventoryStatus.equals("close")) {

                     Game.game.getCurrentFrame().inventoryPanel.setVisible(true);

                     currentPlayer.inventoryStatus = "Open";
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

