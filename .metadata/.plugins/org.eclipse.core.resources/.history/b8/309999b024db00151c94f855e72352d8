package com.jhartz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public abstract class Ball implements BallAction{

	Component field;
	
	Rectangle bounds;
	
	Point location;
	
	Point velocity;
	
	Image image;
	
	Integer size;
	
	public abstract void move() throws BallBelowBoundsException;
	
	public abstract void drawBall(Graphics g);
	
}
