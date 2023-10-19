package io.codeforall.gamejam.dokidokibootcamp;

import io.codeforall.gamejam.dokidokibootcamp.controls.Controls;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.Character;
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

    public String dayChoice;
    public String dayReject;
    public Transitions transitions;

    public static volatile boolean gameStatus;

    private void waitForInput() throws InterruptedException {
        Thread.sleep(1000);
        while (!gameStatus) {
        }
    }

    public void clearText() {
        paragraph4.delete();
        paragraph3.delete();
        paragraph2.delete();
        paragraph1.delete();
    }


    public void drawCharacter(Character c) {
        nameText.delete();
        textbox.delete();
        c.draw();
        textbox.draw();
        nameText.draw();
    }

    public void changeName(String s) {
        nameText.delete();
        nameText.setName(s);
    }



/*
=== DAY 1 ===
 */

    public void day1() throws InterruptedException {
        day1setup();
        day1scenario1();
        day1choice();
        day1chooseDialogue();
        transitions = Transitions.END_OF_CLASS;
        transitions.getPicture();
        waitForInput();

    }

    public void day1setup() { //
        line = new ChoiceLine();
        this.scene = new Scene("resources/codeforall_lobby.jpg");
        this.textbox = new Textbox();
        this.paragraph1 = new Dialogue(480, 770, "Good Morning everyone");
        this.paragraph2 = new Dialogue(480, 810, "");
        this.paragraph3 = new Dialogue(480, 850, "");
        this.paragraph4 = new Dialogue(480, 890, "");
        this.nameText = new NameText("Catarina Campino");
    }

    public void day1scenario1() throws InterruptedException {
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
        clearText();
    }

    public void day1choice() throws InterruptedException {
        clearText();
        changeName("YOU");
        paragraph1.setDialogue("Mic is so cool and mysterious...");
        waitForInput();
        clearText();

        mike.delete();
        drawCharacter(nozk);
        paragraph1.setDialogue("And Nozk is such a goofball...");
        waitForInput();
        clearText();

        nozk.delete();
        paragraph1.setDialogue("They are both so sugoi....");
        paragraph2.setDialogue("What should I do..?");
        waitForInput();
        line.fill();
        paragraph1.setDialogue("Talk to Mic.");
        paragraph2.setDialogue("Talk to Nozk.");
        waitForInput();
    }

    public void day1chooseDialogue() throws InterruptedException {
        switch (Controls.getDialogue()) {
            case 0:
                clearText();
                line.delete();
                day1classroom();
                dayChoice = "Mic";
                dayReject = "Nozk";
                mike.addLoveLevel();
                break;
            case 1:
                clearText();
                line.delete();
                day1bathroom();
                dayChoice = "Nozk";
                dayReject = "Mic";
                nozk.addLoveLevel();
                break;
            default:
                break;
        }
    }

    public void dayInteraction() throws InterruptedException {
        switch (Controls.getDialogue()) {
            case 0:
                paragraph1.setDialogue("YES!! I think, you and I can still get along.");
                waitForInput();
                clearText();
                break;
            case 1:
                paragraph1.setDialogue("Oh... Nevermind then...");
                waitForInput();
                clearText();
                break;
            default:
                break;
        }
    }


    public void day1bathroom() throws InterruptedException {
        Scene.load("resources/cfa_metropolis.jpg");
        clearText();

        drawCharacter(nozk);
        changeName("NOZK");
        paragraph1.setDialogue("Hello cadet! So glad to meet you");
        waitForInput();

        paragraph1.setDialogue("Do you wanna see a magic trick?");
        waitForInput();
        clearText();

        changeName("YOU");
        paragraph1.setDialogue("Magic? Sure!");
        paragraph2.setDialogue("I'm not a big fan of magic tricks.");
        line.fill();

        waitForInput();
        clearText();
        line.delete();


    }

    public void day1classroom() throws InterruptedException {
        Scene.load("resources/cfa_metropolis.jpg");
        clearText();

        drawCharacter(mike);
        changeName("MIC");
        paragraph1.setDialogue("What's up cadet? My name's MicDrop");
        waitForInput();

        paragraph1.setDialogue("Do you like hip-hop?");

        waitForInput();
        clearText();

        changeName("YOU");
        paragraph1.setDialogue("Hell yeah!");
        paragraph2.setDialogue("Nah, not a big fan...");
        line.fill();

        waitForInput();
        clearText();
        line.delete();

        paragraph1.setDialogue("Mic turns on the classroom speakers"); //POR MINISAR A DAR AQUI

        waitForInput();

        paragraph1.setDialogue("A symphony written by Apollo himself enters my ears.");
        paragraph2.setDialogue("I had never heard such a beautiful sound in my life before.");
        waitForInput();
        clearText();
        mike.delete();

    }
    /*
    === DAY 1 END ===

    insert transition!!!!!!!!!!
     */


    public void day2() throws InterruptedException {
        day2scenario1();
        //day2choice();
        //day2chooseDialogue();
    }


    public void day2scenario1() throws InterruptedException {
        Scene.load("resources/codeforall_lobby.jpg");
        paragraph1.setDialogue("Last night with " + dayChoice + " was amazing...");
        transitions.deleteTransition();
        waitForInput();
        clearText();

        paragraph1.setDialogue("I've never felt so connected with anyone before");
        waitForInput();
        clearText();

        paragraph1.setDialogue("Suddenly, I feel a throbbing touch on my shoulder.");
        waitForInput();
        clearText();

        nameText.setName(dayReject);
        if (dayReject.equals("Nozk")) {
            drawCharacter(nozk);

        } else {
            drawCharacter(mike);
        }
        paragraph1.setDialogue("Hey... I didn't see you yesterday...");
        paragraph2.setDialogue("Is everything alright?");
        waitForInput();
        clearText();

        changeName("YOU");
        paragraph1.setDialogue("Before I could respond, " + dayReject + " passionately interrupted me.");
        waitForInput();
        clearText();

        if (dayReject.equals("Nozk")) {
            changeName("NOZK");
            paragraph1.setDialogue("Do you know the colour of my soul?!");
            waitForInput();
            clearText();

            changeName("YOU");  // É preciso resolver o mau posicionamento da linha
            paragraph1.setDialogue("It's definetely pink!");
            paragraph2.setDialogue("Hmm... Black, I suppose?");
            line.delete();
            line.fill();
            waitForInput();
            clearText();
            line.delete();

            textbox.draw();
            changeName("NOZK");

        } else {
            changeName("MIC");
            paragraph1.setDialogue("So... Have you ever watched One Piece?");
            waitForInput();
            clearText();

            changeName("YOU"); // É preciso resolver o mau posicionamento da linha
            paragraph1.setDialogue("OMG YES, I LOVE IT!");
            paragraph2.setDialogue("One piece... of what, exactly?");
            line.delete();
            line.fill();
            waitForInput();
            clearText();
            line.delete();

            textbox.draw();
            changeName("MIC");
        }
        dayInteraction();

        /** transition end of classes! */

        changeName("YOU");
        paragraph1.setDialogue("");


        //sou eu a falar e escolho com quem vou estudar
        //o dia seguinte começa no cenário da pessoa que se escolheu estudar
        //no final do dia repensa-se

    }
