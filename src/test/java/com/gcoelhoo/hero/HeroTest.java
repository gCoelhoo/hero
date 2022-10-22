package com.gcoelhoo.hero;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HeroTest {
    private Hero hero;
    private Hero spyHero;

    @BeforeEach
    public void setHero(){
        hero = new Hero(0,0);
        spyHero = Mockito.spy(hero);
        spyHero.setPosition(new Position(10,10));
    }

    @Test
    public void moveUp(){
        Position expected = new Position(10,9);

        Position pos = spyHero.moveUp();
        Mockito.verify(spyHero).moveUp();

        Assertions.assertEquals(expected.getY(), pos.getY());
    }
    @Test
    public void moveDown(){
        Position expected = new Position(10,11);

        Position pos = spyHero.moveDown();
        Mockito.verify(spyHero).moveDown();

        Assertions.assertEquals(expected.getY(), pos.getY());
    }

    @Test
    public void moveLeft(){
        Position expected = new Position(9,10);

        Position pos = spyHero.moveLeft();
        Mockito.verify(spyHero).moveLeft();

        Assertions.assertEquals(expected.getX(), pos.getX());
    }
    @Test
    public void moveRight(){
        Position expected = new Position(11,10);

        Position pos = spyHero.moveRight();
        Mockito.verify(spyHero).moveRight();

        Assertions.assertEquals(expected.getX(), pos.getX());
    }

    @Test
    public void draw(){
        TextGraphics graphics = Mockito.mock(TextGraphics.class);

        hero.draw(graphics);
    }
}
