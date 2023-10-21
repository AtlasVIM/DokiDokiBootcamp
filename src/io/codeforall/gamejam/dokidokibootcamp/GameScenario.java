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

    private static Scene scene;
    private static Textbox textbox;
    private Dialogue paragraph1;
    private Dialogue paragraph2;
    private Dialogue paragraph3;
    private Dialogue paragraph4;
    private static NameText nameText;

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

    public static void setScene(Scene newScene) {
        scene = newScene;
    }

    public static void deleteScene() {
        scene.delete();
    }

    public static void drawScene(Scene scene) {
        textbox.delete();
        nameText.delete();
        scene.draw();
        textbox.draw();
        nameText.draw();

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
        Scene.LOBBY.draw();
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
        nozk.addLoveLevel();
        deleteScene();
        drawScene(Scene.METROPOLIS3);
        clearText();

        drawCharacter(nozk, Sprites.NOZKHAPPY);
        changeName("NOZK");
        paragraph1.setDialogue("Hello cadet! So glad to meet you!");
        waitForInput();

        paragraph1.setDialogue("Do you wanna see a magic trick?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Magic? Sure!");
        paragraph2.setDialogue("Only if you can make yourself disappear! BAKA");
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
            nozk.setPicture(Sprites.NOZKTRICK1.getExpression());
            Thread.sleep(200);
            nozk.setPicture(Sprites.NOZKTRICK2.getExpression());
            Thread.sleep(200);
            nozk.setPicture(Sprites.NOZKTRICK3.getExpression());
            waitForInput();
            //inserir sprites...

            changeName("YOU");
            paragraph1.setDialogue("I was amazed beyond comprehension.");
            paragraph2.setDialogue("How the hell did he do that!?!?");
            waitForInput();
            nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        } else {
            changeName("NOZK");
            nozk.setPicture(Sprites.NOZKSAD.getExpression());
            paragraph1.setDialogue("Damn, you disgrace...");
            waitForInput();
        }
        changeName("NOZK");
        paragraph1.setDialogue("Anyways it's time for class!");
        waitForInput();
        changeName("YOU");
        paragraph1.setDialogue("We spent the rest of the day studying...");
        waitForInput();

    }

    public void day1mic() throws InterruptedException {
        mike.addLoveLevel();
        deleteScene();
        drawScene(Scene.SINCITY1);
        clearText();

        drawCharacter(mike, Sprites.MIKEHAPPY);
        changeName("MIC");
        paragraph1.setDialogue("What's up cadet? My name's MicDrop!");
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
            paragraph1.setDialogue("Oh... I guess you just suck then?");
            paragraph2.setDialogue("Average tiktok enthusiast, cringe smh T_T");

            waitForInput();

        }
        paragraph1.setDialogue("Well it's time for class!");
        waitForInput();
        changeName("YOU");
        paragraph1.setDialogue("We spent the rest of the day studying...");
        paragraph2.setDialogue("Baka data streams, just copy the damn file with right click!");
        paragraph3.setDialogue("T_T");
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
                paragraph2.setDialogue("Well... maybe more than \"like\"...uwu");
                waitForInput();
                break;
            case 1:
                paragraph1.setDialogue("Jesus, alright then...");
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

        deleteScene();
        drawScene(Scene.HALL);
        paragraph1.setDialogue("Yesterday with " + dayChoice + " was really smooth...");
        transitions.deleteTransition();
        waitForInput();

        paragraph1.setDialogue("I've never felt so connected with anyone before!");
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
            paragraph2.setDialogue("Hmm... are you sure you have one? ");
            line.delete();
            line.fill();
            waitForInput();
            if (Controls.getDialogue() == 0) {
                nozk.addLoveLevel();
                nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
                System.out.println(nozk.getLoveLevel());
            } else {
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
            } else {
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
        deleteScene();
        drawScene(Scene.CAFETERIA);
        transitions.deleteTransition();

        changeName("YOU");
        paragraph1.setDialogue("It's lunch time.");
        paragraph2.setDialogue("The morning classes were really overwhelming!");
        paragraph3.setDialogue("All my homies hate iterators x_x");
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

        deleteScene();
        drawScene(Scene.BALCONY);
        drawCharacter(nozk, Sprites.NOZKHAPPY);
        paragraph1.setDialogue("I see Nozk in the balcony smoking a funny smelling cigarette.");
        waitForInput();

        paragraph1.setDialogue("Should I talk to him?");
        waitForInput();

        paragraph1.setDialogue("Yes, and maybe smoke too >.<");
        paragraph2.setDialogue("No, I HATE smoking! BAKA!");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            day2balconyWithNozk();
        }

        paragraph1.setDialogue("Well... I guess it's time to go home now.");
        waitForInput();

    }


    //------------------------------------------INTERAÇOES -------------------------------------------
    public void day2luchtimeWithMic() throws InterruptedException {
        changeName("MIC");
        paragraph1.setDialogue("My favorite cadet!");
        paragraph2.setDialogue("Come have lunch with me!");
        waitForInput();

        paragraph1.setDialogue("What are you having?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("WcDoland's, my favourite!!! UwU");
        paragraph2.setDialogue("Grilled veggies from my personal garden! >.<");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            changeName("MIC");
            mike.setPicture(Sprites.MIKEANGRY.getExpression());
            paragraph1.setDialogue("Don't you eat that poison around me!");
            paragraph2.setDialogue("DON'T YOU KNOW YOU'RE KILLING THE PLANET???");
            waitForInput();

            mike.delete();
            changeName("YOU");
            paragraph1.setDialogue("MIC got up, spit on me and left... that's not very nice...");
            paragraph2.setDialogue("Did I say something wrong? T_T");

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
            paragraph2.setDialogue("Mic is right! Big Veg is monopolizing the industry!");
        }
        waitForInput();
        mike.delete();

    }

    public void day2balconyWithNozk() throws InterruptedException {
        changeName("NOZK");
        paragraph1.setDialogue("Hey cadet, you're just in time!");
        waitForInput();
        paragraph1.setDialogue("I was just preparing for my k-pop dance competition!");
        paragraph2.setDialogue("CHECK THIS OUT!!!");
        waitForInput();
        nozk.setPicture(Sprites.NOZKTRICK3.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKTRICK1.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKSAD.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKTRICK2.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKSAD.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKTRICK3.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKTRICK1.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKSAD.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKTRICK2.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKSAD.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKANGRY.getExpression());
        Thread.sleep(100);
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());

        changeName("YOU");
        paragraph1.setDialogue("Nothing prepared me for what I witnessed");
        paragraph2.setDialogue("In fact, I think nothing ever could...");
        paragraph3.setDialogue("The moves... the swag... the sugoi desu ne kawaii...");
        paragraph4.setDialogue("I was truly flabbergasted...");
        waitForInput();

        changeName("NOZK");
        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        paragraph1.setDialogue("So? Pretty sugoi, huh?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("I think I just witnessed the rebirth of Michael Jackson O.O");
        paragraph2.setDialogue("YAMETEEE, how do I delete what I just saw????");
        line.fill();
        waitForInput();
        line.delete();

        if (Controls.getDialogue() == 0) {
            nozk.addLoveLevel();
            nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
            changeName("NOZK");
            paragraph1.setDialogue("Yeah dude! I'm so sugoi desu neeeeeeee!!");
            paragraph2.setDialogue("You should see what else I can do... UwU");
            waitForInput();
        }
        if (Controls.getDialogue() == 1) {
            nozk.setPicture(Sprites.NOZKANGRY.getExpression());
            changeName("NOZK");
            paragraph1.setDialogue("You don't get my magnificence... hella cringe, cadet.");
            waitForInput();
        }
        nozk.delete();
        changeName("YOU");

    }

