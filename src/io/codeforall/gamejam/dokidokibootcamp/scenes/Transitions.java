package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Transitions {
    END_OF_DAY (new Picture (10, 10, "nextdayuwu.jpg")),
    MAINSCREEN (new Picture(10,10,"mainscreen.jpg")),
    END_OF_CLASS(new Picture(10,10, "littlelater.png")),
    CODEBREAK(new Picture(10,10,"transition_codebreak.jpg")),
    TOGETHEREND(new Picture(10,10,"endingTogether.jpg")),
    MICEND(new Picture(10,10,"endingMike.png")),
    NOZKEND(new Picture(10,10,"endingNozk.jpg"));

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

