package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Scene {


    private static Picture background;

    public Scene(){
        this.background = new Picture(10,10, "resources/codeforall_lobby.jpg");
        background.draw();
        System.out.println(background.getMaxX());
        System.out.println(background.getMaxY());
    }

    public static Picture getBackground() {
        return background;
    }

    public void setBackground(String s) {
        this.background.load(s);
    }
}
