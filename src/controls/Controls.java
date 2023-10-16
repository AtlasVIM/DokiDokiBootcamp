package controls;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler{

    public Controls() {
    }

    private static int dialogue = 0;

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

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_UP:
                if (dialogue > 0) {
                    --dialogue;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (dialogue < 1000) { //MUDAR CONSOANTE NUMERO DE ESCOLHAS.
                    ++dialogue;
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}









