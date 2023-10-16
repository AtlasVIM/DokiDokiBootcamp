package io.codeforall.gamejam.dokidokibootcamp;

import io.codeforall.gamejam.dokidokibootcamp.controls.Controls;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterMike;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterNozk;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import io.codeforall.gamejam.dokidokibootcamp.scenes.Dialogue;
import io.codeforall.gamejam.dokidokibootcamp.scenes.Scene;
import io.codeforall.gamejam.dokidokibootcamp.scenes.Textbox;

public class Game {
    Scene scene;

    public Game(){
    }

    public void start(){
        Controls controls = new Controls();
        scene = new Scene();
        CharacterMike mike = new CharacterMike(new Picture(800, 310, "resources/dude1.png"));
        CharacterNozk nozk = new CharacterNozk(new Picture(300,315,"resources/dude.png"));
        Textbox textbox = new Textbox();
        Dialogue dialogue = new Dialogue("mekie desgraçados");

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
