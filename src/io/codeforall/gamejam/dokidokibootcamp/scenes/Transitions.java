package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public enum Transitions {
    END_OF_DAY ((new Picture (10, 10, "resources/background")), (new Text(300,300, "THE NEXT DAY...", Font.MONOSPACED, Font.PLAIN , 20))),
    END_OF_CLASS((new Picture(10,10,"resources/background")), (new Text(300,300, "AFTER CLASS...", Font.MONOSPACED, Font.PLAIN , 20))),
    END((new Picture(10,10,"resources/cfa_wc")), (new Text(300,300, "THE END", Font.MONOSPACED, Font.PLAIN , 20)));

    private Picture picture;
    private Text message;

    Transitions(Picture picture, Text message){
        this.picture = picture;
        this.picture.draw();
        this.message = message;
        this.message.draw();
    }

    public Picture getPicture(){
        return picture;
    }


    public Text getText(){
        return message;
    }
}

