package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.awt.*;

public class Dialogue {

    Text dialogue;

    public Dialogue(String message) {
        Text text = new Text(300, 700, message, Font.MONOSPACED, Font.ITALIC, 50);
        text.setColor(Color.BLACK);
        text.draw();

    }


    /*public static String SlowPrint(String s) {
        for (int i=0; i<s.length();i++) {
            char c = s.charAt(i);



        }
    } */

}
