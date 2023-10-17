package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Scene {


    private static Picture background;

    public Scene(String s) {
        background = new Picture(10, 10, s);
        background.draw();
    }

    public static Picture getBackground() {
        return background;
    }

    public static void load(String s) {
        background.load(s);
    }

}
