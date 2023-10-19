package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public enum Transitions {
    END_OF_DAY (new Picture (10, 10, "resources/nextdayuwu.jpg")),
    END_OF_CLASS(new Picture(10,10,"resources/nextdayuwu.jpg")),
    END(new Picture(10,10,"resources/nextdayuwu.jpg"));

    private Picture picture;

    Transitions(Picture picture){
        this.picture = picture;
    }

    public void getPicture(){
        this.picture.draw();
    }


    public void deleteTransition(){
        picture.delete();
    }
}

