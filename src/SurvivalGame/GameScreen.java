package SurvivalGame;

import javax.swing.*;
import java.awt.*;


public class GameScreen extends JPanel{

    public GameScreen(){

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.red);

        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 8; y++) {
                g.fillRect(x*20,y*20,20,20);
            }
        }
        for (int x = 0; x < 7; x++) {
            for (int y = 8; y < 21; y++) {
                g.fillRect(x*20,y*20,20,20);
            }
        }
        for (int x = 0; x < 11; x++) {
            for (int y = 8; y < 21; y++) {
                g.fillRect(x*20,y*20,20,20);
            }
        }



        //https://www.youtube.com/channel/UC1At_c5rKyxH4aWgGPqsRDg
    }

}
