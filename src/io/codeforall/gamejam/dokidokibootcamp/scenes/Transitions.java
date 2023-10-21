package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Transitions {
    END_OF_DAY (new Picture (10, 10, "nextdayuwu.jpg")),
    END_OF_CLASS(new Picture(10,10, "littlelater.png"));

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

