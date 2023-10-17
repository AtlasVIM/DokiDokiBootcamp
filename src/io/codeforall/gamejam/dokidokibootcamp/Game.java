package io.codeforall.gamejam.dokidokibootcamp;

import io.codeforall.gamejam.dokidokibootcamp.controls.Controls;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterMike;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterNozk;
import io.codeforall.gamejam.dokidokibootcamp.scenes.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    Scene scene;
    public ChoiceLine line;

    public Game() {
    }

    public void start() {
        scene = new Scene();
        CharacterMike mike = new CharacterMike(new Picture(800, 310, "resources/dude1.png"));
        CharacterNozk nozk = new CharacterNozk(new Picture(700, 315, "resources/dude.png"));
        Textbox textbox = new Textbox();
        Dialogue dialogue = new Dialogue("mekie desgraçados");
        NameText name = new NameText("NOZK");
        line = new ChoiceLine();
        Controls controls = new Controls(line);

    }

    public static void chooseDialogue() {
        switch (Controls.getDialogue()) {
            case 0:
                Scene.getBackground().load("resources/cfa_metropolis.jpg");
                break;
            case 1:
                Scene.getBackground().load("resources/cfa_wc.jpg");
                break;
            default:
                break;
        }
    }
}
