package SurvivalGame;

public class Player {

    int playerHp;
    public static String inventoryStatus;
    SuperItem[] playerItem = new SuperItem[5];
    Item_HealingPotion healingPotion = new Item_HealingPotion();
    Item_Poison poison = new Item_Poison();
    Item_Empty empty = new Item_Empty();


    Player(){
        playerHp = 50;

        inventoryStatus = "close";

        playerItem[0] = healingPotion;
        playerItem[1] = poison;
        playerItem[2] = empty;
        playerItem[3] = empty;
        playerItem[4] = empty;
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

    }

    public SuperItem[] getPlayerItems() {
        return playerItem;
    }

}
