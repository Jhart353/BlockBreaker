package com.jhartz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class Ball implements BallAction{

	Component field;
	
	Rectangle bounds;
	
	Point location;
	
	Point velocity;
	
	Image image;
	
	Integer size = 15;
	
	public Ball(Image image, Rectangle bounds, Component field) {
		this.image = image;
		this.field = field;
		this.bounds = bounds;
		this.location = new Point((int)(bounds.width + (.5 * size))/2, (int)(bounds.height + (.5 * size))/2);
		this.velocity = new Point(2,4);
	}

	@Override
	public void move() throws BallBelowBoundsException {
		location.x += velocity.x;
		location.y += velocity.y;
		
		if (location.y > bounds.height - size) {
			throw new BallBelowBoundsException();
		}
		if (location.y < bounds.y){
			location.y = bounds.y;
			velocity.y = -velocity.y;
		}
		
		if (location.x > bounds.width - size) {
			location.x = bounds.width - size;
			velocity.x = -velocity.x;
		}
		
		if (location.x < bounds.x) {
			location.x = bounds.x;
			velocity.x = -velocity.x;
		}
	}

	@Override
	public void drawBall(Graphics g) {
		g.drawImage(image, location.x, location.y, size, size, field);
	}
	
	public void changeYVel() {
		velocity.y = -velocity.y;
	}
	
}
