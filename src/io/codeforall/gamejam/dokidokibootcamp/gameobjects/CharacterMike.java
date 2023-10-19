package io.codeforall.gamejam.dokidokibootcamp.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CharacterMike extends Character{

    Picture sprite = new Picture();

    public CharacterMike(Picture picture) {
        super(picture);
    }

    @Override
    public String toString() {
        return "MIC";
    }
}