/*
    public void day2choice(){ //throws InterruptedException {
        clearText();
        changeName("YOU");
        paragraph1.setDialogue("Mic is so cool and mysterious...");
        waitForInput();
        clearText();

        mike.delete();
        drawCharacter(nozk);
        paragraph1.setDialogue("And Nozk is such a goofball...");
        waitForInput();
        clearText();

        nozk.delete();
        paragraph1.setDialogue("They are both so sugoi....");
        paragraph2.setDialogue("What should I do..?");
        waitForInput();
        line.fill();
        paragraph1.setDialogue("Talk to Mic.");
        paragraph2.setDialogue("Talk to Nozk.");
        waitForInput();
    }
    public void day2chooseDialogue() throws InterruptedException {
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


    public void day2bathroom() throws InterruptedException {
        Scene.load("resources/cfa_metropolis.jpg");
        clearText();

        drawCharacter(nozk);
        changeName("NOZK");
        paragraph1.setDialogue("Hello cadet! So glad to meet you");
        waitForInput();

        paragraph1.setDialogue("Do you wanna see a magic trick?");
        waitForInput();
        clearText();

        changeName("YOU");
        paragraph1.setDialogue("Magic? Sure!");
        paragraph2.setDialogue("I'm not a big fan of magic tricks.");
        line.fill();


    }

    public void day2classroom() throws InterruptedException {
        Scene.load("resources/cfa_metropolis.jpg");
        clearText();

        drawCharacter(mike);
        changeName("MIC");
        paragraph1.setDialogue("What's up cadet? My name's MicDrop");
        waitForInput();

        paragraph1.setDialogue("Do you like hip-hop?");

        waitForInput();
        clearText();

        changeName("YOU");
        paragraph1.setDialogue("Hell yeah!");
        paragraph2.setDialogue("Nah, not a big fan...");
        line.fill();

        waitForInput();
        clearText();
        line.delete();

        paragraph1.setDialogue("Mic turns on the classroom speakers"); //POR MINISAR A DAR AQUI

        waitForInput();

        paragraph1.setDialogue("A symphony written by Apollo himself enters my ears.");
        paragraph2.setDialogue("I had never heard such a beautiful sound in my life before.");

    }




*/

}









