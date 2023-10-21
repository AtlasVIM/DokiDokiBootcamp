package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Textbox {

    private Picture box;

    public Textbox() {
        this.box = new Picture(450, 700, "textbox2.png");
        box.draw();
    }

    public void delete() {
        box.delete();
    }

    public void draw() {
        box.draw();
    }
}
