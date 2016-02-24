package com.jhartz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

public abstract class Paddle implements PaddleAction {

	Image image;
	
	Rectangle bounds;
	
	Component field;
	
	Point location;
	
	Integer width;
	Integer height;
	
	public abstract void move();
	
	public abstract void drawPaddle(Graphics g);
}
