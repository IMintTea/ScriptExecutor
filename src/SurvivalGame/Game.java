package SurvivalGame;


public class Game {

    public static Player currentPlayer;


    public static void main(String[] args) {

        currentPlayer = new Player();
        String filepath = "Main.wav";
        Music musicObject = new Music();
        musicObject.playMusic(filepath);
        InventoryHandler iHandler = new InventoryHandler();


        MyFrame frame = new MyFrame();
        new MyFrame();

    }




    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player thisPlayer) {
        currentPlayer = thisPlayer;
    }

    public static MyFrame getCurrentFrame() {
        return new MyFrame();
    }



}