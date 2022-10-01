import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero;
    private boolean gameCycleState;

    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            gameCycleState = true;

            hero = new Hero(10, 10);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) throws IOException{
        System.out.println(key);
        if(key.getKeyType() == KeyType.ArrowLeft){
            hero.moveLeft();
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            hero.moveRight();
        }
        if(key.getKeyType() == KeyType.ArrowUp){
            hero.moveUp();
        }
        if(key.getKeyType() == KeyType.ArrowDown){
            hero.moveDown();
        }

        if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            screen.close();
        }
        if(key.getKeyType() == KeyType.EOF){
            gameCycleState = false;
        }
    }

    private void draw() throws IOException{
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
        while(gameCycleState){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }
}
