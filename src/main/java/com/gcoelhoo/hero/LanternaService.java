package com.gcoelhoo.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class LanternaService implements LanternaInterface{
    private final TextGraphics graphics;

    public LanternaService(TextGraphics graphics){
        this.graphics = graphics;
    }

    @Override
    public void setForegroundColor(TextColor textColor) {
        graphics.setForegroundColor(textColor);
    }

    @Override
    public void enableModifiers(SGR sgr) {
        graphics.enableModifiers(sgr);
    }

    @Override
    public void putString(TerminalPosition terminalPosition, String string) {
        graphics.putString(terminalPosition, string);
    }
}
