package com.gcoelhoo.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

public interface LanternaInterface {
    void setForegroundColor(TextColor textColor);
    void enableModifiers(SGR sgr);
    void putString(TerminalPosition terminalPosition, String string);
}
