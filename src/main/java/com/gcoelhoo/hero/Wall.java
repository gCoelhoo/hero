package com.gcoelhoo.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    public Wall(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics){
        LanternaService lanternaService = new LanternaService(graphics);
        lanternaService.setForegroundColor(TextColor.Factory.fromString("#006400"));
        lanternaService.enableModifiers(SGR.BOLD);
        lanternaService.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "#");

//        graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
//        graphics.enableModifiers(SGR.BOLD);
//        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "#");
    }
}
