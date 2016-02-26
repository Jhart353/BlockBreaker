package com.jhartz;

import java.awt.Graphics;

public interface BallAction {

	public void move() throws BallBelowBoundsException;
	
	public void draw(Graphics g);
}
