package io.codeforall.gamejam.dokidokibootcamp.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character {

    private int loveLevel = 0;

    protected Picture picture;

    Character(Picture picture) {
        this.picture = picture;
        this.picture.draw();
    }

    public Picture getPicture() {
        return picture;
    }

    public int getLoveLevel() {
        return loveLevel;
    }

    public void addLoveLevel() {
        loveLevel++;
    }

    public void subLoveLevel() {
        loveLevel--;
    }

    public void setPicture(String s) {
        picture.load(s);
        picture.draw();
    }

    public void draw() {
        picture.draw();
    }
    public void delete() {
        picture.delete();
    }

}