//-------------------------------------------------------------------------------------------------------
    /*
    ============================================ DAY 3 ==================================================
     */

    public void day3() throws InterruptedException {
        day3scenario1();
    }

    public void day3scenario1() throws InterruptedException {
        transitions = Transitions.END_OF_DAY;
        transitions.getPicture();
        waitForInput();
        clearCharacters();
        deleteScene();
        drawScene(Scene.CAFETERIA);
        paragraph1.setDialogue("Another exciting morning at CodeForAll.");
        paragraph2.setDialogue("Specially because those two are here (,,>﹏<,,)");
        transitions.deleteTransition();
        waitForInput();
        paragraph1.setDialogue("Sitting on the tables of the cafeteria I see my two lovers.");
        paragraph2.setDialogue("It's almost time for class");
        paragraph3.setDialogue("so I'll only have time to talk to one of them... T_T");
        paragraph4.setDialogue("Why learn Git instead of letting me Git into their hearts...");
        waitForInput();
        paragraph1.setDialogue("Talk to Nozk");
        paragraph2.setDialogue("Talk to Mic");
        line.fill();
        waitForInput();
        line.delete();
        if (Controls.getDialogue() == 0) {
            day3MorningNozk();
        } else {
            day3MorningMic();
        }

        paragraph1.setDialogue("After that, everyone left for class.");
        waitForInput();

        paragraph1.setDialogue("The rest of the day was tenser than usual...");
        waitForInput();

        transitions = Transitions.END_OF_DAY;
        transitions.getPicture();

    }

    public void day3MorningNozk() throws InterruptedException {
        nozk.addLoveLevel();
        drawCharacter(nozk, Sprites.NOZKHAPPY);
        changeName("NOZK");
        paragraph1.setDialogue("If it isn't my favorite Cadet!");
        waitForInput();

        paragraph1.setDialogue("Say, how do you feel about-");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Before he finished his question, Mic suddenly interrupted.");
        waitForInput();
        nozk.delete();

        drawCharacter(mike, Sprites.MIKEANGRY);
        changeName("MIC");
        paragraph1.setDialogue("GETTING ALONG JUST FINE, ARE WE?!");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Oh Mic, I... I can explain!");
        waitForInput();

        changeName("MIC");
        paragraph1.setDialogue("Ever since we met");
        paragraph2.setDialogue("All I wanted was to spend time with you!");
        waitForInput();

        mike.setPicture(Sprites.MIKESAD.getExpression());
        paragraph1.setDialogue("But you just ignore me...");
        paragraph2.setDialogue("I bet you wished I wasn't even here!");
        waitForInput();

        mike.delete();
        drawCharacter(nozk, Sprites.NOZKANGRY);
        changeName("NOZK");
        paragraph1.setDialogue("HEY!");
        waitForInput();

        paragraph1.setDialogue("YOU LEAVE MY LITTLE KITTEN ALONE!");
        waitForInput();

        nozk.delete();
        changeName("YOU");
        paragraph1.setDialogue("Before I knew it, both senpais started fighting over me.");
        waitForInput();

        paragraph1.setDialogue("After a while, Mic went away crying.");
        waitForInput();

        drawCharacter(nozk, Sprites.NOZKANGRY);
        changeName("NOZK");
        paragraph1.setDialogue("AND DON'T COME BACK!");
        waitForInput();

        nozk.setPicture(Sprites.NOZKSAD.getExpression());
        paragraph1.setDialogue("Sorry about that...");
        paragraph2.setDialogue("I didn't want you to see this... violent side of me");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("It's okay, senpai. Mic was a real meanie T_T");
        paragraph2.setDialogue("Actually... I think you should apologize to Mic.");
        line.fill();
        waitForInput();
        changeName("NOZK");

        line.delete();
        if (Controls.getDialogue() == 0) {
            nozk.addLoveLevel();
            System.out.println("MIKE "+mike.getLoveLevel());
            System.out.println("NOZK" + nozk.getLoveLevel());
            nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
            paragraph1.setDialogue("Yeah! You don't deserve all that soyness.");
            waitForInput();
            nozk.setPicture(Sprites.NOZKHORNY.getExpression());
            paragraph1.setDialogue("You know, Cadet-kun... You mean a lot to me...");
            waitForInput();

            changeName("YOU");
            paragraph1.setDialogue("MY HEART DOKI DOKIS LIKE IT NEVER DOKI DOKIED BEFORE!!!");
            waitForInput();

            nozk.delete();

        } else {
            mike.subLoveLevel();
            nozk.subLoveLevel();
            System.out.println("MIKE "+mike.getLoveLevel());
            System.out.println("NOZK" + nozk.getLoveLevel());
            paragraph1.setDialogue("Oh... You really think so?");
            waitForInput();

            paragraph1.setDialogue("I'm sorry Cadet-kun...");
            paragraph2.setDialogue("There's a lot I need to think about right now...");
            waitForInput();

            nozk.delete();
            changeName("YOU");
            paragraph1.setDialogue("Nozk just left...");
            paragraph2.setDialogue("Maybe this was not the response he was expecting from me...");
            waitForInput();
        }

    }

    public void day3MorningMic() throws InterruptedException{
        mike.addLoveLevel();
        drawCharacter(mike, Sprites.MIKEHAPPY);
        changeName("MIC");
        paragraph1.setDialogue("If it isn't my favorite Cadet!");
        waitForInput();

        paragraph1.setDialogue("Say, how do you feel about-");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Before he finished his question, Nozk suddenly interrupted.");
        waitForInput();
        mike.delete();

        drawCharacter(nozk, Sprites.NOZKANGRY);
        changeName("NOZK");
        paragraph1.setDialogue("GETTING ALONG JUST FINE, ARE WE?!");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("Oh Nozk, I... I can explain!");
        waitForInput();

        changeName("NOZK");
        paragraph1.setDialogue("Ever since we met");
        paragraph2.setDialogue("All I wanted was to spend time with you!");
        waitForInput();

        nozk.setPicture(Sprites.NOZKSAD.getExpression());
        paragraph1.setDialogue("But you just ignore me...");
        paragraph2.setDialogue("I bet you wished I wasn't even here!");
        waitForInput();

        nozk.delete();
        drawCharacter(mike, Sprites.MIKEANGRY);
        changeName("MIC");
        paragraph1.setDialogue("HEY!");
        waitForInput();

        paragraph1.setDialogue("YOU LEAVE MY LITTLE KITTEN ALONE!");
        waitForInput();

        mike.delete();
        changeName("YOU");
        paragraph1.setDialogue("Before I knew it, both senpais started fighting over me.");
        waitForInput();

        paragraph1.setDialogue("After a while, Nozk went away crying.");
        waitForInput();

        drawCharacter(mike, Sprites.MIKEANGRY);
        changeName("MIC");
        paragraph1.setDialogue("AND DON'T COME BACK!");
        waitForInput();

        mike.setPicture(Sprites.MIKESAD.getExpression());
        paragraph1.setDialogue("Sorry about that...");
        paragraph2.setDialogue("I didn't want you to see this... violent side of me");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("It's okay, senpai. Nozk was a real meanie T_T");
        paragraph2.setDialogue("Actually... I think you should apologize to Nozk.");
        line.fill();
        waitForInput();
        changeName("MIC");

        line.delete();
        if (Controls.getDialogue() == 0) {
            mike.addLoveLevel();
            System.out.println("MIKE "+mike.getLoveLevel());
            System.out.println("NOZK" + nozk.getLoveLevel());
            mike.setPicture(Sprites.MIKEHAPPY.getExpression());
            paragraph1.setDialogue("Yeah! You don't deserve all that soyness.");
            waitForInput();
            mike.setPicture(Sprites.MIKEHORNY.getExpression());
            paragraph1.setDialogue("You know, Cadet-kun... You mean a lot to me...");
            waitForInput();

            changeName("YOU");
            paragraph1.setDialogue("MY HEART DOKI DOKIS LIKE IT NEVER DOKI DOKIED BEFORE!!!");
            waitForInput();

            mike.delete();

        } else {
            mike.subLoveLevel();
            nozk.subLoveLevel();
            System.out.println("MIKE "+mike.getLoveLevel());
            System.out.println("NOZK" + nozk.getLoveLevel());
            paragraph1.setDialogue("Oh... You really think so?");
            waitForInput();

            paragraph1.setDialogue("I'm sorry Cadet-kun...");
            paragraph2.setDialogue("There's a lot I need to think about right now...");
            waitForInput();

            mike.delete();
            changeName("YOU");
            paragraph1.setDialogue("Mic just left...");
            paragraph2.setDialogue("Maybe this was not the response he was expecting from me...");
            waitForInput();
        }
    }

    // ===================== DAY 4 =======================

    public void day4() throws InterruptedException {
        day4scenario1();
        day4scenario2();
        day4end();
    }

    public void day4scenario1() throws InterruptedException {
        waitForInput();
        clearCharacters();
        deleteScene();
        drawScene(Scene.COFFEETABLE);
        changeName("YOU");
        paragraph1.setDialogue("Ah... nothing like starting the morning ");
        paragraph2.setDialogue("by getting some delicious coffee.");
        transitions.deleteTransition();
        waitForInput();
        paragraph1.setDialogue("I hear strange sounds start coming");
        paragraph2.setDialogue("from the strange door behind me...");
        waitForInput();
        paragraph1.setDialogue("In fact, how long has this door been here!?");
        waitForInput();

        deleteScene();
        drawScene(Scene.BACKROOMS);
        drawCharacter(mike, Sprites.MIKESURPRISED);
        changeName("MIC");
        paragraph1.setDialogue("NANI!? Cadet-kun, you're not supposed to be in here!?");
        waitForInput();
        mike.setPicture(Sprites.MIKEHAPPY.getExpression());
        paragraph1.setDialogue("But actually, I'm glad you're here.");
        paragraph2.setDialogue("I really wanted to talk to you...");
        waitForInput();
        paragraph1.setDialogue("Tomorrow we're gonna have our first Code Break!");
        waitForInput();
        paragraph1.setDialogue("Isn't that exciting!?");
        waitForInput();
        changeName("YOU");
        paragraph1.setDialogue("Code Break, what's that?");
        paragraph2.setDialogue("I'm gonna drink beer until I fall off the balcony >.<");
        line.fill();
        waitForInput();

        line.delete();
        changeName("MIC");
        if(Controls.getDialogue() == 0) {
            mike.setPicture(Sprites.MIKESURPRISED.getExpression());
            paragraph1.setDialogue("YOU DON'T KNOW WHAT THE CODE BREAK IS??");
            waitForInput();
            paragraph1.setDialogue("It's literally the best part of the bootcamp!");
            waitForInput();
            mike.setPicture(Sprites.MIKEHAPPY.getExpression());
            paragraph1.setDialogue("We get to drink, to know each other...");
            waitForInput();
            paragraph1.setDialogue("And to drink some more!");
            waitForInput();
            paragraph1.setDialogue("Isn't that sugoi?");

        } else {
            paragraph1.setDialogue("That's the spirit!!");
            waitForInput();


        }
        mike.setPicture(Sprites.MIKEHORNY.getExpression());
        paragraph1.setDialogue("And don't worry, if you drink too much...");
        paragraph2.setDialogue("I'll be there to catch you ;^)");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("My heart goes DOKI DOKI ultrasupreme 9000.");
        paragraph2.setDialogue("Could this be my chance...?");

        waitForInput();
        paragraph1.setDialogue("I guess I'll find out tomorrow...");
        paragraph2.setDialogue("For now I'll just go to class and finish Car Crash 35.");
        waitForInput();
        transitions = Transitions.END_OF_CLASS;
        transitions.getPicture();

    }

    public void day4scenario2() throws InterruptedException {
        waitForInput();
        deleteScene();
        drawScene(Scene.METROPOLIS3);
        paragraph1.setDialogue("I'm almost finished with Sniper Elite, this time with real bullets!");
        transitions.deleteTransition();
        waitForInput();
        paragraph1.setDialogue("Time for a pee break!");
        waitForInput();
        deleteScene();
        drawScene(Scene.WC);
        paragraph1.setDialogue("I start relieving myself when...");
        waitForInput();
        drawCharacter(nozk, Sprites.NOZKSURPRISED);
        changeName("NOZK");
        paragraph1.setDialogue("Hey Cadet, you fryin' chicken in there?");
        waitForInput();

        nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
        paragraph1.setDialogue("Are you ready for tomorrow's Code Break?");
        waitForInput();

        changeName("YOU");
        paragraph1.setDialogue("You know it Nozk-senpai ;^)");
        paragraph2.setDialogue("Meh");
        line.fill();
        waitForInput();

        if(Controls.getDialogue() == 0) {
            nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
            changeName("NOZK");
            paragraph1.setDialogue("It's gonna be AWESOME!!!");
            waitForInput();
            nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
            paragraph1.setDialogue("Almost as awesome as myself.");
            waitForInput();
        } else {
            nozk.setPicture(Sprites.NOZKSURPRISED.getExpression());
            changeName("NOZK");
            paragraph1.setDialogue("What do you mean \"Meh\"? ");
            waitForInput();
            paragraph1.setDialogue("All the cool people will be there!");
            waitForInput();
            nozk.setPicture(Sprites.NOZKHAPPY.getExpression());
            paragraph2.setDialogue("Like me!");
            waitForInput();

        }
        paragraph1.setDialogue("You know...");
        waitForInput();
        nozk.setPicture(Sprites.NOZKHORNY.getExpression());
        paragraph1.setDialogue("I really wish you could spend it with me...");
        waitForInput();
        changeName("YOU");
        paragraph1.setDialogue("My heart exploded from so much DOKI DOKING");
        waitForInput();
        nozk.delete();
        paragraph1.setDialogue("And with that he left...");
        waitForInput();
        paragraph1.setDialogue("Wait, did he wash his hands...?");
        waitForInput();

    }

    public void day4end(){
        deleteScene();
        drawScene(Scene.LOBBY);
        paragraph1.setDialogue("I feel torn...");
    }
}









