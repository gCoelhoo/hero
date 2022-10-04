import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    public boolean gameCycleState;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;

        hero = new Hero(10, 10);

        gameCycleState = true;
    }

    private void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position){
        if(position.getX() >= 0 && position.getX() < width
        && position.getY() >= 0 && position.getY() < height)
            return true;

        return false;
    }

    public void processKey(KeyStroke key){
        System.out.println(key);
        if(key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
        if(key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
        if(key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        if(key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());

        if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            gameCycleState = false;
        }
        if(key.getKeyType() == KeyType.EOF){
            gameCycleState = false;
        }
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8A2BE2"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height),  ' ');

        hero.draw(graphics);
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
