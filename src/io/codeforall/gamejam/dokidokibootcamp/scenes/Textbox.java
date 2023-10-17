package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Textbox {

    private Picture box;

    public Textbox() {
        this.box = new Picture(450, 700, "resources/textbox2.png");
        box.draw();
    }
}
