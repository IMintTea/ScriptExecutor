package SurvivalGame;


public class Game {

    public static player currentPlayer;
    public static Game game;
    MyFrame mainFrame = new MyFrame();


    public static void main(String[] args) {
        game = new Game();
    }


    public Game() {
        currentPlayer = new player();
        String filepath = "Main.wav";
        Music musicObject = new Music();
        musicObject.playMusic(filepath);

        InventoryHandler iHandler = new InventoryHandler();

    }

    public player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(player thisPlayer) {
        currentPlayer = thisPlayer;
    }

    public MyFrame getCurrentFrame() {
        return mainFrame;
    }

}