package io.codeforall.gamejam.dokidokibootcamp.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract class Character {

    Picture picture;

    Character(Picture picture){
        this.picture = picture;
        this.picture.draw();
    }

    public Picture getPicture() {
        return picture;
    }


    public void setPicture(String s) {
        picture.load(s);
        picture.draw();
    }
}


