package com.gcoelhoo.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{
    public Hero(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics){
        LanternaService lanternaService = new LanternaService(graphics);

        lanternaService.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        lanternaService.enableModifiers(SGR.BOLD);
        lanternaService.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");

//        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
//        graphics.enableModifiers(SGR.BOLD);
//        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");
    }

    public Position moveUp(){
        return new Position(super.getPosition().getX(),super.getPosition().getY()-1);
    }
    public Position moveDown(){
        return new Position(super.getPosition().getX(),super.getPosition().getY()+1);
    }
    public Position moveLeft(){
        return new Position(super.getPosition().getX()-1, super.getPosition().getY());
    }
    public Position moveRight(){
        return new Position(super.getPosition().getX()+1, super.getPosition().getY());
    }
}
