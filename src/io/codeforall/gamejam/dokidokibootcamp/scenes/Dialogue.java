package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.awt.*;

public class Dialogue {

    Text text;

    public Dialogue(int x, int y, String message) {
        this.text = new Text(x, y, message, Font.MONOSPACED, Font.PLAIN , 20);
        text.setColor(Color.BLACK);
        text.draw();

    }

    public Text getText() {
        return text;
    }

    public void setDialogue(String s) {
        text.setText(s);
        text.draw();
    }

    public void delete() {
        text.delete();
    }




    /*public static String SlowPrint(String s) {
        for (int i=0; i<s.length();i++) {
            char c = s.charAt(i);



        }
    } */

}
