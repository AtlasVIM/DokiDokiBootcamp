package io.codeforall.gamejam.dokidokibootcamp.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Sprites {
    MIKEHAPPY("happyMike.png"),
    MIKESAD("mikeSad.png"),
    MIKESURPRISED("mikeSurprised.png"),
    MIKEANGRY("mikeMad.png"),
    NOZKHAPPY("nozkHappy.png");

    private Picture sprite;
    Sprites(String s) {
        sprite = new Picture(500,100,s);
    }

    public Picture getSprite() {
        return sprite;
    }
}
