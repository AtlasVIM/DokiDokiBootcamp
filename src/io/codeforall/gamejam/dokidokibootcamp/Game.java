package io.codeforall.gamejam.dokidokibootcamp;

import io.codeforall.gamejam.dokidokibootcamp.controls.Controls;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterMike;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterNozk;
import io.codeforall.gamejam.dokidokibootcamp.scenes.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    Scene scene;
    GameScenario gameScenario = new GameScenario();

    public Game() {
    }

    public void start() throws InterruptedException {
        Controls controls = new Controls();
        gameScenario.day1();
        //CharacterMike mike = new CharacterMike(new Picture(800, 310, "resources/dude1.png"));
        //CharacterNozk nozk = new CharacterNozk(new Picture(700, 315, "resources/dude.png"));

    }

}
