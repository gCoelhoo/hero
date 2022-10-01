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
    private int x = 10;
    private int y = 10;
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
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) throws IOException{
        System.out.println(key);
        if(key.getKeyType() == KeyType.ArrowLeft){
            x -= 1;
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            x += 1;
        }
        if(key.getKeyType() == KeyType.ArrowUp){
            y -= 1;
        }
        if(key.getKeyType() == KeyType.ArrowDown){
            y += 1;
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
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
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
