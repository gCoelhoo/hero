package com.gcoelhoo.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    public Coin(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics){
        LanternaService lanternaService = new LanternaService(graphics);
        lanternaService.setForegroundColor(TextColor.Factory.fromString("#B8860B"));
        lanternaService.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "o");

//        graphics.setForegroundColor(TextColor.Factory.fromString("#B8860B"));
//        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "o");
    }
}
