package SurvivalGame;

import javax.swing.*;
import java.awt.*;


public class GameScreen extends JPanel{

    public GameScreen(){

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.red);

        g.fillRect(0,0,32,32);
        g.fillRect(32,0,32,32);
        //https://www.youtube.com/channel/UC1At_c5rKyxH4aWgGPqsRDg
    }

}
