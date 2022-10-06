import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#DC143C"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "Y");
    }

    public Position move(){
        List<Position> positions = new ArrayList<>();
        //move Left
        positions.add(new Position(this.getPosition().getX()-1, this.getPosition().getY()));
        //move Right
        positions.add(new Position(this.getPosition().getX()+1, this.getPosition().getY()));
        //move Up
        positions.add(new Position(this.getPosition().getX(), this.getPosition().getY()-1));
        //move Down
        positions.add(new Position(this.getPosition().getX(), this.getPosition().getY()+1));

        Random random = new Random();
        int nextPos = random.nextInt(4);

        return positions.get(nextPos);
    }
}
