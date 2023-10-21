package io.codeforall.gamejam.dokidokibootcamp.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Sprites {
    MIKEHAPPY("happyMike.png"),
    MIKESAD("mikeSad.png"),
    MIKESURPRISED("mikeSurprised.png"),
    MIKEANGRY("mikeMad.png"),
    NOZKHAPPY("nozkHappy.png"),
    NOZKSAD ("nozkSad.png"),
    NOZKSURPRISED ("nozkSurprised.png"),
    MIKEHORNY("mikeHorny.png"),
    NOZKANGRY ("nozkMad.png"),
    NOZKTRICK1 ("nozkTrick1.png"),
    NOZKTRICK2 ("nozkTrick2.png"),
    NOZKTRICK3("nozkTrick3.png"),
    NOZKHORNY("nozkHorny.png");

    private Picture sprite;
    private String path;
    Sprites(String s) {
        sprite = new Picture(500,100,s);
        this.path = s;
    }

    public Picture getSprite() {
        return sprite;
    }
    public String getExpression() {
        return path;
    }
}
