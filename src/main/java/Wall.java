import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    Position position;

    public Wall(int x, int y){
        this.position = new Position(x, y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(this.position.getX(), this.position.getY()), "#");
    }

    public Position getPosition(){
        return position;
    }
}
