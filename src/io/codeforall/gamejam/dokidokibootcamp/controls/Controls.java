package io.codeforall.gamejam.dokidokibootcamp.controls;

import io.codeforall.gamejam.dokidokibootcamp.GameScenario;
import io.codeforall.gamejam.dokidokibootcamp.scenes.ChoiceLine;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import io.codeforall.gamejam.dokidokibootcamp.Game;

import java.awt.*;

public class Controls implements KeyboardHandler{

    private static int dialogue = 0;


    public Controls() {
        init();
    }

    public static int getDialogue() {
        return dialogue;
    }

    private void init() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent select = new KeyboardEvent();
        select.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        select.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(select);

        KeyboardEvent deselect  = new KeyboardEvent();
        deselect.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        deselect.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(deselect);

    }

    @Override
    public synchronized void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_UP:
                if (dialogue > 0) {
                    --dialogue;
                    GameScenario.line.moveUp();
                }

                break;
            case KeyboardEvent.KEY_DOWN:
                if (dialogue < 1) { //MUDAR CONSOANTE NUMERO DE ESCOLHAS.
                    ++dialogue;
                    GameScenario.line.moveDown();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                //Game.chooseDialogue();
                GameScenario.gameStatus = true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_SPACE:
                GameScenario.gameStatus = false;
                break;
        }
    }
}









