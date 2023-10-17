package io.codeforall.gamejam.dokidokibootcamp;

import io.codeforall.gamejam.dokidokibootcamp.controls.Controls;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterMike;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterNozk;
import io.codeforall.gamejam.dokidokibootcamp.scenes.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameScenario {


    public GameScenario() {
    }

    private Scene scene;
    private Textbox textbox;
    private Dialogue paragraph1;
    private Dialogue paragraph2;
    private Dialogue paragraph3;
    private Dialogue paragraph4;
    private NameText nameText;

    public static ChoiceLine line;

    private CharacterMike mike;
    private CharacterNozk nozk;

    public static volatile boolean gameStatus;

    private void waitForInput() {
        while (!gameStatus) {}
    }

    public void clearText() {
        paragraph4.delete();
        paragraph3.delete();
        paragraph2.delete();
        paragraph1.delete();
    }
    public void day1chooseDialogue() {
        switch (Controls.getDialogue()) {
            case 0:
                clearText();
                line.delete();
                day1classroom();
                break;
            case 1:
                clearText();
                line.delete();
                day1bathroom();
                break;
            default:
                break;
        }
    }

    public void day1() throws InterruptedException {
        day1setup();
        waitForInput();
        day1scenario1();
        waitForInput();
        day1choice();
        waitForInput();
        day1chooseDialogue();
    }


    public void day1setup() { //
        line = new ChoiceLine();
        this.scene = new Scene("resources/codeforall_lobby.jpg");
        this.textbox = new Textbox();
        this.paragraph1 = new Dialogue(480,770,"Good Morning everyone");
        this.paragraph2 = new Dialogue(480, 810, "");
        this.paragraph3 = new Dialogue(480,850, "");
        this.paragraph4 = new Dialogue(480, 890, "");
        this.nameText = new NameText("Catarina Campino");
    }

    public  void day1scenario1() throws InterruptedException {
        paragraph1.setDialogue("Welcome to the <Code4All_> fullstack developer bootcamp!");
        Thread.sleep(1000);
        waitForInput();
        paragraph1.setDialogue("desu ne");
        paragraph2.setDialogue("muita fixe");
        paragraph3.setDialogue("lol");
        paragraph4.setDialogue("pila");
        Thread.sleep(1000);
        waitForInput();
    }

    public void day1choice() throws InterruptedException {
        nameText.getName().delete();
        clearText();
        paragraph1.setDialogue("is this sugoi?");
        Thread.sleep(1000);
        waitForInput();
        line.getLine().fill();
        paragraph1.setDialogue("Na verdade até prefiro o João Baião.");
        paragraph2.setDialogue("Esbetaculo.");
        Thread.sleep(1000);
        waitForInput();
    }


    public void day1bathroom() {
        Scene.load("resources/cfa_wc.jpg");
        textbox.delete();
        nozk = new CharacterNozk(new Picture(700, 315, "resources/dude.png"));
        textbox.draw();
        nameText.setName("NOZK");
        paragraph1.setDialogue("you fryin chicken in there?");

    }

    public void day1classroom() {
        Scene.load("resources/cfa_metropolis.jpg");
        textbox.delete();
        mike = new CharacterMike(new Picture(700,315,"resources/dude1.png"));
        textbox.draw();
        nameText.setName("MIC");
        paragraph1.setDialogue("let me see your booleans");

    }


}
