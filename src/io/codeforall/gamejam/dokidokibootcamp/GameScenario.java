package io.codeforall.gamejam.dokidokibootcamp;

import io.codeforall.gamejam.dokidokibootcamp.controls.Controls;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.Character;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterMike;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.CharacterNozk;
import io.codeforall.gamejam.dokidokibootcamp.gameobjects.Sprites;
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
        clearText();
    }

    public void clearText() {
        paragraph4.delete();
        paragraph3.delete();
        paragraph2.delete();
        paragraph1.delete();
    }


    public void drawCharacter(Character c, Sprites s) {
        nameText.delete();
        textbox.delete();
        c.setPicture(s.getExpression());
        c.draw();
        textbox.draw();
        nameText.draw();
    }

    public void clearCharacters() {
        nozk.delete();
        mike.delete();
    }

    public void changeName(String s) {
        nameText.delete();
        nameText.setName(s);
    }

    public void resetExpressions() {
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        mike.setPicture(Sprites.MIKEHAPPY.getExpression());
    }



/*
=== DAY 1 ===
 */

    public void day1() throws InterruptedException {
        day1setup();
        day1scenario1();
        day1choice();
        day1chooseDialogue();
        transitions = Transitions.END_OF_DAY;
        transitions.getPicture();
        waitForInput();

    }

    public void day1setup() { //
        line = new ChoiceLine();
        this.scene = new Scene("codeforall_lobby.jpg");
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
        paragraph1.setDialogue("Are you ready to meet your Master Coders?");
        waitForInput();
        nameText.setName("YOU");
        paragraph1.setDialogue("It was at this time... my heart skipped a beat...");
        waitForInput();
        nameText.delete();
        textbox.delete();
        nozk = new CharacterNozk(Sprites.NOZKHAPPY.getSprite());
        textbox.draw();
        nameText.draw();
        changeName("NOZK");
        paragraph1.setDialogue("HOW'S IT GOING YOU DISGRACES!!!!");
        waitForInput();
        nameText.delete();
        nozk.delete();
        textbox.delete();
        mike = new CharacterMike(Sprites.MIKEHAPPY.getSprite());
        textbox.draw();
        nameText.draw();
        changeName("MIC");
        paragraph1.setDialogue("What's up lil guys!");
        waitForInput();
    }

    public void day1choice() throws InterruptedException {
        changeName("YOU");
        paragraph1.setDialogue("Mic is so cool and mysterious...");
        waitForInput();

        mike.delete();
        drawCharacter(nozk, Sprites.NOZKHAPPY);
        paragraph1.setDialogue("And Nozk is such a goofball...");
        waitForInput();

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
                day1mic();
                dayChoice = "Mic";
                dayReject = "Nozk";
                break;
            case 1:
                clearText();
                line.delete();
                day1nozk();
                dayChoice = "Nozk";
                dayReject = "Mic";
                break;
            default:
                break;
        }
    }


    public void day1nozk() throws InterruptedException {
        Scene.load("cfa_metropolis.jpg");
        clearText();

        drawCharacter(nozk, Sprites.NOZKHAPPY);
        changeName("NOZK");
        paragraph1.setDialogue("Hello cadet! So glad to meet you");
        waitForInput();

        paragraph1.setDialogue("Do you wanna see a magic trick?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Magic? Sure!");
        paragraph2.setDialogue("I'm not a big fan of magic tricks.");
        line.fill();

        waitForInput();
        clearText();
        line.delete();

        if (Controls.getDialogue() == 0) {
            nozk.addLoveLevel();
            System.out.println(nozk.getLoveLevel());
            changeName("NOZK");
            paragraph1.setDialogue("Check this out.");
            waitForInput();
            //inserir sprites...

            changeName("YOU");
            paragraph1.setDialogue("I was amazed beyond comprehension.");
            paragraph2.setDialogue("How the hell did he do that!?!?");
            waitForInput();
        }

        if (Controls.getDialogue() == 1) {
            changeName("NOZK");
            nozk.setPicture(Sprites.NOZKSAD.getExpression());
            paragraph1.setDialogue("Booooooo...");
            waitForInput();
        }

        clearText();
        paragraph1.setDialogue("Anyways it's time for class!");
        waitForInput();
        changeName("YOU");
        paragraph1.setDialogue("We spent the rest of the day studying...");
        waitForInput();

    }

    public void day1mic() throws InterruptedException {
        Scene.load("cfa_metropolis.jpg");
        clearText();

        drawCharacter(mike, Sprites.MIKEHAPPY);
        changeName("MIC");
        paragraph1.setDialogue("What's up cadet? My name's MicDrop");
        waitForInput();

        paragraph1.setDialogue("Do you like hip-hop?");

        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Hell yeah!");
        paragraph2.setDialogue("Nah, not a big fan...");
        line.fill();
        waitForInput();
        if (Controls.getDialogue() == 0) {
            mike.addLoveLevel();
            System.out.println(mike.getLoveLevel());
            line.delete();
            paragraph1.setDialogue("Mic turns on the classroom speakers"); //POR MINISAR A DAR AQUI

            waitForInput();

            paragraph1.setDialogue("A symphony written by Apollo himself enters my ears.");
            paragraph2.setDialogue("I had never heard such a beautiful sound in my life before.");
            waitForInput();
            paragraph1.setDialogue("Pretty sugoi, huh...");
            waitForInput();
        }
        if (Controls.getDialogue() == 1) {
            line.delete();

            changeName("MIC");
            mike.setPicture(Sprites.MIKESAD.getExpression());
            paragraph1.setDialogue("Oh... I guess we just have different tastes...");

            waitForInput();

        }
        paragraph1.setDialogue("Well it's time for class!");
        waitForInput();
        changeName("YOU");
        paragraph1.setDialogue("We spent the rest of the day studying...");
        waitForInput();

    }

    /*
   =========================================== DAY 2 ================================================
     */
    public void day2() throws InterruptedException {
        day2scenario1();
        day2lunchtime();
    }

    public void day2Interaction() throws InterruptedException {
        switch (Controls.getDialogue()) {
            case 0:
                paragraph1.setDialogue("YES!! I think, you and I can still get along.");
                waitForInput();
                changeName("YOU");
                paragraph1.setDialogue("I quite like this guy...");
                paragraph2.setDialogue("Well... maybe more than \"like\"...");
                waitForInput();
                break;
            case 1:
                paragraph1.setDialogue("Oh... Nevermind then...");
                waitForInput();
                changeName("YOU");
                paragraph1.setDialogue("I think I might have disappointed him...");
                waitForInput();
                break;
            default:
                break;
        }
    }

    public void day2scenario1() throws InterruptedException {
        clearCharacters();

        Scene.load("codeforall_lobby.jpg");
        paragraph1.setDialogue("Last night with " + dayChoice + " was amazing...");
        transitions.deleteTransition();
        waitForInput();

        paragraph1.setDialogue("I've never felt so connected with anyone before");
        waitForInput();

        paragraph1.setDialogue("Suddenly, I feel a throbbing touch on my shoulder.");
        waitForInput();

        nameText.setName(dayReject);
        if (dayReject.equals("Nozk")) {
            changeName("NOZK");
            drawCharacter(nozk, Sprites.NOZKHAPPY);

        } else {
            changeName("MIC");
            drawCharacter(mike, Sprites.MIKEHAPPY);
        }
        paragraph1.setDialogue("Hey... I didn't see you yesterday...");
        paragraph2.setDialogue("Is everything alright?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Before I could respond, " + dayReject + " passionately interrupted me.");
        waitForInput();

        if (dayReject.equals("Nozk")) {
            changeName("NOZK");
            paragraph1.setDialogue("Do you know the colour of my soul?!");
            waitForInput();

            changeName("YOU");  // É preciso resolver o mau posicionamento da linha
            paragraph1.setDialogue("It's definitely pink!");
            paragraph2.setDialogue("Hmm... Black, I suppose?");
            line.delete();
            line.fill();
            waitForInput();
            if (Controls.getDialogue() == 0) {
                nozk.addLoveLevel();
                nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
                System.out.println(nozk.getLoveLevel());
            }
            if (Controls.getDialogue() == 1) {
                nozk.setPicture(Sprites.NOZKSAD.getExpression()); /// Mudar para triste.
            }
            line.delete();

            textbox.draw();
            changeName("NOZK");

        } else {
            changeName("MIC");
            paragraph1.setDialogue("So... Have you ever watched One Piece?");
            waitForInput();

            changeName("YOU"); // É preciso resolver o mau posicionamento da linha
            paragraph1.setDialogue("OMG YES, I LOVE IT!");
            paragraph2.setDialogue("One piece... of what, exactly?");
            line.delete();
            line.fill();
            waitForInput();
            if (Controls.getDialogue() == 0) {
                mike.setPicture(Sprites.MIKESURPRISED.getExpression());
                mike.addLoveLevel();
                System.out.println(mike.getLoveLevel());
            }
            if (Controls.getDialogue() == 1) {
                mike.setPicture(Sprites.MIKESAD.getExpression());
            }
            line.delete();

            textbox.draw();
            changeName("MIC");
        }
        day2Interaction();
        paragraph1.setDialogue("It's time for classes to start...");
        paragraph2.setDialogue("Ready for another exciting morning.");
        waitForInput();
        transitions = Transitions.END_OF_CLASS;
        transitions.getPicture();
        //sou eu a falar e escolho com quem vou estudar
        //o dia seguinte começa no cenário da pessoa que se escolheu estudar
        //no final do dia repensa-se

    }

    public void day2lunchtime() throws InterruptedException {
        clearCharacters();
        waitForInput();
        transitions.deleteTransition();

        changeName("YOU");
        paragraph1.setDialogue("It's lunch time.");
        paragraph2.setDialogue("The morning classes were really overwhelming!");
        waitForInput();

        drawCharacter(mike, Sprites.MIKEHAPPY);
        paragraph1.setDialogue("I see Mic in the distance, sitting all alone.");
        paragraph2.setDialogue("Should I join him?");
        waitForInput();

        paragraph1.setDialogue("YES UWU");
        paragraph2.setDialogue("I'll leave him be...");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            day2luchtimeWithMic();
        }
        mike.delete();
        paragraph1.setDialogue("The day went on as usual...");
        waitForInput();

        transitions = Transitions.END_OF_CLASS;
        transitions.getPicture();
        waitForInput();
        transitions.deleteTransition();

        paragraph1.setDialogue("Another day comes to an end.");
        waitForInput();

        drawCharacter(nozk, Sprites.NOZKHAPPY);
        paragraph1.setDialogue("I see Nozk in the balcony smoking a funny smelling cigarette.");
        waitForInput();

        paragraph1.setDialogue("Should I talk to him?");
        waitForInput();

        paragraph1.setDialogue("Yes, and maybe smoke too >.<");
        paragraph2.setDialogue("No, I HATE smoking...");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            day2balconyWithNozk();
        }

        paragraph1.setDialogue("Well... I guess it's time to go home now.");
        waitForInput();

        transitions = Transitions.END_OF_DAY;
        transitions.getPicture();
    }


    //------------------------------------------INTERAÇOES -------------------------------------------
    public void day2luchtimeWithMic() throws InterruptedException {
        changeName("MIC");
        paragraph1.setDialogue("Hey there, cadet.");
        paragraph2.setDialogue("Come have lunch with me!");
        waitForInput();

        paragraph1.setDialogue("What are you having?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("WcDonald's, my favourite!!!");
        paragraph2.setDialogue("Grilled veggies from my personal garden!");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            changeName("MIC");
            mike.setPicture(Sprites.MIKEANGRY.getExpression());
            paragraph1.setDialogue("Don't you eat that poison around me!");
            waitForInput();

            mike.delete();
            changeName("YOU");
            paragraph1.setDialogue("MIC got up and left... that's not very nice...");

        }
        if (Controls.getDialogue() == 1) {

            mike.addLoveLevel();
            changeName("MIC");
            mike.setPicture(Sprites.MIKESURPRISED.getExpression());
            paragraph1.setDialogue("You grow your own veggies!?");
            paragraph2.setDialogue("That's so kawaii!!!");
            waitForInput();

            changeName("YOU");
            paragraph1.setDialogue("We spent our lunch time discussing woke topics.");
        }
        waitForInput();
        mike.delete();

    }

    public void day2balconyWithNozk() throws InterruptedException {
        changeName("NOZK");
        paragraph1.setDialogue("Hey cadet, you're just in time!");
        waitForInput();
        paragraph1.setDialogue("I was just preparing for my breakdance competition!");
        paragraph2.setDialogue("CHECK THIS OUT!!!");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Nothing prepared me for what I witnessed");
        paragraph2.setDialogue("In fact, I think nothing ever could...");
        paragraph3.setDialogue("The moves... the swag... the sugoi desu ne kawaii...");
        Thread.sleep(500);
        paragraph4.setDialogue("I was truly flabbergasted...");
        while (gameStatus) {
            nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
            nozk.setPicture(Sprites.NOZKANGRY.getExpression());
            nozk.setPicture(Sprites.NOZKSAD.getExpression());
            nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
            nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
            nozk.setPicture(Sprites.NOZKSAD.getExpression());
            nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        }
        waitForInput();

        changeName("NOZK");
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        paragraph1.setDialogue("So? What do you think?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("I think I just witnessed the rebirth of Michael Jackson O.O");
        paragraph2.setDialogue("I'll just pretend this didn't happen...");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            nozk.addLoveLevel();
            nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
            changeName("NOZK");
            paragraph1.setDialogue("Yeah dude! I'm so freakin' cool!");
            waitForInput();
        }
        if (Controls.getDialogue() == 1) {
            nozk.setPicture(Sprites.NOZKANGRY.getExpression());
            changeName("NOZK");
            paragraph1.setDialogue("You don't get my magnificence...");
            waitForInput();
        }
        nozk.delete();
        changeName("YOU");

    }

//-------------------------------------------------------------------------------------------------------
    /*
    ============================================ DAY 3 ==================================================
     */

    public void day3() {
        day3scenario1();
    }

    public void day3scenario1() {

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









