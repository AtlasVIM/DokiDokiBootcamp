import gameobjects.CharacterMike;
import gameobjects.CharacterNozk;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import scenes.Scene;

public class Game {

    public Game(){
    }

    public void start(){
        Scene background = new Scene();
        CharacterMike mike = new CharacterMike(new Picture(800, 310, "resources/dude1.png"));
        CharacterNozk nozk = new CharacterNozk(new Picture(300,315,"resources/dude.png"));

    }


}
