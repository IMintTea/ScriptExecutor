package SurvivalGame;


public class Main{


    public static void main(String[] args) {

        new MyFrame();

        String filepath = "Main.wav";

        Music musicObject = new Music();
        musicObject.playMusic(filepath);


    }

}