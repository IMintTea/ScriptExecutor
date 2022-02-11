package SurvivalGame;


import Launcher.SignIn;
import Launcher.SignUp;

public class Game {

    public static Player currentPlayer;


    public static void main(String[] args) {

        currentPlayer = new Player();
        String filepath = "Music/Main.wav";
        Music musicObject = new Music();
        musicObject.playMusic(filepath);

        SignIn LauncherSignIn = new SignIn();



    }




    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player thisPlayer) {
        currentPlayer = thisPlayer;
    }

    public static MyFrame getCurrentFrame() {
        return new MyFrame();
        //issue could be in the show inventory code.
    }

}