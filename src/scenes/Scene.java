package scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Scene {


    private Picture background;

    public Scene(){
        this.background = new Picture(10,10, "resources/codeforall_lobby.jpg");
        background.draw();
        System.out.println(background.getMaxX());
        System.out.println(background.getMaxY());
    }
}
