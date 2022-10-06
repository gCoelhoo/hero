import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;

    public boolean gameCycleState;
    private boolean canMove;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;

        this.walls = createWalls();
        this.coins = createCoins();

        hero = new Hero(10, 10);

        gameCycleState = true;
    }

    private void moveHero(Position position){
        retrieveCoins();
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position){
        canMove = true;

        for(Wall wall : walls) {
            if(wall.getPosition().equals(position))
                return false;
        }
        return canMove;
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
        graphics.setBackgroundColor(TextColor.Factory.fromString("#A9A9A9"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height),  ' ');

        for(Wall wall : walls)
            wall.draw(graphics);

        hero.draw(graphics);

        for(Coin coin : coins)
            coin.draw(graphics);
    }

    private void retrieveCoins(){
        coins.removeIf(coin -> coin.getPosition().equals(hero.getPosition()));
    }

    private List<Coin> createCoins(){
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            coins.add(new Coin(random.nextInt(width-2)+1, random.nextInt(height-2)+1));
        }
        return coins;
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; ++c){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }

        for(int r = 1; r < height-1; ++r){
            walls.add(new Wall(0, r));
            walls.add(new Wall(width-1, r));
        }

        return walls;
    }
}
