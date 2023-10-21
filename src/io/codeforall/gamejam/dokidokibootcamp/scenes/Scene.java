package io.codeforall.gamejam.dokidokibootcamp.scenes;

import io.codeforall.gamejam.dokidokibootcamp.GameScenario;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Scene {

    LOBBY("cfa_lobby.jpg"),
    METROPOLIS3("cfa_metropolis3.jpg"),
    METROPOLIS2("cfa_metropolis2.jpg"),
    GOTHAM1("cfa_gotham.jpg"),
    GOTHAM2("cfa_gotham2.jpg"),
    SINCITY1("cfa_sincity.jpg"),
    WC("cfa_wc.jpg"),
    HALL("cfa_hall.jpg"),
    BALCONY("cfa_balcony.jpg"),
    BACKROOMS("cfa_backrooms.jpg"),
    COFFEETABLE("cfa_coffee.jpg"),
    CODEBREAK("cfa_codebreak.jpg"),
    CAFETERIA("cfa_cafeteria.jpg");


    private Picture background;
    private String path;

    Scene(String s) {
        background = new Picture(10, 10, s);
        path = s;
    }

    public Picture getBackground() {
        return background;
    }

    public void load() {
        background.load(path);
    }

    public void draw() {
        background.draw();
        GameScenario.setScene(this);
    }

    public void delete() {
        background.delete();
    }

}
