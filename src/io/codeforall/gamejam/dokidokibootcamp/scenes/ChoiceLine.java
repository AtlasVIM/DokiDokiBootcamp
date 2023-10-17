package io.codeforall.gamejam.dokidokibootcamp.scenes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ChoiceLine {

    private Rectangle line;

    public ChoiceLine() {
        this.line = new org.academiadecodigo.simplegraphics.graphics.Rectangle(480, 790, 100, 10);
        line.setColor(Color.BLACK);
       // line.fill();

    }

    public void delete() {
        line.delete();
    }

    public Rectangle getLine() {
        return line;
    }

    public void fill() {
        line.fill();
    }


    public void moveUp() {
        line.translate(0, -40);
    }

    public void moveDown() {
        line.translate(0, 40);
    }
}
