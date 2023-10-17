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

    private void waitForInput() throws InterruptedException {
        Thread.sleep(1000);
        while (!gameStatus) {}
    }

    public void clearText() {
        paragraph4.delete();
        paragraph3.delete();
        paragraph2.delete();
        paragraph1.delete();
    }

    public void nozkdraw() {
        textbox.delete();
        nozk.draw();
        textbox.draw();
    }
    public void mikedraw() {
        textbox.delete();
        mike.draw();
        textbox.draw();
    }

    public void changeName(String s) {
        nameText.delete();
        nameText.setName(s);
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
        day1scenario1();
        day1choice();
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
        waitForInput();
        paragraph1.setDialogue("Today is the first day of your lives as programmers.");
        paragraph2.setDialogue("Isn't it exciting!?");
        waitForInput();
        clearText();
        paragraph1.setDialogue("Are you ready to meet your Master Coders?");
        waitForInput();
        clearText();
        nameText.setName("YOU");
        paragraph1.setDialogue("It was at this time... my heart skipped a beat...");
        waitForInput();
        clearText();
        textbox.delete();
        nozk = new CharacterNozk(new Picture(700, 315, "resources/dude.png"));
        textbox.draw();
        changeName("NOZK");
        paragraph1.setDialogue("HOW'S IT GOING YOU DISGRACES!!!!");
        waitForInput();
        clearText();
        nozk.delete();
        textbox.delete();
        mike = new CharacterMike(new Picture(700, 315, "resources/dude1.png"));
        textbox.draw();
        changeName("MIC");
        paragraph1.setDialogue("What's up lil guys!");
        waitForInput();
    }

    public void day1choice() throws InterruptedException {
        clearText();
        mike.delete();
        changeName("YOU");
        paragraph1.setDialogue("is this sugoi?");
        waitForInput();
        line.getLine().fill();
        paragraph1.setDialogue("Na verdade até prefiro o João Baião.");
        paragraph2.setDialogue("Esbetaculo.");
        waitForInput();
    }


    public void day1bathroom() {
        Scene.load("resources/cfa_wc.jpg");
        clearText();
        nozkdraw();
        changeName("NOZK");
        paragraph1.setDialogue("you fryin chicken in there?");

    }

    public void day1classroom() {
        Scene.load("resources/cfa_metropolis.jpg");
        clearText();
        mikedraw();
        changeName("MIC");
        paragraph1.setDialogue("let me see your booleans");

    }


}
