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
        gameScenario.day2();
        gameScenario.day3();
        gameScenario.day4();
        gameScenario.day5();
    }

}
